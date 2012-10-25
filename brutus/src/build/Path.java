package build;

import ground.Field;

public abstract class Path extends Building {

	private Path northLink,southLink,westLink,eastLink;
	
	public Path(Field place) {
		super(place);
	}
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int getXSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int getYSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public boolean isBurning() {
		// TODO Auto-generated method stub
		return false;
	}

	
	private Path getNorthLink() {
		return northLink;
	}


	private void setNorthLink(Path northLink) {
		this.northLink = northLink;
	}


	private Path getSouthLink() {
		return southLink;
	}


	private void setSouthLink(Path southLink) {
		this.southLink = southLink;
	}


	private Path getWestLink() {
		return westLink;
	}


	private void setWestLink(Path westLink) {
		this.westLink = westLink;
	}


	private Path getEastLink() {
		return eastLink;
	}


	private void setEastLink(Path eastLink) {
		this.eastLink = eastLink;
	}


	public void setBurning(boolean b) {
		// TODO Auto-generated method stub

	}


	public void link(Field[][] map) {
		Building b;
		if(place.getXPos()>0)
		{
			b=map[place.getXPos()-1][place.getYPos()].getBuilding();
			if(b instanceof Path)
				northLink = (Path) b;
		}
		if(place.getYPos()>0)
		{
			b=map[place.getXPos()][place.getYPos()-1].getBuilding();
			if(b instanceof Path)
				westLink = (Path) b;
		}
		if(place.getXPos()<map.length-1)
		{
			b=map[place.getXPos()+1][place.getYPos()].getBuilding();
			if(b instanceof Path)
				southLink = (Path) b;
		}
		if(place.getYPos()<map[0].length-1)
		{
			b=map[place.getXPos()][place.getYPos()+1].getBuilding();
			if(b instanceof Path)
				eastLink = (Path) b;
		}
	}

}
