package ground;

import build.Building;

public class Marble extends Field {

	public Marble(int xPos,int yPos){
		super(xPos, yPos);
		
	}
	public boolean setBuilding(Building b){
		return false;
	}
	public boolean isBuildingCompatible(Building b){
		return false;
	}
	public Building removeBuilding(){
		return null;
	}
	public boolean istBebaubar(){
		return false;
	}

}
