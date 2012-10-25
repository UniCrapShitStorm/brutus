package build.living;

import game.God;
import ground.Field;

public class SmallTent extends Living {
	private boolean burning;
	public static final int MAX_CIVS = 5,WEALTH = 5,CLASS_ID = 1;
	

	public SmallTent(Field place,int startCivilians) {
		super(place,startCivilians);
	}
	
	public int getXSize() {
		return 1;
	}

	public int getYSize() {
		return 1;
	}

	public boolean isBurning() {
		return burning;
	}

	public void setBurning(boolean b) {
		// TODO Auto-generated method stub

	}

	
	public int getMaxCivilians() {
		return MAX_CIVS;
	}

	@Override
	public int updateCriminality(Field[][] map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateIllnessFactor(Field[][] map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateDishes(int d) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateFurniture(int f) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOil(int o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateVine(int v) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean setCivilianCount(int count) {
		if(count > MAX_CIVS)
			return false;
		else
		civilians = count;
		return true;
	}

	public int getWealth() {
		return WEALTH;
	}

	@Override
	public int updatePopularity(Field[][] map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateEntertainment(Field[][] map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateReligion(Field[][] map, God[] g) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean canRiseUp() {
		// TODO Auto-generated method stub
		return false;
	}
/**
 * Das Kleine Zelt hat als einziges 2 nachfolger: kleine Hütte und großes Zelt
 * evtl über random machen...
 */
	public int getReplacementID() {
		return -2;
	}

	public int getClassID() {
		return CLASS_ID;
	}

}
