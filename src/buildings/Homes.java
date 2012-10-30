package buildings;

import game.God;
import ground.Field;
import java.util.ArrayList;

public class Homes extends Buildings {
	private int id;
	private int maxInhabitants;
	private int inhabitants;
	private boolean burning;
	private int wealth;
	private ArrayList<String> needs;
	
	public Homes(String name, int sizeX, int sizeY, int id, int maxInhabitants,
			int wealth, ArrayList<String> needs, int inhabitants) {
		super(name, sizeX, sizeY);

		this.id = id;
		this.maxInhabitants = maxInhabitants;
		this.wealth = wealth;
		this.needs = needs;
		this.inhabitants = inhabitants;
		this.burning = false;
	}


	/**
	 * liefert die ID des Wohnhauses zurück
	 * @return id ID des Wohnhauses
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * liefert die aktuelle Einwohnerzahl eines Wohnhauses zurueck
	 * @return aktuelle Einwohnerzahl
	 */
	public int getInhabitants() {
		return inhabitants;
	}

	/**
	 * liefert die maximalen Einwohner des Wohnhauses zurück
	 * @return maxInhabitants maximale Einwohner des Wohnhauses
	 */
	public int getMaxInhabitants() {
		return maxInhabitants;
	}


	/**
	 * liefert den Wohlstand des Wohnhauses zurück
	 * @return wealth Wohlstand des Wohnhauses
	 */
	public int getWealth() {
		return wealth;
	}

	/**
	 * liefert die Bedürfnisse des Wohnhauses zurück
	 * @return needs Bedürfnisse des Wohnhauses
	 */
	public ArrayList<String> getNeeds() {
		return needs;
	}
	
	/**
	 * Anzahl der Einwohner eines Wohnhauses setzen
	 * @param count Anzahl der Einwohner
	 * @return gibt an, ob das Setzen erfolgreich war (Anzahl < max. Anzahl Einwohner)
	 */
	public boolean setInhabitantsCount(int count) {
		if(count > this.getMaxInhabitants())
			return false;
		else
		inhabitants = count;
		return true;
	}
	
	/**
	 * prueft, ob das Wohnhaus brennt
	 * @return true, wenn Wohnhaus brennt
	 */
	public boolean isBurning() {
		return burning;
	}
	
	/**
	 * Brenn-Zustand setzen
	 * @param b Brenn-Zustand
	 */
	public void setBurning(boolean b) {
		this.burning = b;
	}

	/**
	 * Kriminalitaet aktualisieren
	 * @param map Karte
	 */
	public void updateCriminality(Field[][] map) {
		// TODO Auto-generated method stub
	}

	/**
	 * Gesundheit aktualisieren
	 * @param map Karte
	 */
	public void updateIllness(Field[][] map) {
		// TODO Auto-generated method stub
	}

	/**
	 * Geschirr aktualisieren
	 * @param d Anzahl an Geschirr
	 */
	public void updateDishes(int d) {
		// TODO Auto-generated method stub
	}

	/**
	 * Moebel aktualisieren
	 * @param f Anzahl an Moebel
	 */
	public void updateFurniture(int f) {
		// TODO Auto-generated method stub
	}

	/**
	 * Oel aktualisieren
	 * @param o Menge Oel
	 */
	public void updateOil(int o) {
		// TODO Auto-generated method stub
	}

	/**
	 * Wein aktualisieren
	 * @param v Menge Wein
	 */
	public void updateVine(int v) {
		// TODO Auto-generated method stub
	}

	/**
	 * Popularitaet aktualisieren
	 * @param map Karte
	 */
	public void updatePopularity(Field[][] map) {
		// TODO Auto-generated method stub
	}

	/**
	 * Unterhaltung aktualisieren
	 * @param map Karte
	 */
	public void updateEntertainment(Field[][] map) {
		// TODO Auto-generated method stub
	}

	/**
	 * Religion aktualisieren
	 * @param map Karte
	 * @param g Gott
	 */
	public void updateReligion(Field[][] map, God[] g) {
		// TODO Auto-generated method stub
	}

	/**
	 * prueft, ob das Wohnhaus eine Stufe aufsteigen kann
	 * @return true, wenn alle Aufstiegsbeduerfnisse erfuellt sind
	 */
	public boolean isReadyToRise() {
		// TODO Auto-generated method stub
		return false;
	}
}
