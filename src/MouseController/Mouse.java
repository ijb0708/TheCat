package MouseController;

public class Mouse {
	
	public enum DIR {
		Up, UpRight, Right, DownRight, Down, DownLeft, Left, UpLeft, NONE
	}
	
	//x, y 좌표 및 본코드
	private static final int basicX= 150;
	private static final int basicY= 150;
	
	private boolean isMoving;
	
	private boolean isUp;
	private boolean isDown;
	private boolean isLeft;
	private boolean isRight;
	
	private int mouseX;
	private int mouseY;
	
	private double MaxMoveSpeed;
	private double MoveRowCurrentSpeed;
	private double MoveColumnCurrentSpeed;
	private double MoveSpeed;
	private DIR Direction;
	
	public Mouse() {
		
		mouseX= basicX;
		mouseY= basicY;
		
		Direction = DIR.NONE;
		
		isMoving=false;
		
		isUp= false;
		isDown= false;
		isLeft= false;
		isRight= false;
		
		MoveRowCurrentSpeed= 0;
		MoveSpeed=1.2;
		MaxMoveSpeed= 10.0;
	}
	
	public void update() {
		
		if(Direction!= DIR.NONE) {
			
			if(MaxMoveSpeed>=MoveRowCurrentSpeed) {
				MoveRowCurrentSpeed= MaxMoveSpeed;
			}else {
				MoveRowCurrentSpeed+=MoveSpeed;
			}
			
			switch(Direction) {
				case Up:
					break;
				case UpRight:
					break;
				case Right:
					mouseX+=MoveRowCurrentSpeed;
					break;
				case DownRight:
					break;
				default:
					break;
			}
		}else {
			MoveRowCurrentSpeed=0;
		}
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
