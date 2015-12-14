package cellocoder.compo;

import org.lwjgl.input.Keyboard;

public class Input {
	
	// there are only two possible buttons, what could go wrong
	
	public static boolean Z = false;
	public static boolean Z_TAP = false;
	public static boolean X = false;
	public static boolean X_TAP = false;
	
	private static boolean oldZ = false;
	private static boolean oldX = false;
	
	public static void tick() {
		Z = Keyboard.isKeyDown(Keyboard.KEY_Z);
		X = Keyboard.isKeyDown(Keyboard.KEY_X);
		
		Z_TAP = Z && !oldZ;
		X_TAP = X && !oldX;
		
		oldZ = Z;
		oldX = X;
	}
	
}
