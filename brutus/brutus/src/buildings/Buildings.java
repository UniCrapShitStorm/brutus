package buildings;

import ground.Field;

public class Buildings extends BuildingsRaw {
	private Field place;
	private int attraction;
	
	public Buildings(BuildingsRaw b, Field place, int attraction) {
		super(b.getName(), b.getSizeX(), b.getSizeY(), b.needsStreet(), b.getInitAttr(), b.getPlusAttr(), b.getStepAttr(), b.getMaxAttrRegion(), b.getMaxWorkers(), b.getCosts());
		this.place = place;
		this.attraction = attraction;
	}
}
