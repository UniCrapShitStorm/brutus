import ground.Marble;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class InputKeyEvents extends KeyAdapter {
	
	public int getPixelsize(){
		int pixelsize = getPixelsize();
		return pixelsize;
	}
	
		PlayingField pf;
		double a = pf.pixelsize*SwingGui.testfield[0].length;			//todo: das hier woanders berechnen
		double b = pf.pixelsize*SwingGui.testfield[1].length;
		double c = Math.sqrt(a*a+b*b);
	
	public void keyPressed(KeyEvent e)
	{
			int key = e.getKeyCode();
		if (key == KeyEvent.VK_W)
		{
      		if(SwingGui.playField.ngl.camy > 0)
      		{
      			System.out.println("UP");
      			SwingGui.playField.ngl.camy -= 10;
      			SwingGui.playField.ngl.canvas.repaint();
      		}
      	}
      	if(key == KeyEvent.VK_S)
      	{
      		
    	      System.out.println("DOWN");
    	      SwingGui.playField.ngl.camy += 10;
    	      SwingGui.playField.ngl.canvas.repaint();
      		
    	}
      	if(key == KeyEvent.VK_D)
      	{
		     System.out.println("RIGHT");
		     SwingGui.playField.ngl.camx += 10;
		     SwingGui.playField.ngl.canvas.repaint();
	    }
      	if(key == KeyEvent.VK_A)
      	{
 //     		double width = (a*b)/c;
 //     		if(pf.xmapmove<width){
    	      System.out.println("LEFT");
    	      SwingGui.playField.ngl.camx -= 10;
    	      SwingGui.playField.ngl.canvas.repaint();
 //     		}
    	}
	}
	
	
	public void keyTyped(KeyEvent e){
	}

}
