package cellocoder.compo;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Tex {
	
	public static final int FONT = loadTex("./font.png");
	
	public static final int GRASS = loadTex("./grass.png");
	public static final int STUFF = loadTex("./stuff.png");
	public static final int DUST = loadTex("./dust.png");
	public static final int EGG = loadTex("./egg.png");
	public static final int FLOWER = loadTex("./flower.png");
	public static final int BACON = loadTex("./bacon.png");
	public static final int CAP = loadTex("./cap.png");
	
	public static int loadTex(String fileName) {
		int res = 0;
		try {
			res = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(fileName), GL11.GL_NEAREST).getTextureID();
		} catch (IOException e) {
			throw new RuntimeException("Error loading PNG texture: " + fileName);
		}
		return res;
	}
	
}
