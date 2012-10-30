package ground;

import buildings.Buildings;

public class Marble extends Field {

	public Marble(int xPos,int yPos){
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
