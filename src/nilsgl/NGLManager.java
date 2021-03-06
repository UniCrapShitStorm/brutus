package nilsgl;

import ground.Desert;
import ground.Field;
import ground.Grass;
import ground.Iron;
import ground.Marble;
import ground.Stones;
import ground.Water;
import ground.Wheat;
import gui.PlayingField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.nio.FloatBuffer;

import javax.swing.JPanel;
import javax.media.opengl.*;
import javax.media.opengl.awt.*;
//import javax.media.opengl.glu.*;


public class NGLManager implements GLEventListener
{
	public int quadid[];
	
	public Field map[][];
	
	static public GL2 gl;
	public GLCanvas canvas;
	
	public float camx = 0.0f;
	public float camy = 0.0f;
	
	public float pixelsize = 100.0f;
	
	public NGLManager(JPanel frame)
	{
		GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        canvas = new GLCanvas(caps);
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        canvas.addGLEventListener(this);
        
        canvas.addMouseListener(new MouseListener(){

			@Override
			public void mousePressed(java.awt.event.MouseEvent m) {
				canvas.requestFocus();
				int but = m.getButton();
				if(but==1){
					System.out.println("x: "+m.getX());
					System.out.println("y: "+m.getY()+"\n");
					int [] cornerarray ={m.getX(),m.getY()};
					PlayingField.actualPosition(m.getX(), m.getY());
					int xmap = (int) (cornerarray[0]/pixelsize);
					int ymap = (int) (cornerarray[1]/pixelsize);
//					if(baumode==true){
//						//paintBuildings(playField.g);
//						playField.repaint();
//					}
//				}
//				if (but==3){
//					baumode=false;
				}
			}

			@Override
			public void mouseEntered(java.awt.event.MouseEvent m) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent m) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseClicked(java.awt.event.MouseEvent m) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(java.awt.event.MouseEvent m) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
	}
	
	public void render(GLAutoDrawable drawable)
	{
		gl = (GL2)drawable.getGL();
//		GLU glu = new GLU();
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		
//		gl.glCullFace(GL.GL_NONE);
//		gl.glDisable(GL.GL_CULL_FACE);
		
		//Modellmatrix initialisieren
		gl.glLoadIdentity();
		//Kamera positionieren
//		glu.gluLookAt(0,0,0.5,0,0,0,0,1,0);
		
		if(NGLQuad.quadlist == null)
			return;
		
//		camx += 50.0f;
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		
		for(NGLQuad quad : NGLQuad.quadlist)
		{
			gl.glLoadIdentity();
			
			gl.glTranslatef(-camx, -camy, 0.0f);
			
			if(!quad.isIsometric)
			{
				gl.glScalef(1.0f, 0.5f, 1.0f);
				gl.glRotatef(45.0f, 0.0f, 0.0f, 1.0f);
			}
			
			gl.glTranslatef(quad.posx,  quad.posy, 0.0f);
			gl.glScalef(quad.sizex,  quad.sizey, 0.0f);
			
			quad.texture.tex.bind(gl);
			gl.glBindBuffer(GL.GL_ARRAY_BUFFER, quadid[0]);
			gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
			gl.glEnableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
			gl.glVertexPointer(3, GL.GL_FLOAT, 20, 0);
			gl.glTexCoordPointer(2, GL.GL_FLOAT, 20, 12);
			gl.glDrawArrays(GL.GL_TRIANGLE_STRIP, 0, 4);
			gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
			gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
			gl.glBindBuffer(GL.GL_ARRAY_BUFFER, 0);
		}
	}
	
	// Implement methods defined in GLEventListener
	@Override
	public void init(GLAutoDrawable drawable)
	{
		gl = (GL2)drawable.getGL();
		
		gl.glEnable(GL.GL_TEXTURE_2D);
		
		quadid = new int[1];
		gl.glGenBuffers(1, quadid, 0);
		gl.glBindBuffer(GL.GL_ARRAY_BUFFER, quadid[0]);
		
		FloatBuffer quadverts = FloatBuffer.allocate(20);

		quadverts.put(0.0f);
		quadverts.put(1.0f);
		quadverts.put(0.0f);
		quadverts.put(0.0f);
		quadverts.put(0.0f);
		
		quadverts.put(0.0f);
		quadverts.put(0.0f);
		quadverts.put(0.0f);
		quadverts.put(0.0f);
		quadverts.put(1.0f);
		
		quadverts.put(1.0f);
		quadverts.put(1.0f);
		quadverts.put(0.0f);
		quadverts.put(1.0f);
		quadverts.put(0.0f);
		
		quadverts.put(1.0f);
		quadverts.put(0.0f);
		quadverts.put(0.0f);
		quadverts.put(1.0f);
		quadverts.put(1.0f);
		
		quadverts.rewind();
		gl.glBufferData(GL.GL_ARRAY_BUFFER, 80, quadverts, GL.GL_STATIC_DRAW);
		
/*		for(int x = 0; x < 100; x++)
		{
			for(int y = 0; y < 100; y++)
			{
				NGLQuad.getQuad("bin/img/gras1_klein.jpg", x*100.0f, y*100.0f, 100.0f, 100.0f, gl);
			}
		}*/
		
		for(int x = 0; x < map.length; x++)
		{
			for(int y = 0; y < map[0].length; y++)
			{
				if(map[x][y] == null)
				{
					NGLQuad.getQuad("bin/img/gras1_klein.jpg", x*100.0f, y*100.0f, 100.0f, 100.0f, gl);
				}
				else if(map[x][y] instanceof Desert)
				{
					NGLQuad.getQuad("bin/img/wueste1.jpg", x*100.0f, y*100.0f, 100.0f, 100.0f, gl);
				}
				else if(map[x][y] instanceof Grass)
				{
					NGLQuad.getQuad("bin/img/gras1_klein.jpg", x*100.0f, y*100.0f, 100.0f, 100.0f, gl);
				}
				else if(map[x][y] instanceof Iron)
				{
					
				}	
				else if(map[x][y] instanceof Marble)
				{
					
				}
				else if(map[x][y] instanceof Stones)
				{
					
				}
				else if(map[x][y] instanceof Water)
				{
					
				}
				else if(map[x][y] instanceof Wheat)
				{
					
				}
				
				//if(field[x][y]!=null&&field[x][y].isBuildingExisting())
					//g.setColor(Color.BLACK);
			}
		}
		
		NGLQuad.getQuad("bin/img/lager.png", 100, 100, 480, 270, gl).isIsometric = true;
		
//		camx = -100;
//		camy = 300;
	}

	@Override
	public void display(GLAutoDrawable drawable)
	{
		render(drawable);
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height)
	{
		gl = (GL2)drawable.getGL();
		
		gl.glViewport(0, 0, width, height);
		//Auf Projektionsmatrix umschalten
		gl.glMatrixMode(GL2.GL_PROJECTION);
		//Projektionsmwtrix initialisieren
		gl.glLoadIdentity();
		//Orthogonalprojektion w�hlen
		gl.glOrtho(0, width, height, 0, -1, 1);
		//und wieder auf Modellmatrix zur�cksetzen
		gl.glMatrixMode(GL2.GL_MODELVIEW);
	}

	@Override
	public void dispose(GLAutoDrawable drawable){}
}
