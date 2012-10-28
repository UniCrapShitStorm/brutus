package nilsgl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import javax.media.opengl.*;

public class NGLShader
{
	static public HashMap<String, NGLShader> shadlist = null;
	
	public int shadid = 0;
	
	public NGLShader(String shadfile, GL2 gl)
	{
		create(shadfile, gl);
	}
	
	public boolean compileShader(int shader[], int type, String shadfile, GL2 gl)
	{
		int status[] = new int[1];
		String source;
		
		BufferedReader vert_reader;
		try
		{
			vert_reader = new BufferedReader(new FileReader(shadfile));
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e);
			return false;
		}
		 
        String[] vshader = new String[1];
        String line;
        try
        {
            line = vert_reader.readLine();
            while (line != null)
            {
                vshader[0] += line + "\n";
                line = vert_reader.readLine(); 
            }                
        }
        catch (IOException e)
        {
            System.out.println(e);
            return false;
        }    
        int[] vlen = new int[1];
        vlen[0] = vshader[0].length();

		shader[0] = gl.glCreateShader(type);
		gl.glShaderSource(shader[0], 1, vshader, vlen, 1);
		gl.glCompileShader(shader[0]);

		int logLength[] = new int[1];
		gl.glGetShaderiv(shader[0], GL2.GL_INFO_LOG_LENGTH, logLength, 1);
		if(logLength[0] > 0)
		{
//			GLchar *log = (GLchar *)malloc(logLength);
//			glGetShaderInfoLog(*shader, logLength, &logLength, log);
//			sgLog("%s: Shader compile log:\n %s", filepath, log);
		}

		gl.glGetShaderiv(shader[0], GL2.GL_COMPILE_STATUS, status, 1);
		if(status[0] == 0)
		{
			gl.glDeleteShader(shader[0]);
			return false;
		}

		return true;
	}

	public boolean linkProgram(int prog, GL2 gl)
	{
		int status[] = new int[1];

		gl.glLinkProgram(prog);

		int logLength[] = new int[1];
		gl.glGetProgramiv(prog, GL2.GL_INFO_LOG_LENGTH, logLength, 0);
		if(logLength[0] > 0)
		{
//			gl.glGetProgramInfoLog(prog, logLength, &logLength, log);
			System.out.println("%s and %s: Program link log:\n %s");
		}

		gl.glGetProgramiv(prog, GL2.GL_LINK_STATUS, status, 0);
		if(status[0] == 0)
			return false;

		return true;
	}

	public boolean validateProgram(GL2 gl)
	{
		int logLength[] = new int[1];
		int status[] = new int[1];

		gl.glValidateProgram(shadid);
		gl.glGetProgramiv(shadid, GL2.GL_INFO_LOG_LENGTH, logLength, 0);
		if(logLength[0] > 0)
		{
//			glGetProgramInfoLog(program, logLength, &logLength, log);
			System.out.println("Program validate log:\n%s");
		}

		gl.glGetProgramiv(shadid, GL2.GL_VALIDATE_STATUS, status, 0);
		if(status[0] == 0)
			return false;

		return true;
	}
	
	public boolean create(String shadfile, GL2 gl)
	{
		if(shadid != 0)
			return false;

		int vertShader[] = new int[1];
		int fragShader[] = new int[1];

		// Create shader program
		shadid = gl.glCreateProgram();

		// Create and compile vertex shader
		if(!compileShader(vertShader, GL2.GL_VERTEX_SHADER, shadfile, gl))
		{
			System.out.println(shadfile + ": Failed to compile vertex shader");
			return false;
		}

		// Create and compile fragment shader
		if(!compileShader(fragShader, GL2.GL_FRAGMENT_SHADER, shadfile, gl))
		{
			System.out.println(shadfile + ": Failed to compile fragment shader");
			return false;
		}

		// Attach vertex shader to program
		gl.glAttachShader(shadid, vertShader[0]);

		// Attach fragment shader to program
		gl.glAttachShader(shadid, fragShader[0]);

		// Link program
		if(!linkProgram(shadid, gl))
		{
			System.out.println("Failed to link program" + shadid);

			if(shadid != 0)
			{
				gl.glDeleteProgram(shadid);
				shadid = 0;
			}

			if(vertShader[0] != 0)
			{
				gl.glDeleteShader(vertShader[0]);
			}
			if(fragShader[0] != 0)
			{
				gl.glDeleteShader(fragShader[0]);
			}

			return false;
		}

		if(vertShader[0] != -1)
		{
			gl.glDetachShader(shadid, vertShader[0]);
			gl.glDeleteShader(vertShader[0]);
		}

		if(fragShader[0] != 0)
		{
			gl.glDetachShader(shadid, fragShader[0]);
			gl.glDeleteShader(fragShader[0]);
		}

//		getEngineUniforms();

		return true;
	}
	
	static public NGLShader getShader(String shadfile, GL2 gl)
	{
		if(shadlist == null)
			shadlist = new HashMap<String, NGLShader>();
		
		if(shadlist.containsKey(shadfile))
		{
			return shadlist.get(shadfile);
		}
		
		NGLShader shad = new NGLShader(shadfile, gl);
		shadlist.put(shadfile, shad);
		return shad;
	}
}
