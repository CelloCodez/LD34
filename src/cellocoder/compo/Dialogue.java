package cellocoder.compo;

public class Dialogue {
	
	public String[] msgs;
	public int numMsgs;
	
	public int curNum = 0;
	public int msgChar = 0;
	
	public long timerNum = 0;
	
	public Dialogue(String[] messages, int numMessages) {
		msgs = messages;
		numMsgs = numMessages;
		curNum = 0;
		msgChar = 0;
		timerNum = 0;
	}
	
	public ReturnState tick() {
		if (Input.X_TAP || Input.Z_TAP) {
			if (msgChar < msgs[curNum].toCharArray().length) {
				msgChar = msgs[curNum].toCharArray().length;
			} else {
				msgChar = 0;
				if (++curNum >= numMsgs) {
					return ReturnState.SUCCESS;
				}
			}
		} else {
			if (timerNum == 0) {
				timerNum = System.currentTimeMillis();
			} else {
				if (System.currentTimeMillis() - timerNum > 100) {
					if (msgChar < msgs[curNum].toCharArray().length) {
						msgChar++;
						Sound.play(Sound.TYPE);
					}
					timerNum = System.currentTimeMillis();
				}
			}
		}
		
		return ReturnState.NORMAL;
	}
	
	public void render() {
		Font.text(new Vec2(64, 64), msgs[curNum].substring(0, msgChar));
	}
	
}
