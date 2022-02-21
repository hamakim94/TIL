package aps_220221;

public class Queue_01_선형큐 {
	
	// 큐 생성
	
	static int[] Queue = new int [100];
	static int front = -1; // 마지막으로 삭제한 인덱스 
	static int rear = -1;  // 마지막 원소를 가리키는 인덱스
	static int size = 100;
	
	// 공백상태 확인
	
	public static boolean isEmpty() {
//		if (front == rear) {
//			return true;
//		}
//		return false;
		return front == rear;
	}
	// 포화상태 확인
	public static boolean isFull() {
		return rear == size - 1;
	}
	// 삽입연산
	public static void enQueue(int item) {
		// 포화 검사
		if (isFull()) {
			//가득찬걸 알려줘
			return;
		} 
		Queue[++rear] = item;
		// 포화 아니라면 넣어
	}
	
	// 하나뽑기
	public static int deQueue(int item) {
		// 포화 검사
		if (isEmpty()) {
			//가득찬걸 알려줘
			return -1;
		} 
		Queue[++rear] = item;
		return Queue[rear - 1];
		// 포화 아니라면 넣어
	}
	
	
	public static void main(String[] args) {
		
		
	}
}
