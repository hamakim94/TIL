package thread;

import java.awt.Toolkit;

public class BeepThread extends Thread {

	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			System.out.println("다른곳띵");
			try {
				Thread.sleep(500);
			} catch (Exception E) {
			}
		}
	}
}
