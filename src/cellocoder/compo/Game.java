package cellocoder.compo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.opengl.GL11;

public class Game {
	
	public Vec2 pPos = new Vec2(256, 256);
	public float pDir = 0;
	public float speed = 10;
	public float anim = 0;
	public float size = 1;
	
	public float goal = 100;
	public float time = 100;
	
	private long initialTime = 0;
	
	public boolean mode3d = false;
	
	//	public Particle dust;
	
	public List<Item> items = new ArrayList<Item>();
	
	public String oldTime = "";
	
	public Game(float goal, float time) {
		Font.init();
		
		this.goal = goal;
		this.time = time;
		initialTime = 0;
		
		//		dust = new Particle(Tex.DUST);
		
		Random rand = new Random();
		for (int i = 0; i < 2500; i++) {
			Item item = new Item(Item.flower);
			int randInt = rand.nextInt(4);
			switch (randInt) {
				case 0:
					item = new Item(Item.egg);
					break;
				case 1:
					item = new Item(Item.flower);
					break;
				case 2:
					item = new Item(Item.bacon);
					break;
				case 3:
					item = new Item(Item.cap);
					break;
				default:
					item = new Item(Item.flower);
					break;
			}
			
			item.setPos(new Vec2(rand.nextInt(6000) - 3000, rand.nextInt(6000) - 3000));
			items.add(item);
		}
		
		//				Item test = new Item("asdf", 0, 100, Tex.FONT, new Vec2(128, 128));
		//				test.setPos(new Vec2(256, 256));
		//				items.add(test);
	}
	
	public ReturnState tick() {
		if (initialTime == 0) {
			initialTime = System.currentTimeMillis();
		} else if (((System.currentTimeMillis() - initialTime) / 1000) > time) {
			if (size >= goal) {
				return ReturnState.SUCCESS;
			} else {
				return ReturnState.FAILURE;
			}
		}
		
		if (size >= goal) {
			return ReturnState.SUCCESS;
		}
		
		mode3d = true;
		
		if (!oldTime.equals(((System.currentTimeMillis() - initialTime) / 1000) + "")) {
			Sound.play(Sound.TIMERTICK);
		}
		
		if (Input.Z) {
			if (Input.X) {
				// both (forward)
				pPos.x += (float) Math.sin(Math.toRadians(pDir)) * speed;
				pPos.y += (float) Math.cos(Math.toRadians(pDir)) * speed;
				anim += 10;
			} else {
				pDir += 2;
				anim += 8;
			}
		} else if (Input.X) {
			pDir -= 2;
			anim += 8;
		}
		
		List<Item> removeItems = new ArrayList<Item>();
		for (Item item : items) {
			if (item.getPos().scale(-1).add(new Vec2(575, 436)).dist(pPos) <= item.getSize().x + 64) {
				if (size >= item.getMinGrowth()) {
					size += item.getScore();
					removeItems.add(item);
				}
			}
		}
		for (Item item : removeItems) {
			items.remove(item);
		}
		
		//		if (Input.X_TAP) {
		//			dust.spawn(10, 3, 0.5f);
		//		}
		
		//		System.out.println(pPos);
		
		oldTime = ((System.currentTimeMillis() - initialTime) / 1000) + "";
		
		return ReturnState.NORMAL;
	}
	
	public void render() {
		// map scrolling/rotation effect
		
		GL11.glPushMatrix();
		
		if (mode3d) {
			// magical 3d scaling effect
			GL11.glTranslatef(0, 256, 0);
			GL11.glScalef(1, 0.375f, 1);
		}
		
		//		 debug mode effect
		//		GL11.glScalef(0.1f, 0.1f, 1);
		//		GL11.glTranslatef(5000, 5000, 0);
		
		GL11.glPushMatrix();
		
		GL11.glTranslatef(600, 450, 0);
		GL11.glRotatef(pDir, 0, 0, 1);
		
		for (int x = 0; x < 32; x++) {
			for (int y = 0; y < 32; y++) {
				Draw.boxTex(new Vec2(x * 128 - 1536 + (pPos.x % 128), y * 128 - 1536 + (pPos.y % 128)), new Vec2(128, 128), 0, Tex.GRASS);
			}
		}
		
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(600, 450, 0);
		GL11.glRotatef(pDir, 0, 0, 1);
		GL11.glTranslatef(-600, -450, 0);
		for (Item item : items) {
			Draw.boxTex(item.getPos().add(pPos), item.getSize(), 0, item.getTex());
		}
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(536, 425, 0);
		if (mode3d) {
			GL11.glScalef(1, 2f, 1);
		}
		GL11.glRotatef(anim / 5, 1, 0, 0);
		GL11.glRotatef((float) Math.sin(anim / 50) * 2, 0, 0, 1);
		Draw.boxTex3D(new Vec2(0, -64), new Vec2(128, 128), 0, (float) Math.sin(anim / 200) * 6, 0, Tex.STUFF);
		GL11.glRotatef(30, 1, 0, 0);
		Draw.boxTex3D(new Vec2(0, -64), new Vec2(128, 128), 0, (float) Math.sin(anim / 200) * 6, 0, Tex.STUFF);
		GL11.glRotatef(30, 1, 0, 0);
		Draw.boxTex3D(new Vec2(0, -64), new Vec2(128, 128), 0, (float) Math.sin(anim / 200) * 6, 0, Tex.STUFF);
		GL11.glRotatef(30, 1, 0, 0);
		Draw.boxTex3D(new Vec2(0, -64), new Vec2(128, 128), 0, (float) Math.sin(anim / 200) * 6, 0, Tex.STUFF);
		GL11.glRotatef(30, 1, 0, 0);
		Draw.boxTex3D(new Vec2(0, -64), new Vec2(128, 128), 0, (float) Math.sin(anim / 200) * 6, 0, Tex.STUFF);
		GL11.glPopMatrix();
		
		//		dust.render(new Vec2(50, 50));
		
		GL11.glPopMatrix();
		
		Font.text(new Vec2(0, 0), "Score: " + size + " / " + goal);
		Font.text(new Vec2(0, 64), "Time: " + ((System.currentTimeMillis() - initialTime) / 1000) + " / " + time);
	}
	
}
