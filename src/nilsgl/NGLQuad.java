package nilsgl;

import java.util.ArrayList;

import javax.media.opengl.GL;

public class NGLQuad
{
	public static ArrayList<NGLQuad> quadlist = null;
	
	public NGLTexture texture;
	public float posx;
	public float posy;
	public float sizex;
	public float sizey;
	public boolean isIsometric = false;
	
	public NGLQuad(String texfile, float x, float y, float sx, float sy, GL gl)
	{
		texture = NGLTexture.getTexture(texfile, gl);
		posx = x;
		posy = y;
		sizex = sx;
		sizey = sy;
	}
	
	public void moveToTop()
	{
		quadlist.add(this);
		quadlist.remove(this);
	}
	
	static public NGLQuad getQuad(String texfile, float x, float y, float sx, float sy, GL gl)
	{
		if(quadlist == null)
			quadlist = new ArrayList<NGLQuad>();
		
		NGLQuad quad = new NGLQuad(texfile, x, y, sx, sy, gl);
		quadlist.add(quad);
		return quad;
	}
}
