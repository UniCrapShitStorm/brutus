package xml;

import java.util.*;

import org.jdom2.*;
import org.jdom2.input.*;

import buildings.Homes;
//import org.jdom2.output.*;

import java.io.*;

public class ReadHomes {
	public ArrayList<Homes> homes = new ArrayList<Homes>();
	
	/**
	 * wird eine Instanz der Klasse ReadHomes erstellt, wird automatisch im Konstruktor die entsprechende XML-Datei eingelesen
	 */
	ReadHomes() {
		homes = getHomesFromXml();
	}
	
	/**
	 * Liest alle Wohnhaeuser aus einer XML-Datei und speichert sie in einer ArrayList<Homes>
	 * @return alle Wohnhaeuser in einer ArrayList
	 */
	public ArrayList<Homes> getHomesFromXml() {

		SAXBuilder builder = new SAXBuilder();
//		XMLOutputter out = new XMLOutputter();
		

		Document doc = null;
		try {
			doc = builder.build( "res/xml/homes.xml" );
//			out.output(doc, System.out);
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
	
		List<Element> homeslist = (List<Element>) doc.getRootElement().getChildren();
		
		for (int i = 0; i < homeslist.size(); i++) {
			Element home = (Element) homeslist.get(i);
			
			int id = Integer.parseInt(home.getChildText("id"));
			String name = home.getChildText("name");
			int sizeX = Integer.parseInt(home.getChildText("sizeX"));
			int sizeY = Integer.parseInt(home.getChildText("sizeY"));
			int maxInhabitants = Integer.parseInt(home.getChildText("maxInhabitants"));
			int wealth = Integer.parseInt(home.getChildText("wealth"));
			ArrayList<String> needs = new ArrayList<String>();
			
			Element needsroot = home.getChild("needs");
			if (needsroot != null)
			{
				List<Element> needslist = (List<Element>) needsroot.getChildren();
				if (needslist.size() > 0) {
					for (int j = 0; j < needslist.size(); j++) {
						Element need = (Element) needslist.get(j);
						String needString = need.getText();
						needs.add(needString);
					}
				}
			}

			Homes homeWithValues = new Homes(name, sizeX, sizeY, id, maxInhabitants, wealth, needs, 0);
			homes.add(homeWithValues);
		}
		
//		System.out.print("ID\tName\t\t\tGroesse\tmax.Einwohner\tWohlstand\tBeduerfnisse\n");
//		for (Homes h : homes) {
//			System.out.print(h.getId() + "\t" + h.getName() + "\t\t" + h.getSizeX() + "x" + h.getSizeY() + "\t" + h.getMaxInhabitants() + "\t" + h.getWealth() + "\t" + h.getNeeds().toString() + "\n");
//		}
		
		return homes;
	}
	
	/**
	 * liefert die Wohnhauser als ArrayList<Homes> zurueck
	 * @return ArrayList der Wohnhauser
	 */
	public ArrayList<Homes> getHomeList() {
		return homes;
	}
}