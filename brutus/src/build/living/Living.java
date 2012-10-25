package build.living;


import build.Building;
import game.God;
import ground.Field;


public abstract class Living extends Building {

	int civilians=0, criminality = 0,illnessFactor = 0,dishes = 0,furniture = 0, oil = 0, vine = 0, popularity = 0,entertainment = 0,religion=0;
	
	public Living(Field place,int startCivilians) {
		super(place);
		civilians = startCivilians;
	}
	
	public double getPrice() {
		return 0;
	}
	public int getCivilianCount() {
		return civilians;
	}
	public int getCriminality() {
		return criminality;
	}
	public abstract int updateCriminality(Field[][] map);
	
	public int getIllnessFactor() {
		return illnessFactor;
	}
	public abstract int updateIllnessFactor(Field[][] map);
	
	public int getDishes() {
		return dishes;
	}
	public abstract int updateDishes(int d);
	
	public int getFurniture() {
		return furniture;
	}
	public abstract int updateFurniture(int f);
	
	public int getOil() {
		return oil;
	}
	public abstract int updateOil(int o);
	
	public int getVine() {
		return vine;
	}
	public abstract int updateVine(int v);
	
	public abstract int getMaxCivilians();
	public abstract boolean setCivilianCount(int count);
	public abstract int getWealth();
	
	
	public int getPopularity(){
		return popularity;
	}
	public abstract int updatePopularity(Field[][] map);
	
	public int getEntertainment(){
		return entertainment;
	}
	public abstract int updateEntertainment(Field[][] map);
	
	public  int getReligion(){
		return religion;
	}
	public abstract int updateReligion(Field[][] map,God[] g);
	
	public abstract boolean canRiseUp();
	public abstract int  getReplacementID();
	public abstract int getClassID();
}
