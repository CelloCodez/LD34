package cellocoder.compo;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class LudumDare {
	
	public static LudumDare ld;
	
	public static final String TITLE = "Ludum Dare";
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 900;
	
	public boolean running = false;
	
	public GameManager gameManager;
	
	public LudumDare() {
		Display.setTitle(TITLE);
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setResizable(false);
			Display.setVSyncEnabled(true);
			Display.create();
			Keyboard.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, WIDTH, HEIGHT, 0, -1000f, 1000f);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		GL11.glClearColor(0, 0.5f, 1, 1);
		
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
	}
	
	public void start() {
		if (running)
			return;
		running = true;
		
		gameManager = new GameManager();
		
		while (running) {
			Input.tick();
			gameManager.tick();
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			gameManager.render();
			
			Display.update();
			Display.sync(60);
			
			if (Display.isCloseRequested()) {
				running = false;
			}
		}
		
		Keyboard.destroy();
		Display.destroy();
	}
	
	public static void main(String[] args) {
		ld = new LudumDare();
		ld.start();
	}
	
}
