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
	 * liefert den Namen des Gebäudes zurück
	 * @return name Name des Gebäudes
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * liefert die X-Größe des Gebäudes zurück
	 * @return sizeX X-Größe des Gebäudes
	 */
	public int getSizeX() {
		return sizeX;
	}
	
	/**
	 * liefert die Y-Größe des Gebäudes zurück
	 * @return sizeY Y-Größe des Gebäudes
	 */
	public int getSizeY() {
		return sizeY;
	}
}
