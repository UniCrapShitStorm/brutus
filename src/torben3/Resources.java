
package torben3;

public class Resources {
//	 int wheat;			// zaehlt Weizen
//	 int fruits;	// zaehlt Obst
//	 int olives;		// zaehlt Oliven
//	 int winefruits;	// zählt Weinreben
	//public static final int WEIZEN=0,OBST=1;
	String[] kinds = {"Weizen","Obst","Fisch","Oliven","Weinreben","Ton","Oel","Wein","Geschirr","Marmor","Eisen", "Waffen" };
	int[] prices = {10,10,10,10,10,10,15,15,15,20,15,25}; 
	int howManyWater;
	int money;
	Resource[] resourceList = new Resource[kinds.length];
	

	
	public Resources(int startMoney){
		howManyWater = 0;
		this.money = startMoney;
		for (int i = 0; i <kinds.length; i++) {
			resourceList[i] = new Resource(kinds[i],prices[i],0);
		}
	}

	public int getMoney(){
		return money;
	}
	
	public void setMones(int i){
		money += i;
	}
	
	public boolean checkMoney(int i){
		if (money-i>=0){
			return true;
		}
		else 
			return false;
	}

	public int getWheat(){
		return resourceList[0].number;
	}
	
	public void setWheat(int i){
		resourceList[0].number += i;
	}
	
	public int getFruits(){
		return resourceList[1].number;
	}
	
	public void setFruits(int i){
		resourceList[1].number += i;
	}

	public int getFish(){
		return resourceList[2].number;
	}
	
	public void setFish(int i){
		resourceList[2].number += i;
	}
	
	public int getOlives(){
		return resourceList[3].number;
	}
	
	public void setOlives(int i){
		resourceList[3].number += i;
	}
	
	public int getWineFruits(){
		return resourceList[4].number;
	}
	
	public void setWineFruits(int i){
		resourceList[4].number += i;
	}
	
	public int getTon(){
		return resourceList[5].number;
	}
	
	public void setTon(int i){
		resourceList[5].number += i;
	}
		
	public int getOil(){
		return resourceList[6].number;
	}
	
	public void setOil(int i){
		resourceList[6].number += i;
	}
	
	public int getWine(){
		return resourceList[7].number;
	}
	
	public void setWine(int i){
		resourceList[7].number += i;
	}
	
	public int getDishes(){
		return resourceList[8].number;
	}
	
	public void setDishes(int i){
		resourceList[8].number += i;
	}
	
	public int getMarble(){
		return resourceList[9].number;
	}
	
	public void setMarble(int i){
		resourceList[9].number += i;
	}
	
	public int getIron(){
		return resourceList[10].number;
	}
	
	public void setIron(int i){
		resourceList[10].number += i;
	}
	
	public int getWeapon(){
		return resourceList[11].number;
	}
	
	public void setWeapon(int i){
		resourceList[11].number += i;
	}
	
	
	public int[] getPrices(){
		int[] i = new int[kinds.length];
		for (int j = 0; j < kinds.length; j++) {
			i[j] = resourceList[j].price;
		}
		return i;
	}
	
	public void setPrice(int[] i){
		for (int j = 0; j < kinds.length; j++) {
			resourceList[j].price = i[j];
		}	
	}
	
}