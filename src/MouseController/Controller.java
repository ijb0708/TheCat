package MouseController;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;


public class Controller implements NativeKeyListener, NativeMouseListener, Runnable {
	
	private boolean mouseUse;
	private Mouse mouse;
	
	public Controller() throws AWTException {
		
		mouseUse= false;
		mouse= new Mouse();
		
		new Thread(this).start();
		
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
	public void run() {
	
		final double updateMax =60.0;
		final double oneSecond =1000000000;
		
		long preT =System.nanoTime();
		long nowT;
		
		double delta =0;
		
		while(true) {
			
			nowT = System.nanoTime();
			delta += (nowT - preT) * updateMax;
			preT =nowT;
			
			if(delta>=oneSecond) {
				mouse.update();
				delta-=oneSecond;
			}
		
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			mouse.draw();
		}
	}

	@Override
	public void nativeMouseClicked(NativeMouseEvent arg0) {
		// TODO Auto-gen000erated method stub
		
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
		
		switch(key) {
			case NativeKeyEvent.VC_0:
				if (mouse.isUse == true) {
					mouse.isUse =false;
				}else {
					mouse.isUse =true;
				}			
				break;
			case NativeKeyEvent.VC_UP:
				mouse.isUp=true;
				break;
			case NativeKeyEvent.VC_RIGHT:
				mouse.isRight=true;
				break;
			case NativeKeyEvent.VC_DOWN:
				mouse.isDown=true;
				break;
			case NativeKeyEvent.VC_LEFT:
				mouse.isLeft=true; break;	
				
			case NativeKeyEvent.VC_Z:
				mouse.isLeftPress =true;
				break;
			case NativeKeyEvent.VC_X:
				break;
		}	
	}
	

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		int key = e.getKeyCode();

		switch(key) {
			case NativeKeyEvent.VC_UP:
				mouse.isUp=false;
				break;
			case NativeKeyEvent.VC_RIGHT:
				mouse.isRight=false;
				break;
			case NativeKeyEvent.VC_DOWN:
				mouse.isDown=false;
				break;
			case NativeKeyEvent.VC_LEFT:
				mouse.isLeft=false;
				break;

			case NativeKeyEvent.VC_Z:
				mouse.isLeftPress =false;
				break;
			case NativeKeyEvent.VC_X:
				break;
		}
	}
	
	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
	}
}
