package mapedit;
import game.Game;
import ground.Desert;
import ground.Field;
import ground.Grass;
import ground.Stones;
import ground.Water;
import ground.Wheat;
import gui.FieldPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import build.Path;
/**
 * 
 * @author Torben
 * @deprecatd
 *
 */

public class GUIMapEdit {

	JFrame frmain;
	JPanel pmain;
	JButton btnew,btsave,btload;
	FieldPanel [][] inmap;
	int xLength=0,yLength=0;
	public GUIMapEdit(){
		
		
	}
	
	private JFrame getFrmain() {
		if(frmain==null)
		{
			frmain = new JFrame();
			frmain.setContentPane(getPmain());
			frmain.setBounds(200, 200, 600, 600);
			frmain.setVisible(true);
			frmain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		return frmain;
	}
	private JPanel getPmain() {
		if(pmain==null)
		{
			pmain = new JPanel(null);
			pmain.add(getBtnew());
			pmain.add(getBtsave());
			pmain.add(getBtload());
		}
		return pmain;
	}
	private JButton getBtnew() {
		if(btnew==null)
		{
			btnew=new JButton();
			btnew.setText("Neu");
			btnew.setBounds(5, 5, 100, 20);
			btnew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String input=JOptionPane.showInputDialog(getFrmain(), "Geben Sie die gewuenschte Kartengroesse ein:\nFormatbeispiel: 15x20");
					if(input!=null&&input.length()>2)
					try{
						int xLengthN = Integer.parseInt(input.substring(0,input.indexOf("x"))),
						yLengthN = Integer.parseInt(input.substring(input.indexOf("x")+1));
						
						for (int i = 0; i < xLength; i++)
							for (int j = 0; j < yLength; j++)
								getPmain().remove(inmap[i][j]);
						
						inmap =  new FieldPanel[xLength=xLengthN][yLength=yLengthN];
						
						for (int i = 0; i < xLength; i++)
							for (int j = 0; j < yLength; j++){
								inmap[i][j] = new FieldPanel(5+(i*42), 30+(j*42), 40, 40);
								getPmain().add(inmap[i][j]);
							}
						getFrmain().validate();
						getFrmain().repaint();
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		return btnew;
	}
	private JButton getBtsave() {
		if(btsave==null)
		{
			btsave=new JButton();
			btsave.setText("Speichern");
			btsave.setBounds(105, 5, 100, 20);
			btsave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(xLength>0&&yLength>0)
					{
						Field [][] outmap = new Field[xLength][yLength];
						
						for (int i = 0; i < xLength; i++)
							for (int j = 0; j < yLength; j++)
								outmap[i][j]=inmap[i][j].createSelectedField(i, j);
						for (int i = 0; i < xLength; i++)
							for (int j = 0; j < yLength; j++){
								Path p = (Path) outmap[i][j].getBuilding();
								if(p!=null)
									p.link(outmap);
							}
						JFileChooser fout = new JFileChooser();
						fout.showSaveDialog(getFrmain());
						File f = fout.getSelectedFile();
						if(!f.exists())
							try {
								f.createNewFile();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								System.err.println(e.getMessage());
							}
						if(f.isFile()&&f.getName().endsWith(".map"))
							Game.writeMap(outmap, f.getAbsolutePath());
					}
				}
			});
		}
		return btsave;
	}
	private JButton getBtload(){
		if(btload==null)
		{
			btload = new JButton("�ffnen");
			btload.setBounds(205, 5, 100, 20);
			btload.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JFileChooser fin = new JFileChooser();
					fin.showOpenDialog(getFrmain());
					File f = fin.getSelectedFile();
					if(f.exists()&&f.isFile()&&f.getName().endsWith(".map"))
					{
						Field [][] map = Game.loadMap(f.getAbsolutePath());
						for (int i = 0; i < xLength; i++)
							for (int j = 0; j < yLength; j++)
								getPmain().remove(inmap[i][j]);
						xLength = map.length;
						yLength = map[0].length;
						inmap = new FieldPanel[xLength][yLength];
						for (int i = 0; i < xLength; i++)
							for (int j = 0; j < yLength; j++){
								int selectedSurface=0;
								if(map[i][j] instanceof Grass)
									selectedSurface=0;
								else if(map[i][j] instanceof Water)
									selectedSurface=1;
								else if(map[i][j] instanceof Wheat)
									selectedSurface=2;
								else if(map[i][j] instanceof Stones)
									selectedSurface=3;
								else if(map[i][j] instanceof Desert)
									selectedSurface=4;
								inmap[i][j] = new FieldPanel(5+(i*42), 30+(j*42), 40, 40, selectedSurface, map[i][j].getBuilding() instanceof Path);
								getPmain().add(inmap[i][j]);
							}
						getFrmain().validate();
						getFrmain().repaint();
					}
				}
			});
		}
		return btload;
	}

	public static void main(String[] args) {
		new GUIMapEdit().getFrmain();

	}

}
