package cellocoder.compo;

import org.lwjgl.opengl.GL11;

/**
 * I prefer the word 'render' but 'draw' is a lot quicker to type.
 */
public class Draw {
	
	public static void box(Vec2 pos, Vec2 size, float rot) {
		GL11.glPushMatrix();
		
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		
		GL11.glTranslatef(pos.x, pos.y, 0);
		GL11.glRotatef(rot, 0, 0, 1);
		
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(0, 0);
		GL11.glVertex2f(size.x, 0);
		GL11.glVertex2f(size.x, size.y);
		GL11.glVertex2f(0, size.y);
		GL11.glEnd();
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		
		GL11.glPopMatrix();
	}
	
	public static void boxTex(Vec2 pos, Vec2 size, float rot, int tex) {
		GL11.glPushMatrix();
		
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, tex);
		
		GL11.glTranslatef(pos.x, pos.y, 0);
		GL11.glRotatef(rot, 0, 0, 1);
		
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex2f(0, 0);
		GL11.glTexCoord2f(1, 0);
		GL11.glVertex2f(size.x, 0);
		GL11.glTexCoord2f(1, 1);
		GL11.glVertex2f(size.x, size.y);
		GL11.glTexCoord2f(0, 1);
		GL11.glVertex2f(0, size.y);
		GL11.glEnd();
		
		GL11.glPopMatrix();
	}
	
	public static void boxTex3D(Vec2 pos, Vec2 size, float rotX, float rotY, float rotZ, int tex) {
		GL11.glPushMatrix();
		
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, tex);
		
		GL11.glTranslatef(pos.x, pos.y, 0);
		GL11.glRotatef(rotX, 1, 0, 0);
		GL11.glRotatef(rotY, 0, 1, 0);
		GL11.glRotatef(rotZ, 0, 0, 1);
		
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex2f(0, 0);
		GL11.glTexCoord2f(1, 0);
		GL11.glVertex2f(size.x, 0);
		GL11.glTexCoord2f(1, 1);
		GL11.glVertex2f(size.x, size.y);
		GL11.glTexCoord2f(0, 1);
		GL11.glVertex2f(0, size.y);
		GL11.glEnd();
		
		GL11.glPopMatrix();
	}
	
}
