package ground;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import mobile.Mobile;

import buildings.Buildings;


/**
 * Die Klasse Field beschreibt ein zusammengehörendes Feld auf dem Spielfeld.
 * Das Feld kann von 1 x 1 bis m x n beliebiug gross sein.
 * Die Position ist die Ecke des Feldes mit dem kleinsten X und Y Wert..
 * 
 * @author tobias
 *
 */
public abstract class Field implements Serializable{
	/**
	 * ID für serializable
	 */
	private static final long serialVersionUID = -5833164914576806776L;
	private final int xPos,yPos;
	private int xSize=1,ySize=1;
	
	private Buildings hereStands=null;
		
	private List<Mobile> moveables=null;
	
	/**
	 * Konstruktor I
	 * Standardfeldgroesse: 1 x 1
	 * @param xPos Die absolute X Position auf dem Spielfeld
	 * @param yPos Die absolute Y Position auf dem Spielfeld
	 */
	public Field(int xPos,int yPos){
		moveables = new LinkedList<Mobile>();
		this.xPos=xPos;
		this.yPos=yPos;
	}
	/**
	 * Konstruktor II
	 * Eigene Feldgroesse
	 * @param xPos Die absolute X Position auf dem Spielfeld
	 * @param yPos Die absolute Y Position auf dem Spielfeld
	 * @param xSize klar, oder?
	 * @param ySize klar, oder?
	 */
	public Field(int xPos,int yPos,int xSize,int ySize){
		moveables = new LinkedList<Mobile>();
		this.xPos=xPos;
		this.yPos=yPos;
		this.xSize=xSize;
		this.ySize=ySize;
	}
	/**
	 * Konstruktor III
	 * Auf ein Gebaeude zugeschnittene Feldgroesse
	 * @param xPos Die absolute X Position auf dem Spielfeld
	 * @param yPos Die absolute Y Position auf dem Spielfeld
	 * @param b Das auf dem Feld zu bauende Gebaeude.
	 */
	public Field(int xPos,int yPos,Buildings b){
		moveables = new LinkedList<Mobile>();
		this.xPos=xPos;
		this.yPos=yPos;
		if(b!=null)
		{
			this.xSize=b.getSizeX();
			this.ySize=b.getSizeY();
			this.hereStands=b;
		}
		else
		{
			this.xSize=1;
			this.ySize=1;
		}
	}
	
	public int getXSize() {
		return xSize;
	}
	protected void setXSize(int xSize) {
		this.xSize = xSize;
	}
	public int getYSize() {
		return ySize;
	}
	protected void setYSize(int ySize) {
		this.ySize = ySize;
	}
	public int getXPos() {
		return xPos;
	}
	public int getYPos() {
		return yPos;
	}
	public Buildings getBuilding() {
		return hereStands;
	}
	/**
	 * Prueft, ob ein gebaeude auf das feld passt und baut es, wenn es passt
	 * @param b das zu bauende Gebaeude
	 * @return passt das Gebaeude?
	 */
	public boolean setBuilding(Buildings b){
		if(xSize!=b.getSizeX()||ySize!=b.getSizeY())
			return false;
		hereStands=b;
		return true;
	}
	/**
	 * Prueft, ob ein Gebaeude zu dem feld passt
	 * @param b das zu pruefende Gebaeude
	 * @return passt es?
	 */
	abstract public boolean isBuildingCompatible(Buildings b);
	
	/**
	 * @return Wurde das Gebaeude geloescht?
	 */
	public Buildings removeBuilding(){
		Buildings b = hereStands;
		hereStands=null;
		return b;
	}
	/**
	 * @return Steht hier schon ein Gebaeude?
	 */
	public boolean isBuildingExisting(){
		return hereStands!=null;
	}
	abstract public boolean istBebaubar();
	
	public List<Mobile> getMoveables() {
		return moveables;
	}
	/**
	 * Fuegt dem Feld ein bewegliches Objekt hinzu.
	 * @param m das neue bewegliche Objekt
	 */
	public void addMoveable(Mobile m){
		moveables.add(m);
	}
	/**
	 * TODO Testen ;-)
	 * Fuegt dem Feld eine Liste mit beweglichen Objekten hinzu.
	 * @param m die Liste mit den neuen beweglichen Objekten
	 * @return wurden sie hinzugefuegt?
	 */
	public void addMoveables(List <Mobile> list){
		moveables.addAll(list);
	}
	/**
	 * TODO Testen ;-)
	 * Entfernt ein bewegliches Objekt von diesem Feld
	 * @param m das zu loeschene Objekt
	 * @return war es in der Liste?
	 */
	public boolean removeMoveable(Mobile m){
		return moveables.remove(m);
	}
	/**
	 * Entfernt alle beweglichen Objekte von diesem Feld.
	 */
	public void removeAllMoveables(){
		moveables = new LinkedList<Mobile>();
	}
}
