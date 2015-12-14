package cellocoder.compo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Particle {
	
	// I'm wasting too much time on here!!!
	
	private List<Vec2> particles = new ArrayList<Vec2>();
	private int tex = 0;
	private int timer = 0;
	private float spread = 0.05f;
	
	public Particle(int tex) {
		this.tex = tex;
	}
	
	public void spawn(int num, float d, float spread) {
		Random rand = new Random();
		for (int i = 0; i < num; i++) {
//			float d = rand.nextFloat() * dist;
			float dir = (float) rand.nextInt(360);
			Vec2 pos = new Vec2(0, 0);
			pos.x = (float) Math.sin(Math.toRadians(dir)) * d;
			pos.y = (float) Math.cos(Math.toRadians(dir)) * d;
			particles.add(pos);
		}
		timer = 60;
		this.spread = spread;
	}
	
	public void render(Vec2 position) {
		if (particles.size() > 0) {
			for (Vec2 pos : particles) {
				Draw.boxTex(position.add(pos), new Vec2(64, 64), 0, tex);
				float dir = pos.y / pos.x;
				pos.x += spread;
				pos.y += dir * spread;
			}
			timer--;
			if (timer < 1) {
				timer = 0;
				particles.clear();
			}
		} else {
			timer = 0;
		}
	}
}
