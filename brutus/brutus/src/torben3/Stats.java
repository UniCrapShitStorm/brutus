package torben3;

public class Stats {

	 int people;			// zaehlt Bewohner
	 int emptyPlaces;	// zaehlte leere Schlafplaetze
	 int workerNeeded;	// zaehlt wieviele Arbeiter gebraucht werden
	 int day;
	 int money;
	 int love;
	 int jobless;
	 int centerTextCount = 1;
	

	
	public Stats(){
		people = 0;		
		emptyPlaces = 0;	
		workerNeeded = 0;	
		day =1;
		money = 2000;
		love = 60;
		jobless = 0;
	}
	
	public void overview(){
		if(SwingGui.info.equals(""))
			SwingGui.info="nichts";
		
		SwingGui.centerText.append("\n"+" **Tag "+day+"**");
		SwingGui.centerText.append("\n"+"Du hast "+money+" Dinar und "+people+" Bewohner in deiner Stadt ");
		SwingGui.centerText.append("\n"+"Druecke (i)nfo, B(e)rater, (o)ptionen oder (b)auen!\n ");
		//SwingGui.centerText.append("\n Du hast "+SwingGui.info+" gebaut! (Timermessage)");
		System.out.println(" **Tag "+day+"**");
		System.out.println("Du hast "+money+" Dinar und "+people+" Bewohner in deiner Stadt ");
		System.out.println("Druecke (i)nfo, B(e)rater, (o)ptionen oder (b)auen!\n ");
		System.out.println(SwingGui.info+" (Timermessage)");
		SwingGui.informationLabel.setText("Du hast "+ SwingGui.info+" gebaut!");
		SwingGui.info = "";
	}
	
	public  int howMoney(){
		return money;
	}

	public void getMoney(int i){
		money+=i;
	}
	
//	public int getLove(int i){
//		return love;
//	}
	
	public  void sellMoney(int i){
		money-=i;
	}
}
