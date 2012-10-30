package ground;

import buildings.Buildings;

public class Stones extends Field {

	public Stones(int xPos,int yPos){
		super(xPos, yPos);
		
	}
	public boolean setBuilding(Buildings b){
		return false;
	}
	public boolean isBuildingCompatible(Buildings b){
		return false;
	}
	public Buildings removeBuilding(){
		return null;
	}
	public boolean istBebaubar(){
		return false;
	}

}
