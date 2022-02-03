package thread;



public class ThreadPrac {
	// 쓰레드 선언 : Threads 상속

	public static void main(String[] args) {
		Thread thread = new BeepThread();
		thread.start();
		
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (Exception e){
				
			}
		}
		
	}
}

