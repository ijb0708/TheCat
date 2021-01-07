package MouseController;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.lang.annotation.Native;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;


public class Controller implements NativeKeyListener, NativeMouseListener {
	
	private boolean mouseUse;
	private Mouse mouse;
	
	public Controller() {
		
		mouseUse= false;
		mouse = new Mouse();
		
		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GlobalScreen.addNativeKeyListener(this);
		GlobalScreen.addNativeMouseListener(this);
	}

	@Override
	public void nativeMouseClicked(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nativeMousePressed(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nativeMouseReleased(NativeMouseEvent arg0) {                                                                                                                                                                  
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		
		int key = e.getKeyCode();
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		switch(key) {
			case NativeKeyEvent.VC_UP:
				break;
			case NativeKeyEvent.VC_RIGHT:
				break;
			case NativeKeyEvent.VC_DOWN:
				break;
			case NativeKeyEvent.VC_LEFT:
				break;
			case NativeKeyEvent.VC_C:
				robot.mousePress(InputEvent.BUTTON1_MASK);
				break;
			case NativeKeyEvent.VC_Z:
				robot.mouseRelease(InputEvent.BUTTON1_MASK);
				break;
		}
		
		System.out.println("keyup : " + key);
		
		robot.mouseMove(mouse.getX(), mouse.getY());
		
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
	}
}
