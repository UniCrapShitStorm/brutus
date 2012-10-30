package xml;

import java.util.*;

import org.jdom2.*;
import org.jdom2.input.*;
import buildings.OtherBuildings;
//import org.jdom2.output.*;
import java.io.*;

public class ReadBuildings {
	public ArrayList<OtherBuildings> buildings = new ArrayList<OtherBuildings>();

	/**
	 * wird eine Instanz der Klasse ReadBuildings erstellt, wird automatisch im Konstruktor die entsprechende XML-Datei eingelesen
	 */
	ReadBuildings() {
		buildings = getBuildingsFromXml();
	}
	
	/**
	 * Liest alle Nutzgebaeude aus einer XML-Datei und speichert sie in einer ArrayList<OtherBuildings>
	 * @return alle Nutzgebaeude in einer ArrayList
	 */
	public ArrayList<OtherBuildings> getBuildingsFromXml() {

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

			OtherBuildings buildingsWithValues = new OtherBuildings(name, sizeX, sizeY, needsStreet, initAttr, plusAttr, stepAttr, maxAttrRegion, 0, maxWorkers, costs);
			buildings.add(buildingsWithValues);
		}

//		System.out.print("Name\tGroesse\tStrasse?\tAttr.init\tAttr.plus\tAttr.schritt\tmax.Attr.Bereich\tmax.Arbeiter\tKosten\n");
//		for (Buildings b : buildings) {
//			System.out.print(b.getName() + "\t" + b.getSizeX() + "x" + b.getSizeY() + "\t" + b.needsStreet() + "\t" + b.getInitAttr() + "\t" + b.getPlusAttr() + "\t" + b.getStepAttr() + "\t" + b.getMaxAttrRegion() + "\t" + b.getMaxWorkers() + "\t" + b.getCosts() + "\n");
//		}
		
		return buildings;
	}
	
	/**
	 * liefert die anderen Gebaude als ArrayList<OtherBuildings> zurueck
	 * @return ArrayList der anderen Gebaude
	 */
	public ArrayList<OtherBuildings> getBuildingsList() {
		return buildings;
	}
}
