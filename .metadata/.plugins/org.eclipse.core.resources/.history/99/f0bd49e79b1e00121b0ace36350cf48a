package build.living;

import game.God;
import ground.Field;

public class LuxPalace extends Living {
	private boolean burning;
	public static final int MAX_CIVS = 200 ,WEALTH = 1750,CLASS_ID = 20;
	

	public LuxPalace(Field place,int startCivilians) {
		super(place,startCivilians);
	}
	
	public int getXSize() {
		return 4;
	}

	public int getYSize() {
		return 4;
	}

	public boolean isBurning() {
		return burning;
	}
	public int getMaxCivilians() {
		return MAX_CIVS;
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

	@Override
	public void setBurning(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public int getClassID() {
		return CLASS_ID;
	}
	public int getReplacementID() {
		return -1;
	}
}
