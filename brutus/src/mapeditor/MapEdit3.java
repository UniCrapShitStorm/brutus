package mapeditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

import game.MiniMap;
import ground.Desert;
import ground.Field;
import ground.Grass;
import ground.Iron;
import ground.Marble;
import ground.Stones;
import ground.Water;
import ground.Wheat;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.filechooser.FileFilter;

import build.Path;
import build.Track;

/**
 * Version 3 des Mapeditors,
 * Funktion wie vorher(bis auf Bugfixes), aber in stabilerer und aufgeraeumter Art und Weise
 * @version 3.0
 * @author tobias
 *	TODO Speichern/Laden wieder einbinen (Liefert Fehler, da Game nicht in einem Package liegt). done...
 */
public class MapEdit3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private final MapEdit3 me;
	private Field [][] map;
	private MiniMap minimap;
	private JPanel eastPanel;
	private JLabel coordinatesLabel;
	private JCheckBox deleteCheck;
	private JComboBox<String> gebaeudeCombo;
	public JComboBox<String> untergrundCombo;
	private JRadioButton gebaeudeRadio;
	private JRadioButton untergrundRadio;
	private JMenuBar menuBar;
	private JMenu dateiMenu;
	private JMenuItem newMItem;
	private JMenuItem openMItem;
	private JMenuItem saveAsMItem;
	private JMenuItem exitMItem;
	
	/**
	 * Methode zum Starten des MapEditors
	 * @param args wird nicht verwendet
	 */
	public static void main(String[] args) {
		new MapEdit3().setVisible(true);

	}
	
	public MapEdit3(){
		super("MapEdit v3");
		me = this;
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		map = new Field[][] {{new Grass(0, 0)}};
		super.setSize(550, 450);
		
		super.setJMenuBar(getJMenuBar());
		super.getContentPane().add(getMinimap(),BorderLayout.CENTER);
		super.getContentPane().add(getEastPanel(), BorderLayout.EAST);
		
	}
	
	private MiniMap getMinimap(){
		if(minimap==null)
		{
			minimap = new MiniMap(map);
			minimap.addMouseMotionListener(new MouseMotionListener() {
				public void mouseMoved(MouseEvent e) {
					int screen = getMinimap().getWidth(), xMap = map.length,yMap = map[0].length, offset, xWhite, yWhite,xOnMap=e.getX(),yOnMap=e.getY(); 
					if(xMap>yMap)
					{
						offset=screen/xMap;
						yWhite=(screen-(offset*yMap))/2;
						xWhite=0;
					}
					else if(yMap>xMap)
					{
						offset=screen/yMap;
						xWhite=(screen-(offset*xMap))/2;
						yWhite=0;
					}
					else
					{
						offset=screen/xMap;
						xWhite=0;
						yWhite=0;
					}
					if(xOnMap<xWhite||yOnMap<yWhite||xOnMap>screen-xWhite-1||yOnMap>screen-yWhite-1)
						return;
					else
					{
						xOnMap -= xWhite;
						yOnMap-= yWhite;
						int xPos = xOnMap/offset, yPos = yOnMap/offset;
						if(xPos>=map.length||yPos>=map[0].length)
							;
						else
							getCoordinatesLabel().setText((xPos+1)+", "+(yPos+1)+" ("+map.length+", "+map[0].length+")");
					}
				}
				public void mouseDragged(MouseEvent e) {
					if(e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK)
						updateMap(e.getX(),e.getY());
				}
			});
			minimap.addMouseListener(new MouseListener() {
				
				
				public void mouseReleased(MouseEvent arg0) {}
				public void mouseClicked(MouseEvent arg0) {}
				public void mouseExited(MouseEvent arg0) {}
				public void mouseEntered(MouseEvent arg0) {}
				public void mousePressed(MouseEvent e) {
					if(e.getButton()==MouseEvent.BUTTON1)
						updateMap(e.getX(), e.getY());
					}
			});
			
		}
		return minimap;
	}
	
	private JPanel getEastPanel(){
		if(eastPanel==null)
		{
			eastPanel = new JPanel(null);
			eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
			eastPanel.add(Box.createVerticalStrut(10));
			eastPanel.add(getUntergrundRadio());
			eastPanel.add(getGebaeudeRadio());
			eastPanel.add(Box.createVerticalStrut(10));
			eastPanel.add(getUntergrundCombo());
			eastPanel.add(Box.createVerticalStrut(10));
			eastPanel.add(getGebaeudeCombo());
			eastPanel.add(Box.createVerticalStrut(10));
			eastPanel.add(getDeleteCheck());
			eastPanel.add(Box.createGlue());
			eastPanel.add(getCoordinatesLabel());
		}
		return eastPanel;
	}

	private JLabel getCoordinatesLabel() {
		if(coordinatesLabel==null)
		{
			coordinatesLabel = new JLabel("0, 0");
		}
		return coordinatesLabel;
	}

	private JCheckBox getDeleteCheck() {
		if(deleteCheck==null)
		{
			deleteCheck = new JCheckBox("Löschen");
			deleteCheck.setEnabled(false);
		}
		return deleteCheck;
	}

	private JComboBox<String> getGebaeudeCombo() {
		if(gebaeudeCombo==null)
		{
			gebaeudeCombo = new JComboBox<String>(new String []{"Feldweg"});
			gebaeudeCombo.setEnabled(false);
			gebaeudeCombo.setMaximumSize(new Dimension(Integer.MAX_VALUE,25));
		}
		return gebaeudeCombo;
	}

	private JComboBox<String> getUntergrundCombo() {
		if(untergrundCombo==null)
		{
			untergrundCombo = new JComboBox<String>(new String []{"Wüste","Gras","Eisenerz","Marmor","Felsen","Wasser","Weizen"});
			untergrundCombo.setMaximumSize(new Dimension(Integer.MAX_VALUE,25));
		}
		return untergrundCombo;
	}

	private JRadioButton getGebaeudeRadio() {
		if(gebaeudeRadio==null)
		{
			gebaeudeRadio = new JRadioButton("Gebäude");
			gebaeudeRadio.setSelected(false);
			gebaeudeRadio.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
						getUntergrundCombo().setEnabled(false);
						getGebaeudeCombo().setEnabled(true);
						getDeleteCheck().setEnabled(true);
						getGebaeudeRadio().setSelected(true);
						getUntergrundRadio().setSelected(false);
				}
			});
		}
		return gebaeudeRadio;
	}

	private JRadioButton getUntergrundRadio() {
		if(untergrundRadio==null)
		{
			untergrundRadio = new JRadioButton("Untergrund");
			untergrundRadio.setSelected(true);
			untergrundRadio.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					getUntergrundCombo().setEnabled(true);
					getGebaeudeCombo().setEnabled(false);
					getDeleteCheck().setEnabled(false);
					getDeleteCheck().setSelected(false);
					getUntergrundRadio().setSelected(true);
					getGebaeudeRadio().setSelected(false);
				}
			});
		}
		return untergrundRadio;
	}
	
	public JMenuBar getJMenuBar() {
		if(menuBar==null)
		{
			menuBar = new JMenuBar();
			menuBar.add(getDateiMenu());
		}
		return menuBar;
	}

	private JMenu getDateiMenu() {
		if(dateiMenu==null)
		{
			dateiMenu = new JMenu("Datei");
			dateiMenu.add(getNewMItem());
			dateiMenu.add(getOpenMItem());
			dateiMenu.add(getSaveAsMItem());
			dateiMenu.add(getExitMItem());
		}
		return dateiMenu;
	}

	private JMenuItem getNewMItem() {
		if(newMItem==null)
		{
			newMItem = new JMenuItem("Neu");
			newMItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String input=JOptionPane.showInputDialog( "Geben Sie die gewuenschte Kartengroesse ein:\nFormatbeispiel: 15x20","15x20");
					if(input!=null&&input.length()>2)
					try{
						int xLengthN = Integer.parseInt(input.substring(0,input.indexOf("x"))),
						yLengthN = Integer.parseInt(input.substring(input.indexOf("x")+1));
						
						map=new Field[xLengthN][yLengthN];
						for (int x = 0; x < map.length; x++) {
							for (int y = 0; y < map[0].length; y++) {
								map[x][y] = new Grass(x, y);
							}
						}
						minimap.setMap(map);
						revalidate();
						repaint();
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		return newMItem;
	}

	private JMenuItem getOpenMItem() {
		if(openMItem==null)
		{
			openMItem = new JMenuItem("Öffnen");
			openMItem.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					JFileChooser load = new JFileChooser(".");
					load.setFileFilter(new FileFilter() {
						public String getDescription() {
							return "CaesarNet Kartendateien";
						}
						public boolean accept(File f) {
							return f!=null&&(f.getName().endsWith(".map")||f.isDirectory());
						}
					});
					load.showOpenDialog(me);
					if(load.getSelectedFile()!=null&&load.getSelectedFile().getName().endsWith(".map")&&load.getSelectedFile().isFile())
					{
						map = game.Game.loadMap(load.getSelectedFile().getAbsolutePath());
						minimap.setMap(map);
						revalidate();
						repaint();
					}
				}
			});
		}
		return openMItem;
	}

	private JMenuItem getSaveAsMItem() {
		if(saveAsMItem==null)
		{
			saveAsMItem = new JMenuItem("Speichern unter");
			saveAsMItem.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
						JFileChooser save = new JFileChooser(".");
						save.setFileFilter(new FileFilter() {
							public String getDescription() {
								return "CaesarNet Kartendateien";
							}
							public boolean accept(File f) {
								return f!=null&&(f.getName().endsWith(".map")||f.isDirectory());
							}
						});
						save.showSaveDialog(me);
						if(save.getSelectedFile()!=null&&save.getSelectedFile().getName().endsWith(".map"))
						game.Game.writeMap(map, save.getSelectedFile().getAbsolutePath());
				}
			});
		}
		return saveAsMItem;
	}

	private JMenuItem getExitMItem() {
		if(exitMItem==null)
		{
			exitMItem = new JMenuItem("Ende");
			exitMItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int a=JOptionPane.showConfirmDialog(me, "Nicht gespeicherte Arbeit geht verloren", "Wirklich beenden?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(a==JOptionPane.YES_OPTION)
						System.exit(0);
				}
			});
		}
		return exitMItem;
	}
	
	private void updateMap(int xOnMap,int yOnMap){
		int screen = getMinimap().getWidth(), xMap = map.length,yMap = map[0].length, offset, xWhite, yWhite; 
		if(xMap>yMap)
		{
			offset=screen/xMap;
			yWhite=(screen-(offset*yMap))/2;
			xWhite=0;
		}
		else if(yMap>xMap)
		{
			offset=screen/yMap;
			xWhite=(screen-(offset*xMap))/2;
			yWhite=0;
		}
		else
		{
			offset=screen/xMap;
			xWhite=0;
			yWhite=0;
		}
		if(xOnMap<xWhite||yOnMap<yWhite||xOnMap>screen-xWhite-1||yOnMap>screen-yWhite-1)
			return;
		else
		{
			xOnMap -= xWhite;
			yOnMap-= yWhite;
			int xPos = xOnMap/offset, yPos = yOnMap/offset;
			if(xPos>=map.length||yPos>=map[0].length)
				return;
			
			if (getUntergrundRadio().isSelected()) {
				Field f = map[xPos][yPos];
				switch(getUntergrundCombo().getSelectedIndex()){
				case 0: if(!(f instanceof Desert)) f = new Desert(xPos, yPos); break;
				case 1: if(!(f instanceof Grass)) f = new Grass(xPos, yPos); break;
				case 2: if(!(f instanceof Iron)) f = new Iron(xPos, yPos); break;
				case 3: if(!(f instanceof Marble)) f = new Marble(xPos, yPos); break;
				case 4: if(!(f instanceof Stones)) f = new Stones(xPos, yPos); break;
				case 5: if(!(f instanceof Water)) f = new Water(xPos, yPos); break;
				case 6: if(!(f instanceof Wheat)) f = new Wheat(xPos, yPos); break;
				}
				map[xPos][yPos]=f;
			
			}else{
				if(map[xPos][yPos].istBebaubar())
				{
					if (getDeleteCheck().isSelected())
					{
						map[xPos][yPos].removeBuilding();
					}
					else if(!(map[xPos][yPos].getBuilding() instanceof Path))
					{
						map[xPos][yPos].setBuilding(new Track(map[xPos][yPos]));	
					}
				//TODO fertig machen (iwer) <- Was denn??? Tobias
				}
			}

		}
		repaint();
	
	}
}
