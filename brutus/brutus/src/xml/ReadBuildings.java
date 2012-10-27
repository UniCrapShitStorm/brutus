package xml;

import java.util.*;
import org.jdom2.*;
import org.jdom2.input.*;

import buildings.BuildingsRaw;
//import org.jdom2.output.*;
import java.io.*;

public class ReadBuildings {
	public static ArrayList<BuildingsRaw> buildings = new ArrayList<BuildingsRaw>();

	/**
	 * Liest alle Nutzgebaeude aus einer XML-Datei und speichert sie in einer ArrayList<Buildings>
	 * @return alle Nutzgebaeude in einer ArrayList
	 */
	public static ArrayList<BuildingsRaw> getBuildingsFromXml() {

		SAXBuilder builder = new SAXBuilder();
//		XMLOutputter out = new XMLOutputter();

		Document doc = null;
		try {
			doc = builder.build( "res/xml/buildings.xml" );
// 			out.output(doc, System.out);
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}

		List<Element> buildingslist = (List<Element>) doc.getRootElement().getChildren();

		for (int i = 0; i < buildingslist.size(); i++) {
			Element building = (Element) buildingslist.get(i);

			String name = building.getChildText("name");
			int sizeX = Integer.parseInt(building.getChildText("sizeX"));
			int sizeY = Integer.parseInt(building.getChildText("sizeY"));
			boolean needsStreet = Boolean.parseBoolean(building.getChildText("needsStreet"));
			int initAttr = Integer.parseInt(building.getChildText("initAttr"));
			int plusAttr = Integer.parseInt(building.getChildText("plusAttr"));
			int stepAttr = Integer.parseInt(building.getChildText("stepAttr"));
			int maxAttrRegion = Integer.parseInt(building.getChildText("maxAttrRegion"));
			int maxWorkers = Integer.parseInt(building.getChildText("maxWorkers"));
			int costs = Integer.parseInt(building.getChildText("costs"));

			BuildingsRaw buildingsWithValues = new BuildingsRaw(name, sizeX, sizeY, needsStreet, initAttr, plusAttr, stepAttr, maxAttrRegion, maxWorkers, costs);
			buildings.add(buildingsWithValues);
		}

//		System.out.print("Name\tGroesse\tStrasse?\tAttr.init\tAttr.plus\tAttr.schritt\tmax.Attr.Bereich\tmax.Arbeiter\tKosten\n");
//		for (Buildings b : buildings) {
//			System.out.print(b.getName() + "\t" + b.getSizeX() + "x" + b.getSizeY() + "\t" + b.needsStreet() + "\t" + b.getInitAttr() + "\t" + b.getPlusAttr() + "\t" + b.getStepAttr() + "\t" + b.getMaxAttrRegion() + "\t" + b.getMaxWorkers() + "\t" + b.getCosts() + "\n");
//		}
		
		return buildings;
	}
}
