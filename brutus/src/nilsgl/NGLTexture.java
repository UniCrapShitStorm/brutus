package nilsgl;

import java.io.File;
import java.util.HashMap;

import javax.media.opengl.GL;
import javax.media.opengl.*;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

public class NGLTexture
{
	public static HashMap<String, NGLTexture> texlist = null;
	public Texture tex;
	
	public NGLTexture(String filename, GL gl)
	{
		tex = null;
		try
		{
			tex = TextureIO.newTexture(new File(filename), false);
			tex.setTexParameteri(gl, GL2.GL_TEXTURE_MAG_FILTER, GL2.GL_NEAREST);
			tex.setTexParameteri(gl, GL2.GL_TEXTURE_MIN_FILTER, GL2.GL_NEAREST);
		}
		catch(Exception e)
		{
			System.out.println("Error loading texture " + filename);
		}
	}
	
	protected void finalize() throws Throwable
	{
		
		super.finalize();
	} 
	
	static public NGLTexture getTexture(String texfile, GL gl)
	{
		if(texlist == null)
			texlist = new HashMap<String, NGLTexture>();
		
		if(texlist.containsKey(texfile))
		{
			return texlist.get(texfile);
		}
		
		NGLTexture tex = new NGLTexture(texfile, gl);
		texlist.put(texfile, tex);
		return tex;
	}
}
