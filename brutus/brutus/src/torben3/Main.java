package torben3;
import java.io.BufferedReader;
import java.lang.Math;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static ArrayList<Buildings> buildings;
	static Stats stats = new Stats();
	static Resources resources = new Resources();
	
	public void menue(){
		// Menue aus Main ausglieder!
		
	}
	
	
	public static void nextDay(ArrayList<Buildings> buildings, Stats stats)
	{
		stats.day++;
		// Zuwanderer____________________________
		if (stats.love>=30 && stats.emptyPlaces>0){
			int rand = (int) (Math.random() * (stats.emptyPlaces));	
			rand = rand * stats.love /100;
			stats.people+=rand;
			stats.emptyPlaces-=rand;
			System.out.println("");
			stats.jobless+=rand;
	
			System.out.println("... Es snd "+rand+" neue Zuwanderer in deine Stadt gekommen!\n");
			SwingGui.centerText.append("\n"+"... Es sind "+rand+" neue Zuwanderer in deine Stadt gekommen!\n");

			for (int i = 0; i < buildings.size(); i++) {
				if (buildings.get(i).bezeichnung=="Zelt" && buildings.get(i).workerNeed>0){
					if (rand < buildings.get(i).workerNeed){
						buildings.get(i).workerGet+=rand;
						buildings.get(i).workerNeed-=rand;
					} else{
					rand-=buildings.get(i).workerNeed;
					buildings.get(i).workerGet+=buildings.get(i).workerNeed;
					buildings.get(i).workerNeed=0;
					}
				}
			}
		}
		// /Zuwanderer____________________________
		
		// Jobvergabe______________
		//System.out.println("Arbeitslos:"+stats.jobless);
		for (int i = 0; i < buildings.size(); i++) {
			if (buildings.get(i).bezeichnung!="Zelt" && buildings.get(i).workerNeed>0){
				if (stats.jobless < buildings.get(i).workerNeed){
					buildings.get(i).workerGet+=stats.jobless;
					buildings.get(i).workerNeed-=stats.jobless;
					stats.jobless=0;
				} else{
					stats.jobless-=buildings.get(i).workerNeed;
				buildings.get(i).workerGet+=buildings.get(i).workerNeed;
				buildings.get(i).workerNeed=0;
				}
			}
		}		
		// /Jobvergabe________________
		
		//stats.jobless
		
		//Love down	
		int newLove =0;
		int howMany = 0;
		for (int i = 0; i < buildings.size(); i++) {
			if (buildings.get(i) instanceof Tent){
				howMany++;
				newLove+=((Tent)buildings.get(i)).love;
			}
		}
		if (howMany == 0) { 
			newLove = 0; 
		}
		else {
			newLove = newLove / howMany;
			if (newLove > stats.love){
				stats.love += (newLove * 0.05);
			}
			else 	stats.love=stats.love+(int)((-newLove)*0.05);			
		}
		if (stats.jobless>(stats.people/10)) {
			stats.love-=5;
		}
		//System.out.println("beliebtheit =" + stats.love);
		Production.producting(buildings,resources);
		//Zelte leveln auf?
		Tent.levelUp( buildings, resources);
		stats.overview();	
	}
	
	public static char consolenEingabe(){
		String string1 = " ";
		try {
			BufferedReader in = new BufferedReader( new InputStreamReader(System.in) );
			string1 = in.readLine();
		}
		catch( IOException ex ) {
			System.out.println( ex.getMessage() );
		}
		if (string1.length()>0){
			return string1.charAt(0);
		}
		else
			return '_';
		
	}
		
	public static void main(String[] args) {	
		
		SwingGui g = new SwingGui();
		g.createAndShowGUI();
		
		 buildings = new ArrayList<Buildings>();
		char input;
		char input2;
//		
		class Timer extends Thread{
			public Timer(){
				this.setDaemon(true);
			}
		
			public void run(){
				while(true)
				{
					try{
						
						Thread.sleep(5000);
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					Main.nextDay(buildings, stats);
				}
			}
		}
		new Timer().start();
				
		stats.overview();	
		while(true)
		{
			while(true)
			{	
				input = Main.consolenEingabe();
					if (input=='i')
					{
						if (buildings.size()!=0){
							System.out.println("Wozu willst du eine Info?");
							System.out.println("(r)essourcen ");
							for(int i = 0; i< buildings.size(); i++){
								if (buildings.get(i)!=null){
									System.out.print("("+i+") " + buildings.get(i).name +"\t");	
								} 
								else{ break;}
							}
							input2 = Main.consolenEingabe();
							int i = (int)  input2 -48;
							if (input2=='r'){	
								System.out.println("Eure Stadt verfügt über:\n"+resources.wheat+" Weizen\t"+resources.fruits+" Obst\t"+resources.olives+" Oliven \t"+resources.winefruits+" Weinreben" );
							}
							else if (i>=0 && i<buildings.size()+1)
							{
								//int i = (int)  string2.charAt(0) -48;
								System.out.println(i);
//								if (buildings.get(i) instanceof Production){
//									System.out.println(buildings.get(i).toString());
//								} else
								System.out.println(buildings.get(i).toString());								
							}
							else System.out.println("ungueltige Eingabe");							
						}
						else System.out.println("Du hast noch keine Gebäude");
					} else
					if (input=='b')
					{
						System.out.println("\n **Was willst du bauen?**\n(z)elt \t (g)etreidefarm\t (o)bstfarm\t (w)einberg \to(l)ivenfarm \tzieh(b)runnen");
						input2 = Main.consolenEingabe();
						if (input2=='z') // t for tent
						{ 
							Tent.build(buildings, stats);
						}
						else
						if (input2=='b') // t for tent
						{ 
							Well.build(buildings, stats, resources);
						}
						else
						if  (input2=='g' || input2=='o'  || input2=='l'|| input2=='w' )
						{
							Farm.build(buildings, stats, input2);
						}
						else System.out.println("ungueltige Eingabe");											
					}
					else 
					if  (input=='o'){
						System.out.println("Optionen noch nicht implementiert");
					}
					else 
					if  (input=='e'){
						System.out.println("Eure Stadt hat: \n"+(100/(stats.people+1)*(stats.jobless))+"% Arbeitslose\t"+stats.love+" Beliebtheit\t"+resources.howManyWater+" freie Wasseranschlüsse");
					}else 
					if  (input=='x'){
						return;
					}
					else  System.out.println("ungueltige Eingabe");
			}

		}		

	}

}