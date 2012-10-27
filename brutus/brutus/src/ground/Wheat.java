package ground;

import build.Building;

public class Wheat extends Field {

	public Wheat(int xPos,int yPos){
		super(xPos, yPos);
		
	}
	public Wheat(int xPos,int yPos,int xSize,int ySize){
		super(xPos, yPos, xSize, ySize);
	}
	public Wheat(int xPos,int yPos,Building b){
		super(xPos, yPos, b);
	}
	/**
	 * es koennen insbesonders Weizenfarmen gebaut werden.
	 */
	public boolean isBuildingCompatible(Building b) {
		//TODO
		return true;
	}
	public boolean istBebaubar() {
		return true;
	}

}
