package buildings;
import ground.Field;

public abstract class Building {
	private final String name;
	private final int sizeX;
	private final int sizeY;
	
	Building(String name, int sizeX, int sizeY) {
		this.name = name;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	/**
	 * liefert den Namen des Geb�udes zur�ck
	 * @return name Name des Geb�udes
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * liefert die X-Gr��e des Geb�udes zur�ck
	 * @return sizeX X-Gr��e des Geb�udes
	 */
	public int getSizeX() {
		return sizeX;
	}
	
	/**
	 * liefert die Y-Gr��e des Geb�udes zur�ck
	 * @return sizeY Y-Gr��e des Geb�udes
	 */
	public int getSizeY() {
		return sizeY;
	}
}
