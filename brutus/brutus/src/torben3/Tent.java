package torben3;
import java.util.ArrayList;

//

public class Tent extends Buildings {
	int level;
	int tax;
	//String[] need = new String[7];
	String[] need = {"Wasser", "Nahrung", "","","","",""};
	int love;
	
	public Tent(int a){
		this.bezeichnung = "Zelt";
		//this.costs = 5;
		//this.shortcut = 't';
		this.workerNeed = 5; // ^= wieviele freie Pl‰tze
		this.workerGet = 0;		// ^= Wieviele Bewohner
		this.level = 0;
		this.tax = 0;
		//need = {"Wasser", "Nahrung", "","","","","",""};
		//this.need[1] = "Nahrung";
		this.name = "Zelt"+a;
		this.love = 30;
	}
	
	public String toString(){
		String needAll = "";
		for (int i = 0; i < this.need.length; i++) {
			if (need[i]!=null){
			needAll += need[i]+" ";
			}
		}		
		return "\n **Info "+this.name+"**\nDieses "+this.bezeichnung+" beherbert "+this.workerGet+" Bewohner, " +
				"\nund hat bereits "+this.tax+" Dinar Steuern eingebracht. " +
						"\nUm zu wachsen braucht es "+needAll;
	}
	
		
	public int getLove(){
		return love;
	}
	
	public static void leveling(ArrayList<Buildings> buildings, int a){
		((Tent)buildings.get(a)).level+=1;	
		System.out.print(buildings.get(a).name+" ist zu ");
		SwingGui.centerText.append("\n"+buildings.get(a).name+" ist zu ");
		
		if (((Tent)buildings.get(a)).level==1){
			((Tent)buildings.get(a)).need[0]="Zugang zu einer Religion";
			((Tent)buildings.get(a)).need[1]="Zugang zu einer Schule";
			buildings.get(a).bezeichnung="groﬂes Zelt";
			buildings.get(a).workerNeed+=5;
			buildings.get(a).name="groﬂes Zelt"+a;
		}
		System.out.print(buildings.get(a).name+" gewachsen \n");
		SwingGui.centerText.append(buildings.get(a).name+" gewachsen");
	}
	
	public static void levelUp(ArrayList<Buildings> buildings, Resources resources){
		String s ="leer";
		int a;
		for (int i = 0; i < buildings.size(); i++) {
			 a=0;
			if (buildings.get(i) instanceof Tent){
				for (int j = 0; j < 7; j++) {
					if (((Tent)buildings.get(i)).need[j] == "Wasser") {
						s = "Wasser";
					}
					else
					if (((Tent)buildings.get(i)).need[j] == "Nahrung") {
						s = "Nahrung";
					}
					else
					if (((Tent)buildings.get(i)).need[j] == "") {
						a+=1;
					}
						
					if (s == "Wasser" && resources.howManyWater>0){
						resources.howManyWater-=1;
						((Tent)buildings.get(i)).need[j] = "";
						a+=1;
						//s ="leer";
					}
					if (s == "Nahrung"){
						if (resources.wheat>0){
							resources.wheat-=1;
							((Tent)buildings.get(i)).need[j] = "";
							 //s ="leer";
							a+=1;
						}
						else
						if (resources.fruits>0){
							resources.fruits-=1;
							((Tent)buildings.get(i)).need[j] = "";
							//s ="leer";
						}
					}
				}
				if (a == 6){
					Tent.leveling(buildings, i);
				}
			}
		}
	}
	
	public static void build(ArrayList<Buildings> buildings, Stats stats){
		int c= buildings.size();
		if (stats.money>= 5){
			buildings.add(c, new Tent(c));
			buildings.get(c).feedback();
			stats.emptyPlaces+=buildings.get(c).workerNeed; 
			c++;
			stats.sellMoney(5);		
			
		}
		else{ System.out.println("du hast nicht genug Geld");
		SwingGui.centerText.append("du hast nicht genug Geld");
		}
	}

}
