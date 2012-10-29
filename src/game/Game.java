package game;
import ground.Field;
import gui.SwingGui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;




public class Game{

	private Field [][]karte;
	
	public Game(){
		
		
	}
	
	/**
	 * Lies eine Karte aus einer Datei.
	 * Verändert Dateien nicht.
	 * @param filename Der dateiname der zu lesenden Karte
	 * @return die Karte, so wie sie in die Datei geschrieben wurde
	 */
	public static Field[][]loadMap(String filename){
		Field[][] map=null;
		try {
			FileInputStream in = new FileInputStream(filename);
		      ObjectInputStream o = new ObjectInputStream(in);
		      
		      int xLength = (Integer) o.readObject(),yLength= (Integer) o.readObject();
		      
		      map = new Field[xLength][yLength];
		      
		      for(int i=0;i<xLength;i++)
	        	  for(int j=0;j<yLength;j++)
	        		  map[i][j] = (Field) o.readObject();
		      o.close();
		      in.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return map;
	}
	/**
	 * Schreibt eine Karte aus dem RAM in eine Datei...+
	 * ACHTUNG: Überschreibt ohne zu Fragen!!!
	 * @param map Die Karte
	 * @param filename ihr dateiname
	 */
	public static void writeMap(Field [][]map,String filename){
		FileOutputStream out=null;
		ObjectOutputStream o=null;
		try{
			out = new FileOutputStream( filename );
	        o = new ObjectOutputStream( out );
	        int xLength,yLength;
	          o.writeObject  (xLength=map.length);
	          o.writeObject  (yLength=map[0].length);
	          for(int i=0;i<xLength;i++)
	        	  for(int j=0;j<yLength;j++)
	        		  o.writeObject(map[i][j]);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		finally{
			try{
				o.close();
				out.close();
			}
		     catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getMessage());
				}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingGui g = new SwingGui();
		g.createAndShowGUI();
	}


}
