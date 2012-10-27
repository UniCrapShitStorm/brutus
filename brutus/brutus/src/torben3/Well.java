package torben3;
import java.util.ArrayList;


public class Well extends Buildings  {

	//String bezeichnung;
	//String name;
	int radius;
	
	
	public Well(int a){

		this.bezeichnung = "Ziehbrunnen";
		this.name = "Ziehbrunnen"+a;
		this.workerNeed = 0;
		this.workerGet = 0;
		this.radius = 5;
	}
	

	public String toString(){
		return "\n **Info "+this.name+"**\nDieser Ziehbrunnen versorgt die umliegenden Gebäude mit Grundwasser";
	}


	public static void build(ArrayList<Buildings> buildings, Stats stats,Resources resources){
		int c= buildings.size();
		if (stats.money>= 20){
			buildings.add(c, new Well(c));
			buildings.get(c).feedback();
			c++;
			stats.sellMoney(20);	
			resources.howManyWater+=5;
			
		}
		else System.out.println("du hast nicht genug Geld");
	}

}
