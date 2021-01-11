package MouseController;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.jnativehook.keyboard.NativeKeyEvent;

public class Mouse {
	
	public enum DIR {
		Up, UpRight, Right, DownRight, Down, DownLeft, Left, UpLeft, NONE
	}
	
	//키보드 움직이는 클래스
	private Robot robot;
	
	//x, y 좌표 및 본코드
	private static final int basicX= 150;
	private static final int basicY= 150;
	
	//최대속도변수
	private static double MaxColumnMoveSpeed;
	private static double MaxRowMoveSpeed;
	
	//해당하는 방향으로 키가 눌려졌는지 여부
	public boolean isUp;
	public boolean isDown;
	public boolean isLeft;
	public boolean isRight;
	
	public boolean isLeftPress;
	public boolean isLeftRelease;
	
	public boolean isRightPress;
	public boolean isRightRelease;
	
	public boolean isLeftPressOnce;
	public boolean isRightPressOnce;
	
	public boolean isUse;
	
	//마우스의 좌표
	private int mouseX;
	private int mouseY;
	
	//움직이는 속도 관련 변수
	private double MoveRowCurrentSpeed;
	private double MoveColumnCurrentSpeed;
	
	private double MoveRowSpeed;
	private double MoveColumnSpeed;
	
	private DIR Direction;

	public Mouse() {
		
		mouseX =basicX;
		mouseY =basicY;
		
		Direction =DIR.NONE;
		
		isUp =false;
		isDown =false;
		isLeft =false;
		isRight =false;
		
		isLeftPressOnce =false;
		isRightPressOnce =false;
		
		isLeftPress =false;
		isLeftRelease =false;
		
		isRightPress =false;
		isRightRelease =false;;
		
		isUse =false;
		
		MoveRowCurrentSpeed =0;
		MoveColumnCurrentSpeed =0;
		
		MoveRowSpeed=0.55;
		MoveColumnSpeed=0.45;
		
		MaxRowMoveSpeed =12.0;
		MaxColumnMoveSpeed =10.0;
		
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		if(isUse) {
			movement();
			clickButton();	
		}
		
		mouseX +=MoveRowCurrentSpeed;
		mouseY +=MoveColumnCurrentSpeed;
	}
	
	public void draw() {
		if(isUse) {
			robot.mouseMove(mouseX, mouseY);
		}
	}
	
	
	public void setXY(int mouseX, int mouseY) {
		this.mouseX= mouseX;
		this.mouseY= mouseY;
	}
	
	private void clickButton() {
		if(isLeftPress && !isLeftPressOnce) {
			robot.mousePress(InputEvent.BUTTON1_MASK);
			isLeftPressOnce =true;
		}else if(!isLeftPress && isLeftPressOnce) {
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			isLeftPressOnce =false;
		}
	}

	private void movement() {
		
		if(isUp && isRight && !isDown && !isLeft) {
			MoveColumnCurrentSpeed -=MoveColumnSpeed;
			MoveRowCurrentSpeed +=MoveRowSpeed;
		}else if(!isUp && isRight && isDown && !isLeft){
			MoveRowCurrentSpeed +=MoveRowSpeed;
			MoveColumnCurrentSpeed +=MoveColumnSpeed;
		}else if(!isUp && !isRight && isDown && isLeft) {
			MoveColumnCurrentSpeed +=MoveColumnSpeed;
			MoveRowCurrentSpeed -=MoveRowSpeed;	
		}else if(isUp && !isRight && !isDown && isLeft) {
			MoveRowCurrentSpeed -=MoveRowSpeed;
			MoveColumnCurrentSpeed -=MoveColumnSpeed;
		}else if(isUp && !isRight && !isDown && !isLeft) {
			MoveColumnCurrentSpeed -=MoveColumnSpeed;
			MoveRowCurrentSpeed =0;
		}else if(!isUp && isRight && !isDown && !isLeft) {
			MoveRowCurrentSpeed +=MoveRowSpeed;
			MoveColumnCurrentSpeed =0;
		}else if(!isUp && !isRight && isDown && !isLeft) {
			MoveColumnCurrentSpeed +=MoveColumnSpeed;
			MoveRowCurrentSpeed =0;
		}else if(!isUp && !isRight && !isDown && isLeft) {
			MoveRowCurrentSpeed -=MoveRowSpeed;
			MoveColumnCurrentSpeed =0;
		}else {
			MoveColumnCurrentSpeed =0;
			MoveRowCurrentSpeed =0;
		}
		
		if (MoveColumnCurrentSpeed > MaxColumnMoveSpeed) {
			MoveColumnCurrentSpeed =MaxColumnMoveSpeed;
		}else if(MoveColumnCurrentSpeed < -MaxColumnMoveSpeed) {
			MoveColumnCurrentSpeed =-MaxColumnMoveSpeed;
		}
		
		if (MoveRowCurrentSpeed > MaxRowMoveSpeed) {
			MoveRowCurrentSpeed =MaxRowMoveSpeed;
		}else if(MoveRowCurrentSpeed < -MaxRowMoveSpeed) {
			MoveRowCurrentSpeed =-MaxRowMoveSpeed;
		}
		
	}
}
