package buildings;

import ground.Field;

public class BuildingsRaw extends Building {
	private boolean needsStreet;
	private int initAttr;
	private int plusAttr;
	private int stepAttr;
	private int maxAttrRegion;
	private int maxWorkers;
	private int costs;

	public BuildingsRaw(String name, int sizeX, int sizeY, boolean needsStreet, 
			int initAttr, int plusAttr, int stepAttr, int maxAttrRegion, 
			int maxWorkers, int costs) {
		super(name, sizeX, sizeY);
		this.needsStreet = needsStreet;
		this.initAttr = initAttr;
		this.plusAttr = plusAttr;
		this.stepAttr = stepAttr;
		this.maxAttrRegion = maxAttrRegion;
		this.maxWorkers = maxWorkers;
		this.costs = costs;
	}
	
	public BuildingsRaw(Building b, boolean needsStreet, int initAttr, 
			int plusAttr, int stepAttr,	int maxAttrRegion, int maxWorkers,
			int costs) {
		super(b.getName(), b.getSizeX(), b.getSizeY());
		this.needsStreet = needsStreet;
		this.initAttr = initAttr;
		this.plusAttr = plusAttr;
		this.stepAttr = stepAttr;
		this.maxAttrRegion = maxAttrRegion;
		this.maxWorkers = maxWorkers;
		this.costs = costs;
	}

	/**
	 * liefert zur�ck, ob eine Stra�enanbindung ben�tigt wird
	 * @return needsStreet Stra�enanbindung ben�tigt?
	 */
	public boolean needsStreet() {
		return needsStreet;
	}

	/**
	 * liefert die initiale Attraktivit�t zur�ck
	 * @return initAttr initiale Attraktivit�t
	 */
	public int getInitAttr() {
		return initAttr;
	}

	/**
	 * liefert zur�ck, TODO
	 * @return needsStreet TODO
	 */
	public int getPlusAttr() {
		return plusAttr;
	}

	/**
	 * liefert zur�ck, TODO
	 * @return needsStreet TODO
	 */
	public int getStepAttr() {
		return stepAttr;
	}

	/**
	 * liefert zur�ck, TODO
	 * @return needsStreet TODO
	 */
	public int getMaxAttrRegion() {
		return maxAttrRegion;
	}

	/**
	 * liefert die maximale Anzahl der Arbeiter zur�ck
	 * @return maxWorkers maximale Anzahl der Arbeiter
	 */
	public int getMaxWorkers() {
		return maxWorkers;
	}

	/**
	 * liefert die Kosten des Geb�udes zur�ck
	 * @return costs Kosten des Geb�udes
	 */
	public int getCosts() {
		return costs;
	}
}