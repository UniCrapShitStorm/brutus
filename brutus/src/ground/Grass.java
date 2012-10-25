package ground;

import build.Building;

public class Grass extends Field {

	public Grass(int xPos,int yPos){
		super(xPos, yPos);
		
	}
	public Grass(int xPos,int yPos,int xSize,int ySize){
		super(xPos, yPos, xSize, ySize);
	}
	public Grass(int xPos,int yPos,Building b){
		super(xPos, yPos, b);
	}
	
	/**
	 * es koennen Farmen hier gebaut werden
	 */
	public boolean isBuildingCompatible(Building b) {
		// TODO Auto-generated method stub
		return true;
	}


	public boolean istBebaubar() {
		return true;
	}

}
