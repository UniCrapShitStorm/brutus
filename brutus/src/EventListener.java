import ground.Field;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import java.awt.*;


import org.omg.CORBA.SystemException;

public class EventListener implements ActionListener {
	Field [][] field;
	PlayingField playField;
	SwingGui g = new SwingGui();

	
//	Main main = new Main();

	public void actionPerformed(ActionEvent event){
		
		Object src = event.getSource();
		
		if (src == g.Obstfarmbutton){
		System.out.println("Obstfarm");
		//SmallTent t = new SmallTent(null, 0);				//macht so irgendwie noch relativ wenig...
		g.fieldChange("obstfarm");
		g.baumode=true;
		g.playField.requestFocus(true);
//		Farm.build(Main.buildings, Main.stats, 'o');
		}
		if (src == g.Getreidefarmbutton){
			System.out.println("Getreidefarm");				//soll bald eine Getreidefarm bauen
			g.playField.requestFocus(true);
//			Farm.build(Main.buildings, Main.stats, 'g');
		}
		if (src == g.Weinbergbutton){
			System.out.println("Weinberg");	
//			Farm.build(Main.buildings, Main.stats, 'w');
			g.playField.requestFocus(true);
		}
		if (src == g.Olivenfarmbutton){
			System.out.println("Olivenfarm");
//			Farm.build(Main.buildings, Main.stats, 'l');
			g.playField.requestFocus(true);
		}
		if (src == g.Ziehbrunnenbutton){
			System.out.println("Ziehbrunnen");	
//			Well.build(Main.buildings, Main.stats, Main.resources);
			g.playField.requestFocus(true);
		}	
		if (src == g.Zeltbutton){
			System.out.println("Zelt");	
//			Tent.build(Main.buildings, Main.stats);
			g.playField.requestFocus(true);
		}		
		if (src == g.Beraterbutton){
//			BeraterFenster.oeffneBerater();
			
		}
		if (src == g.exit){
			System.exit(0);
		}
		if (src == g.open){
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

				field = Game.loadMap(load.getSelectedFile().getAbsolutePath());
				playField.setMap(field);
				//SwingGui.playField.revalidate();
				SwingGui.playField.repaint();
			}
		}
	}
}
