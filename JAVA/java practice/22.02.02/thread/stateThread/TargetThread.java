package thread.stateThread;

public class TargetThread extends Thread{ // 기능
	public void run() {
		for(long i=0; i<1000000000; i++) {		}
		
		try {Thread.sleep(1500);} catch(Exception e ) {};
		
		for (long i=0; i<1000000000; i++) {}
	}

}
