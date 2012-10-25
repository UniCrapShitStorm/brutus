package build;

import ground.Field;

import java.io.Serializable;

public abstract class Building implements Serializable{
	final Field place;
	public Building(Field place){
		this.place = place;
	}
	public Field getPlace(){
		return place;
	}
	abstract public double getPrice();
	abstract public int getXSize();
	abstract public int getYSize();
	abstract public boolean isBurning();
	abstract public void setBurning(boolean b);
	
}
