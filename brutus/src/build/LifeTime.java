package build;

public interface LifeTime {

	/**
	 * @return Gibt die verbleibende Lebensdauer zurueck, -1 bedeutet: Gebaeude ohne Verschleiss
	 */
	abstract public int getLifeTimeLeft();
	abstract public void resetLifeTime();
	/**
	 * Verringert die verbleibende Lebensdauer um 1 und prueft auf ihre Erschoepfung
	 * @return true, wenn die verbleibende Lebensdauer == 0 ist
	 */
	abstract public boolean decLifeTime();
}
