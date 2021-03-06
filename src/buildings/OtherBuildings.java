package buildings;

public class OtherBuildings extends Buildings {
	private boolean needsStreet;
	private int initAttr;
	private int plusAttr;
	private int stepAttr;
	private int maxAttrRegion;
	private int attraction;
	private int maxWorkers;
	private int costs;

	public OtherBuildings(String name, int sizeX, int sizeY, boolean needsStreet, 
			int initAttr, int plusAttr, int stepAttr, int maxAttrRegion, int attraction,
			int maxWorkers, int costs) {
		super(name, sizeX, sizeY);
		this.needsStreet = needsStreet;
		this.initAttr = initAttr;
		this.plusAttr = plusAttr;
		this.stepAttr = stepAttr;
		this.maxAttrRegion = maxAttrRegion;
		this.attraction = attraction;
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
	 * liefert zur�ck, TODO
	 * @return needsStreet TODO
	 */
	public int getAttraction() {
		return attraction;
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
