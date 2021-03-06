package gui;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import ground.*;
import javax.swing.JPanel;
/**
 * Diese Klasse dient zur Darstellung der mini-map in Hauptgui undevtl editor...
 * @author Tobias
 *
 */

public class MiniMap extends JPanel {

	private Field [][] map;
	/*public static void main(String[] args) {
		JFrame f=new JFrame();
		Field [][] k=new Field [4][3];
		k[0][0]=new Desert(0, 0);
		k[0][1]=new Grass(0, 1);
		k[0][2]=new Iron(0, 2);
		k[1][0]=new Marble(1, 0);
		k[1][1]=new Stones(1, 1);
		k[1][2]=new Water(1, 2);
		k[2][0]=new Wheat(2, 0);
		k[2][1]=new Desert(2, 1);
		k[2][2]=null;
		k[3][0]=null;
		k[3][1]=null;
		k[3][2]=null;
		k[2][1].setBuilding(new Track(k[2][1]));
		MiniMap m = new MiniMap(k);
		f.setContentPane(m);
		f.setSize(200,200);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}*/
	public MiniMap(Field [][] map){
		this.map=map;
		
	}
	public MiniMap(Field [][] map,int size){
		this.map=map;
		super.setSize(size, size);
	}
	public void paint(Graphics g){
		super.paint(g);
		int screen=getWidth(),xMap = map.length,yMap= map[0].length,offset,xWhite,yWhite;
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
		for(int x=0;x<map.length;x++)
			for(int y=0;y<map[0].length;y++)
			{
				if(map[x][y]==null)
					g.setColor(Color.BLACK);
				else if(map[x][y] instanceof Desert)
					g.setColor(new Color(200,100,0));
				else if(map[x][y] instanceof Grass)
					g.setColor(new Color(0,150,0));
				else if(map[x][y] instanceof Iron)
					g.setColor(new Color(120,200,255));
				else if(map[x][y] instanceof Marble)
					g.setColor(new Color(255,200,200));
				else if(map[x][y] instanceof Stones)
					g.setColor(new Color(50,50,50));
				else if(map[x][y] instanceof Water)
					g.setColor(new Color(20,20,255));
				else if(map[x][y] instanceof Wheat)
					g.setColor(new Color(255,255,128));
				g.fillRect(xWhite+x*offset, yWhite+y*offset, offset, offset);
				g.setColor(new Color(180, 180, 180));
				if(map[x][y]!=null&&map[x][y].isBuildingExisting())
					g.fillRect(xWhite+x*offset+offset/10, yWhite+y*offset+offset/10, offset-offset/5, offset-offset/5);
				g.setColor(Color.BLACK);
				g.drawRect(1, 1, screen-2, screen-2);
			}
	}
	public void setSize(Dimension d){
		super.setSize(d.width, d.width);
	}
	public void setSize(int width, int heigth){
		super.setSize(width, width);
	}
	public void setBounds(Rectangle r){
		super.setBounds(r.x, r.y, r.width, r.width);
	}
	public void setBounds(int a, int b, int width, int heigth){
		super.setBounds(a, b, width, width);
	}
	
	public void setMap(Field[][] map){
		this.map=map;
	}
}
