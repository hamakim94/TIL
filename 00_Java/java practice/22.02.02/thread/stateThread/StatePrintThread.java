package thread.stateThread;

public class StatePrintThread extends Thread{
	private Thread targetThread;
	
	public StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	}
	
	public void run() {
		while(true) {
			Thread.State state = targetThread.getState();
			System.out.println("타겟 스레드 상태" + state);
			
			if (state == Thread.State.NEW) {// 스레드 객체 생성 상태, start X -> 실행 대기 상태로!
				targetThread.start(); 
			}
			
			if (state == Thread.State.TERMINATED) {
				break; // 종료  => while문 종료
			}
			try {
				// 0.5초 정지
				Thread.sleep(500);
			}catch (Exception e) {}
		}
		
	}
}
