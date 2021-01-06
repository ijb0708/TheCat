package MouseController;

public class Mouse {
	
	//¸¶¿ì½º ½Ì±ÛÅæ
	private static Mouse mouse = new Mouse();
	
	public static Mouse getInstance() {
		return mouse;
	}
	
	//x, y ÁÂÇ¥ ¹× º»ÄÚµå
	private static final int basicX= 150;
	private static final int basicY= 150;
	
	private int mouseX;
	private int mouseY;
	
	private Mouse() {
		mouseX= basicX;
		mouseY= basicY;
	}
	
	public void setXY(int mouseX, int mouseY) {
		this.mouseX= mouseX;
		this.mouseY= mouseY;
	}
	
	public void setX(int mouseX) {
		this.mouseX= mouseX;
	}
	
	public void setY(int mouseY) {
		this.mouseY= mouseY;
	}
	
	public int getX() {
		return mouseX;
	}
	
	public int getY() {
		return mouseY;
	}
}
