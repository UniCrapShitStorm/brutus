package torben3;
import javax.swing.*;

public class Buildings {

	
	String bezeichnung;
	String name;
	String s = "";

	//static int costs;
	//char shortcut;
	int workerNeed;
	int workerGet;
	SwingGui gui;
	
	public void feedback(){
		//System.out.println("Du hast "+name+" gebaut!");
		
		SwingGui.info = SwingGui.info+name+", ";
		System.out.println("Du hast "+name+" gebaut!");

	}
	
	
//	public String toString(){		
//	return "\n **Info "+this.name+"**\nIn dieser/m "+this.bezeichnung+" arbeiten "+this.workerGet+" Bewohner, " +
//			"\nes werden noch "+this.workerNeed+ " weitere Kräfte gebraucht! \n Die aktuelle Produktion ist zu "+(this.time/this.restTime)+" % fertig!";
//	}
	
}
