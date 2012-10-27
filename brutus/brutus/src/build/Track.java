package build;

import ground.Field;

public class Track extends Path {
	
	public Track(Field place) {
		super(place);
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getXSize() {
		
		return 1;
	}

	public int getYSize() {
		return 1;
	}
	public boolean isBurning() {
		return false;
	}

	/**
	 * brennt nicht...
	 */
	public void setBurning(boolean b) {
	}

}
