package torben3;
import java.util.ArrayList;


public class Production extends Buildings {

	String product;
	int productHowMany;
	int time;
	int restTime;
	String needWhat ;
	int needHowMany;	
	
	public String toString(){		
		return "\n **Info "+this.name+"**\nIn dieser/m "+this.bezeichnung+" arbeiten "+this.workerGet+" Bewohner, " +
				"\nes werden noch "+this.workerNeed+ " weitere Kräfte gebraucht! \n Die aktuelle Produktion ist zu "+(100/this.time*this.restTime)+" % fertig!";
		}
	
	public static void producting(ArrayList<Buildings> buildings, Resources resources)
	{
		for (int i = 0; i < buildings.size(); i++) {
			if (buildings.get(i).bezeichnung=="Getreidefarm"){
				((Production)buildings.get(i)).restTime+=buildings.get(i).workerGet*0.5;
				//int k = ((Production)buildings.get(i)).time;
				if (((Production)buildings.get(i)).restTime >= ((Production)buildings.get(i)).time) {
					resources.wheat+=1;
					System.out.println("\t... ein Weizenfeld wurde abgeerntet.");
					((Production)buildings.get(i)).restTime=0;
				}
			}
		}
	}

}
