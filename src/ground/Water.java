package ground;

import build.Building;

public class Water extends Field {

	public Water(int xPos,int yPos){
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
