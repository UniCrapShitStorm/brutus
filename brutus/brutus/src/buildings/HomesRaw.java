package buildings;

import java.util.ArrayList;

public class HomesRaw extends Building {
	private int id;
	private int maxInhabitants;
	private int wealth;
	private ArrayList<String> needs;
	
	public HomesRaw(String name, int sizeX, int sizeY, int id, int maxInhabitants,
			int wealth, ArrayList<String> needs) {
		super(name, sizeX, sizeY);
		this.id = id;
		this.maxInhabitants = maxInhabitants;
		this.wealth = wealth;
		this.needs = needs;
	}

	/**
	 * liefert die ID des Wohnhauses zur�ck
	 * @return id ID des Wohnhauses
	 */
	public int getId() {
		return id;
	}

	/**
	 * liefert die maximalen Einwohner des Wohnhauses zur�ck
	 * @return maxInhabitants maximale Einwohner des Wohnhauses
	 */
	public int getMaxInhabitants() {
		return maxInhabitants;
	}

	/**
	 * liefert den Wohlstnd des Wohnhauses zur�ck
	 * @return wealth Wohlstand des Wohnhauses
	 */
	public int getWealth() {
		return wealth;
	}

	/**
	 * liefert die Bed�rfnisse des Wohnhauses zur�ck
	 * @return needs Bed�rfnisse des Wohnhauses
	 */
	public ArrayList<String> getNeeds() {
		return needs;
	}
}
