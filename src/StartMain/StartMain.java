package StartMain;

import java.awt.AWTException;

import MouseController.Controller;

public class StartMain {

	public static void main(String[] args) {
		
			
			try {
				new Controller();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}