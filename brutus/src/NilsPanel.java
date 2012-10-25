import ground.Field;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

import javax.swing.JPanel;

import nilsgl.NGLManager;
import nilsgl.NGLQuad;


public class NilsPanel extends JPanel
{
	private Field [][] map;
	static public NGLManager ngl;
	
	
	public void paint(Graphics g)
	{
		super.paint(g);
	}
	
	public NilsPanel(Field [][] map)
	{
		NGLManager manager = new NGLManager(this);
		this.map = map;
		manager.map = map;
		ngl = manager;
	}
}
