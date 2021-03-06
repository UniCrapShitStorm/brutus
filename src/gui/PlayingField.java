package gui;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

import ground.Desert;
import ground.Field;
import ground.Grass;
import ground.Iron;
import ground.Marble;
import ground.Stones;
import ground.Water;
import ground.Wheat;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.*;

import java.awt.Toolkit;;

public class PlayingField extends JPanel {
	private Field [][] field;
	static int pixelsize = 100;
	static int xmapmove;
	static int ymapmove;
	public double xact;
	public double yact;
	private int imagesize =100;
	private Image gras = loadImage("/img/gras1_klein.jpg");
	private Image desert = loadImage("/img/wueste1.jpg");
	private Image soil = loadImage("/img/erde1_klein.jpg");
	private Image schild = loadImage("/img/schild3.png");
	

	
	  private Image loadImage(String name) {
		   System.out.println("test");
		   addKeyListener(new InputKeyEvents());
	         try {
	            return ImageIO.read(getClass().getResource(name));
	            
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	         return null;
	        
	   }
	  				
	public PlayingField(Field [][] field){
		this.field = field;
		
	}
	public PlayingField(Field [][] field,int size){
		this.field = field;
		super.setSize(size, size);
	}
	public void paint(Graphics g){
/*		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(Color.black);
		//g.drawImage(gras, 0, 0, 1000, 1000, null);
		g2.translate(xmapmove, ymapmove);
		g2.scale(1,0.5);		//3d Illusion
		g2.rotate(Math.PI*0.25);	//  f�r isoperspektive um 45 grad drehen
		g2.setColor(Color.BLACK);
		*/
		
		NilsPanel.ngl.camx = xmapmove;
		NilsPanel.ngl.camy = ymapmove;
				
		int screen=getWidth(),xMap = field.length,yMap= field[0].length,offset,xWhite,yWhite;
		for(int x = 0;x<field.length;x++)
			for(int y =0;y<field[0].length;y++)
			{
				if(field[x][y]==null){
					g.setColor(Color.BLACK);
					g.drawImage(gras, x*pixelsize, y*pixelsize, imagesize,imagesize, null);
				
				
				}
				else if(field[x][y] instanceof Desert){
					g.drawImage(desert, x*pixelsize, y*pixelsize, imagesize,imagesize, null);
					//g.setColor(new Color(200,100,0));
					//g.fillRect(x*pixelsize, y*pixelsize, pixelsize, pixelsize);
					//g.fillRect(pixelsize, pixelsize, pixelsize, pixelsize);
				}
								
				else if(field[x][y] instanceof Grass){
					g.setColor(new Color(0,150,0));
					g.fillRect(x*pixelsize, y*pixelsize, pixelsize, pixelsize);
					g.fillRect(pixelsize, pixelsize, pixelsize, pixelsize);
				}
				else if(field[x][y] instanceof Iron){
					g.setColor(new Color(120,200,255));
					g.fillRect(x*pixelsize, y*pixelsize, pixelsize, pixelsize);
					g.fillRect(pixelsize, pixelsize, pixelsize, pixelsize);
				}	
				else if(field[x][y] instanceof Marble){
					
					g.setColor(new Color(255,200,200));
					g.fillRect(x*pixelsize, y*pixelsize, pixelsize, pixelsize);
					g.fillRect(pixelsize, pixelsize, pixelsize, pixelsize);	
				}
				else if(field[x][y] instanceof Stones){
					
					g.setColor(new Color(50,50,50));
					g.fillRect(x*pixelsize, y*pixelsize, pixelsize, pixelsize);
					g.fillRect(pixelsize, pixelsize, pixelsize, pixelsize);
				}
				else if(field[x][y] instanceof Water){
					
					g.setColor(new Color(20,20,255));
					g.fillRect(x*pixelsize, y*pixelsize, pixelsize, pixelsize);
					g.fillRect(pixelsize, pixelsize, pixelsize, pixelsize);
				}
				else if(field[x][y] instanceof Wheat){
					
					g.setColor(new Color(255,255,128));
					g.fillRect(x*pixelsize, y*pixelsize, pixelsize, pixelsize);
					g.fillRect(pixelsize, pixelsize, pixelsize, pixelsize);
				}
				g.setColor(new Color(180, 180, 180));
				if(field[x][y]!=null&&field[x][y].isBuildingExisting())
				g.setColor(Color.BLACK);
			}
		paintBuildings(g);
	}
	
private void paintBuildings(Graphics g) {
		g.drawImage(schild, 100, 100, 232, 291, null);
		
	}

	//	public void setSize(Dimension d){
//		super.setSize(d.width, d.width);
//	}
	public void setSize(int width, int heigth){
		super.setSize(width, width);
	}
//	public void setBounds(Rectangle r){
//		super.setBounds(r.x, r.y, r.width, r.width);
//	}
//	public void setBounds(int a, int b, int width, int heigth){
//		super.setBounds(a, b, width, width);
//	}
//	
	public void setMap(Field[][] field){
		this.field=field;
	}

//public static void main(String[]args){
//	final JFrame frame =new JFrame();
//
//	final Field [][] k=new Field [20][20];
//	k[0][0]=new Desert(0, 0);
//	k[0][1]=new Grass(0, 1);
//	k[0][2]=new Iron(0, 2);
//	k[1][0]=new Marble(1, 0);
//	k[1][1]=new Stones(1, 1);
//	k[1][2]=new Water(1, 2);
//	k[2][0]=new Wheat(2, 0);
//	k[2][1]=new Desert(2, 1);
//	k[2][2]=null;
//	k[3][0]=null;
//	k[3][1]=null;
//	k[3][2]=new Wheat(3,2);
//	k[2][1]= new Wheat(2, 1);
//	k[15][2] = new Marble(15,2);
//	PlayingField f = new PlayingField(k);
//	//f.setPreferredSize(new Dimension (500, 500));
//	frame.setSize(200, 200);
//	frame.setVisible(true);
//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	frame.setContentPane(f);

//	frame.requestFocus();
//	frame.addKeyListener(new KeyAdapter()
//    {
//        public void keyPressed(KeyEvent e)
//        {
//        	if (e.getKeyCode() == KeyEvent.VK_W) {
//        	      System.out.println("UP");
//				ymapmove = ymapmove+10;
//				frame.repaint();
//        	    }
//        	if (e.getKeyCode() == KeyEvent.VK_S) {
//      	      System.out.println("DOWN");
//				ymapmove = ymapmove-10;
//				frame.repaint();
//      	    }
//        	if (e.getKeyCode() == KeyEvent.VK_D) {
//      	      System.out.println("RIGHT");
//				xmapmove = xmapmove-10;
//				frame.repaint();
//      	    }
//        	if (e.getKeyCode() == KeyEvent.VK_A) {
//      	      System.out.println("LEFT");
//				xmapmove = xmapmove+10;
//				frame.repaint();
//      	    }
//        }
//    });


//}

	public static int[] actualPosition(int x, int y){
		double xact;
		double yact;
		int xtile;
		int ytile;
		int xcorner;
		int ycorner;
		xact = x+xmapmove;
		yact =y+ymapmove;
		xtile = (int) (xact*Math.cos(Math.PI*1.75)-yact*Math.sin(Math.PI*1.75)*2);		//rotation um 315�
		ytile = (int) (xact*Math.sin(Math.PI*1.75)+yact*Math.cos(Math.PI*1.75)*2);
		System.out.println("xact: "+xtile);
		System.out.println("yact: "+ytile);
													
		if(xtile%pixelsize!=0){							// die Ecke der Kachel ausgeben, damit von dort aus gezeichnet werden kann
			xcorner =xtile-xtile%pixelsize;
			System.out.println("xcorner: "+xcorner);
		}else{
			xcorner = xtile;
		}
		if(ytile%pixelsize!=0){
			ycorner = ytile-ytile%pixelsize;
			System.out.println("ycorner: "+ycorner);
		}else{
			ycorner = ytile;
		}
		int[] array = new int[2];
		array[0]=xcorner;
		array[1]=ycorner;
		return array;
	}
}

