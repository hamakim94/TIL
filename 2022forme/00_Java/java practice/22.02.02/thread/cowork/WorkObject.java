package thread.cowork;

public class WorkObject {
	public synchronized void methodA() {
		System.out.println("ThreadA의 methodA() 작업 실행");
		notify();// 일시 정지 상태에 있는ThreadB를 실행 대기 상태로 만듦
		try {
			wait(); // ThreadA를 일시 정지 상태로 만든다.
		} catch (InterruptedException e) {
		}

	}

	public synchronized void methodB() {
		System.out.println("ThreadB의 methodB() 작업 실행");
		notify(); // 일시 정지 상태에 있는 ThreadA를 실행 대기 상태로 만듦
		try {
			wait(); // ThreadB 일시정지
		} catch (InterruptedException e) {
		}

	}

}
