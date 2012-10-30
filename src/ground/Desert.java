package ground;

import buildings.Buildings;

public class Desert extends Field {

	public Desert(int xPos,int yPos){
		super(xPos, yPos);
		
	}
	public Desert(int xPos,int yPos,int xSize,int ySize){
		super(xPos, yPos, xSize, ySize);
	}
	public Desert(int xPos,int yPos,Buildings b){
		super(xPos, yPos, b);
	}
	/**
	 * hier keine farmen....
	 */
	public boolean isBuildingCompatible(Buildings b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean istBebaubar() {
		// TODO Auto-generated method stub
		return true;
	}

}
