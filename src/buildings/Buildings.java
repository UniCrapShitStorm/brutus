package buildings;
import ground.Field;

public abstract class Buildings {
	private final String name;
	private final int sizeX;
	private final int sizeY;
	private Field place;
	
	Buildings(String name, int sizeX, int sizeY) {
		this.name = name;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	/**
	 * liefert den Namen des Geb�udes zur�ck
	 * @return Name des Geb�udes
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * liefert die X-Gr��e des Geb�udes zur�ck
	 * @return X-Gr��e des Geb�udes
	 */
	public int getSizeX() {
		return sizeX;
	}
	
	/**
	 * liefert die Y-Gr��e des Geb�udes zur�ck
	 * @return Y-Gr��e des Geb�udes
	 */
	public int getSizeY() {
		return sizeY;
	}
	
	/**
	 * liefert das Feld / den Platz, auf dem es steht zur�ck
	 * @return Feld des Gebaudes
	 */
	public Field getPlace() {
		return place;
	}
}
