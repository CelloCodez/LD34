package cellocoder.compo;

import java.util.HashMap;

import org.lwjgl.opengl.GL11;

public class Font {
	
	private static HashMap<String, Vec2> location = new HashMap<String, Vec2>();
	private static final int tiles = 8;
	
	public static void init() {
		location.put("a", new Vec2(0, 0));
		location.put("b", new Vec2(1, 0));
		location.put("c", new Vec2(2, 0));
		location.put("d", new Vec2(3, 0));
		location.put("e", new Vec2(4, 0));
		location.put("f", new Vec2(5, 0));
		location.put("g", new Vec2(6, 0));
		location.put("h", new Vec2(7, 0));
		location.put("i", new Vec2(0, 1));
		location.put("j", new Vec2(1, 1));
		location.put("k", new Vec2(2, 1));
		location.put("l", new Vec2(3, 1));
		location.put("m", new Vec2(4, 1));
		location.put("n", new Vec2(5, 1));
		location.put("o", new Vec2(6, 1));
		location.put("p", new Vec2(7, 1));
		location.put("q", new Vec2(0, 2));
		location.put("r", new Vec2(1, 2));
		location.put("s", new Vec2(2, 2));
		location.put("t", new Vec2(3, 2));
		location.put("u", new Vec2(4, 2));
		location.put("v", new Vec2(5, 2));
		location.put("w", new Vec2(6, 2));
		location.put("x", new Vec2(7, 2));
		location.put("y", new Vec2(0, 3));
		location.put("z", new Vec2(1, 3));
		location.put("?", new Vec2(2, 3));
		location.put("!", new Vec2(3, 3));
		location.put(".", new Vec2(4, 3));
		location.put("-", new Vec2(5, 3));
		location.put("+", new Vec2(6, 3));
		location.put("0", new Vec2(7, 3));
		location.put("1", new Vec2(0, 4));
		location.put("2", new Vec2(1, 4));
		location.put("3", new Vec2(2, 4));
		location.put("4", new Vec2(3, 4));
		location.put("5", new Vec2(4, 4));
		location.put("6", new Vec2(5, 4));
		location.put("7", new Vec2(6, 4));
		location.put("8", new Vec2(7, 4));
		location.put("9", new Vec2(0, 5));
		location.put(":", new Vec2(1, 5));
		location.put(";", new Vec2(2, 5));
		location.put("(", new Vec2(3, 5));
		location.put(")", new Vec2(4, 5));
		location.put("\"", new Vec2(5, 5));
		location.put("/", new Vec2(6, 5));
		location.put(",", new Vec2(7, 5));
		location.put("'", new Vec2(0, 6));
	}
	
	public static void text(Vec2 pos, String string) {
		GL11.glPushMatrix();
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, Tex.FONT);
		GL11.glTranslatef(pos.x, pos.y, 0);
		int translates = 0;
		
		String str = string.toLowerCase();
		for (char c : str.toCharArray()) {
			String letter = new String(c + "");
			if (letter.equals("\n")) {
				GL11.glTranslatef(-32 * translates, 32, 0);
				translates = 0;
			} else if (!(letter.equals(" ") || letter.isEmpty())) {
				Vec2 loc1 = location.get(letter).div(new Vec2(tiles, tiles));
				Vec2 loc2 = location.get(letter).add(new Vec2(1, 1)).div(new Vec2(tiles, tiles));
				
				GL11.glBegin(GL11.GL_QUADS);
				GL11.glTexCoord2f(loc1.x, loc1.y);
				GL11.glVertex2f(0, 0);
				GL11.glTexCoord2f(loc2.x, loc1.y);
				GL11.glVertex2f(32, 0);
				GL11.glTexCoord2f(loc2.x, loc2.y);
				GL11.glVertex2f(32, 32);
				GL11.glTexCoord2f(loc1.x, loc2.y);
				GL11.glVertex2f(0, 32);
				GL11.glEnd();
			}
			
			translates++;
			GL11.glTranslatef(32, 0, 0);
		}
		
		GL11.glPopMatrix();
	}
}
