package cellocoder.compo;

public class Item {
	
	public static Item egg = new Item("Egg", 0, 1, Tex.EGG, new Vec2(32, 32));
	public static Item flower = new Item("Flower", 0, 1, Tex.FLOWER, new Vec2(64, 64));
	public static Item bacon = new Item("Bacon", 0, 1, Tex.BACON, new Vec2(32, 32));
	public static Item cap = new Item("Ludum-Cola Cap", 0, 1, Tex.CAP, new Vec2(48, 48));
	
	private String name = "";
	private int minGrowth = 0;
	private int score = 0;
	private int tex = 0;
	private Vec2 pos = new Vec2(0, 0);
	private Vec2 size = new Vec2(64, 64);
	
	public Item(String name, int minGrowth, int score, int tex, Vec2 size) {
		this.name = name;
		this.minGrowth = minGrowth;
		this.score = score;
		this.tex = tex;
		this.size = size;
	}
	
	public Item(Item item) {
		this.name = item.getName();
		this.minGrowth = item.getMinGrowth();
		this.score = item.getScore();
		this.tex = item.getTex();
		this.size = item.getSize();
	}
	
	public String getName() {
		return name;
	}
	
	public int getMinGrowth() {
		return minGrowth;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getTex() {
		return tex;
	}
	
	public Vec2 getPos() {
		return pos;
	}
	
	public void setPos(Vec2 pos) {
		this.pos = pos;
	}
	
	public Vec2 getSize() {
		return size;
	}
	
	public void setSize(Vec2 size) {
		this.size = size;
	}
	
}
