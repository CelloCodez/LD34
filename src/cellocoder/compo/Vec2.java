package cellocoder.compo;

public class Vec2 {
	
	public float x = 0, y = 0;
	
	public Vec2(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vec2 add(Vec2 b) {
		return new Vec2(x + b.x, y + b.y);
	}
	
	public Vec2 sub(Vec2 b) {
		return new Vec2(x - b.x, y - b.y);
	}
	
	public Vec2 scale(float b) {
		return new Vec2(x * b, y * b);
	}
	
	public float dist(Vec2 b) {
		return (float) Math.sqrt((x - b.x) * (x - b.x) + (y - b.y) * (y - b.y));
	}
	
	public Vec2 div(Vec2 b) {
		return new Vec2(x / b.x, y / b.y);
	}
	
	public boolean inside(Vec2 pos1, Vec2 pos2) {
		return x >= pos1.x && x <= pos2.x && y >= pos1.y && y <= pos2.y;
	}
	
	public String toString() {
		return "Vec2: { x: " + x + " y: " + y + " }";
	}
	
}
