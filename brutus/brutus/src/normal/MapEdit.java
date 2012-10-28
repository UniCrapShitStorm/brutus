package normal;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import ground.*;
import build.*;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;

import torben3.EventListener;

public class MapEdit extends JFrame {

	JMenuBar menubar;
	JLabel vorschau = new JLabel();
	JLabel coordinates = new JLabel();
	JRadioButton selUntergrund = new JRadioButton("Untergrund");
	JRadioButton selGebäude = new JRadioButton("Gebäude");
	JComboBox<String> untergrund = new JComboBox<String>();
	JComboBox<String> gebaeude = new JComboBox<String>();
	JCheckBox delete = new JCheckBox();
	ImageIcon vorschaubild = new ImageIcon("testvorschau.jpg");
	Field [][] map;
	MiniMap minimap;
	
	public static void main(String[]args){
		MapEdit m = new MapEdit("Map Editor");
		m.createAndShowGUI();
	}

	public MapEdit(String title){
		super(title);
	}
	
	public void createAndShowGUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(500,500);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menu = new JMenu("Menü");
		JMenuItem neu = new JMenuItem ("New");

		neu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String input=JOptionPane.showInputDialog( "Geben Sie die gewuenschte Kartengroesse ein:\nFormatbeispiel: 15x20");
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
			}});
			
		JMenuItem open = new JMenuItem ("Open");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem exit = new JMenuItem("Exit");
		
		save.addActionListener(new ActionListener(){
		
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
				save.showSaveDialog(null);
				if(save.getSelectedFile()!=null&&save.getSelectedFile().getName().endsWith(".map"))
				Game.writeMap(map, save.getSelectedFile().getAbsolutePath());
		}
		});
		
		open.addActionListener(new ActionListener(){
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
				load.showOpenDialog(null);
				if(load.getSelectedFile()!=null&&load.getSelectedFile().getName().endsWith(".map")&&load.getSelectedFile().isFile())
				{
					map = Game.loadMap(load.getSelectedFile().getAbsolutePath());
					minimap.setMap(map);
					revalidate();
					repaint();
				}
			}
		});
		
		exit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
		});
		
		menuBar.add(menu);
		menu.add(neu);
		menu.add(open);
		menu.add(save);
		menu.add(exit);
		
		Container pane = getContentPane();
		
		pane.setLayout(new BorderLayout());
	
		JPanel eastPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		
		pane.add(eastPanel, BorderLayout.EAST);
		//pane.add(centerPanel, BorderLayout.CENTER);
		minimap = new MiniMap(new Field[10][10]);
		pane.add(minimap, BorderLayout.CENTER);
		eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
		
		
		vorschau = new JLabel(vorschaubild);		
		coordinates = new JLabel();
		
		selUntergrund.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				untergrund.setEnabled(true);
				gebaeude.setEnabled(false);
				delete.setEnabled(false);
				delete.setSelected(false);
				selUntergrund.setSelected(true);
				selGebäude.setSelected(false);
			}
		});
		selGebäude.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
					untergrund.setEnabled(false);
					gebaeude.setEnabled(true);
					delete.setEnabled(true);
					delete.setSelected(false);
					selGebäude.setSelected(true);
					selUntergrund.setSelected(false);
			}
		});
		
		untergrund.addItem("Wüste");
		untergrund.addItem("Gras");
		untergrund.addItem("Eisenerz");
		untergrund.addItem("Marmor");
		untergrund.addItem("Felsen");
		untergrund.addItem("Wasser");
		untergrund.addItem("Weizen");
		
		
		gebaeude.addItem("Feldweg");
//		gebaeude.addItem("Bauplatz");
//		gebaeude.addItem("kleines Zelt");
//		gebaeude.addItem("Ziehbrunnen");
//		gebaeude.addItem("Busch");
//		gebaeude.addItem("Baum");
		gebaeude.setEnabled(false);
		
		delete = new JCheckBox("Löschen");
		delete.setEnabled(false);
		
		eastPanel.add(Box.createVerticalStrut(10));
		eastPanel.add(vorschau);
		eastPanel.add(Box.createVerticalStrut(10));
		eastPanel.add(selUntergrund);
		eastPanel.add(selGebäude);
		selUntergrund.setSelected(true);
		eastPanel.add(Box.createVerticalStrut(10));
		eastPanel.add(untergrund);
		eastPanel.add(Box.createVerticalStrut(10));
		eastPanel.add(gebaeude);
		eastPanel.add(Box.createVerticalStrut(10));
		eastPanel.add(delete);
		eastPanel.add(Box.createVerticalStrut(10));
		eastPanel.add(coordinates);
		eastPanel.add(Box.createVerticalStrut(10));
		eastPanel.add(Box.createVerticalStrut(eastPanel.getHeight()-5));
		eastPanel.add(Box.createVerticalStrut(200));
		eastPanel.add(new JLabel());
		
		minimap.addMouseMotionListener(new MouseMotionListener() {
			public void mouseMoved(MouseEvent e) {
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
		
		setVisible(true);
	}
	private void updateMap(int xOnMap,int yOnMap){
		int screen = minimap.getWidth(), xMap = map.length,yMap = map[0].length, offset, xWhite, yWhite; 
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
//			System.out.println(yOnMap+" "+screen+" "+yWhite);
			xOnMap -= xWhite;
			yOnMap-= yWhite;
			int xPos = xOnMap/offset, yPos = yOnMap/offset;
			if(xPos>=map.length||yPos>=map[0].length)
				return;
			
			if (selUntergrund.isSelected()) {
				Field f = null;
				switch(untergrund.getSelectedIndex()){
				case 0: f = new Desert(xPos, yPos); break;
				case 1: f = new Grass(xPos, yPos); break;
				case 2: f = new Iron(xPos, yPos); break;
				case 3: f = new Marble(xPos, yPos); break;
				case 4: f = new Stones(xPos, yPos); break;
				case 5: f = new Water(xPos, yPos); break;
				case 6: f = new Wheat(xPos, yPos); break;
				}
				map[xPos][yPos]=f;
			
			}else{
				if(map[xPos][yPos].istBebaubar())
				{
					if (delete.isSelected()) {
						map[xPos][yPos].removeBuilding();
					}else{
						map[xPos][yPos].setBuilding(new Track(map[xPos][yPos]));	
					}
				//TODO fertig machen
				}
			}

		}
		repaint();
	
	}
}
