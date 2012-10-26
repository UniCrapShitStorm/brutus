package buildings;

import game.God;
import ground.Field;

public class Homes extends HomesRaw {	
	private Field place;
	private int inhabitants;
	private boolean burning;
	
	/**
	 * Konstruktor zur Instanzierung eines Wohngebaudes
	 * @param h Wohngebaude-Rohling, der hier weiter spezifiziert wird
	 * @param place Platz, an dem das Gebaude steht
	 * @param inhabitants aktuelle Einwohnerzahl
	 */
	Homes(HomesRaw h, Field place, int inhabitants) {
		super(h.getName(), h.getSizeX(), h.getSizeY(), h.getId(), h.getMaxInhabitants(), h.getWealth(), h.getNeeds());

		this.place = place;
		this.inhabitants = inhabitants;
		this.burning = false;
	}
	
	/**
	 * liefert den Platz, auf dem das Wohnhaus steht, zurueck
	 * @return Platz, an dem das Wohnhaus steht
	 */
	public Field getField() {
		return place;
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