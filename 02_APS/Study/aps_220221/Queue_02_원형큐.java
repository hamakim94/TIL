package aps_220221;

public class Queue_02_원형큐 {

	static class Cqueue {
		// 멤버 변수
		int front;
		int rear;
		int[] queue;
		int size;

		// 초기화
		public Cqueue() {
			this.front = 0;
			this.rear = 0;
			this.queue = new int[10];
			this.size = 10;
		}

		// 사이즈를 주면 해당 크기로 배열 생성
		public Cqueue(int size) {
			this.front = 0;
			this.rear = 0;
			this.queue = new int[size];
			this.size = size;
		}

		// 공백 검사
		public boolean isEmpty() {
			return front == rear;
		}

		// full검사
		public boolean isFull() {
			return front == (rear + 1) % size;
		}

		// 삽입
		public boolean enQueue(int item) {
			if (isFull())
				return false;
			rear = (rear + 1) % size;
			queue[rear] = item;
			return true;

		}
		// 삭제

		public int deQueue() {
			if (isEmpty())
				return -1;
			front = (front + 1) % size;
			return queue[front];

		}
		
		public int peek() {
			if(isEmpty()) return -1;
			return queue[(front + 1) % size];
		}
	}

	public static void main(String[] args) {
		Cqueue Q = new Cqueue(4);
		System.out.println(Q.enQueue(1));
		System.out.println(Q.enQueue(2));
		System.out.println(Q.enQueue(3));
//		System.out.println(Q.enQueue(4));
		
//		while(!Q.isEmpty()) {
//			System.out.println(Q.deQueue());
//		}
		
		System.out.println(Q.deQueue());
		System.out.println(Q.deQueue());
		System.out.println(Q.deQueue());
		System.out.println(Q.deQueue());
		
		System.out.println(Q.deQueue());
		Q.deQueue(); //에러 발생 X, full, isEmpty 검사해놔서
		
		
		
	}
}
