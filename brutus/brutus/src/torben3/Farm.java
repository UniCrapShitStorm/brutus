package torben3;
import java.util.ArrayList;


public class Farm extends Production {

	public Farm(int a, char shortcut){
		if (shortcut == 'g'){
			this.bezeichnung = "Getreidefarm";
			this.product = "Weizen";
			this.name = "Getreidefarm"+a;
		}
		else 
		if (shortcut == 'o'){
			this.bezeichnung = "Obstfarm";
			this.product = "Obst";
			this.name = "Obstfarm"+a;
		}
		else 
		if (shortcut == 'l'){
			this.bezeichnung = "Olivenfarm";
			this.product = "Oliven";
			this.name = "Olivenfarm"+a;
		}
		else 
		if (shortcut == 'w'){
			this.bezeichnung = "Weinberg";
			this.product = "Wein";
			this.name = "Weinberg"+a;
		}
		this.productHowMany = 1;
		this.time = 25;
		this.restTime = 0;
		//this.costs = 150 ;
		//this.shortcutshortcut;
		this.workerNeed = 10;
		this.workerGet = 0;
		this.needWhat ="";
		this.needHowMany = 0;	
	}
	
	
	public static void build(ArrayList<Buildings> buildings, Stats stats,char ch)
	{
		int c= buildings.size();
		if (stats.money>= 250)
		{
			buildings.add(c, new Farm(c, ch)); 
			buildings.get(c).feedback();
			stats.workerNeeded+=buildings.get(c).workerNeed; 
			c++;
			stats.sellMoney(250);				
		}	
		else System.out.println("du hast nicht genug Geld");

		}
	
	}

