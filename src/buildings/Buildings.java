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
	 * liefert den Namen des Gebäudes zurück
	 * @return Name des Gebäudes
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * liefert die X-Größe des Gebäudes zurück
	 * @return X-Größe des Gebäudes
	 */
	public int getSizeX() {
		return sizeX;
	}
	
	/**
	 * liefert die Y-Größe des Gebäudes zurück
	 * @return Y-Größe des Gebäudes
	 */
	public int getSizeY() {
		return sizeY;
	}
	
	/**
	 * liefert das Feld / den Platz, auf dem es steht zurück
	 * @return Feld des Gebaudes
	 */
	public Field getPlace() {
		return place;
	}
}
