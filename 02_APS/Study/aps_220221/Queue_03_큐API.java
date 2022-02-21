package aps_220221;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_03_큐API {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		
		// 삽입
		queue.add(10);
		queue.offer(20);
		
		// 삭제
		System.out.println(queue.remove());
		System.out.println(queue.poll());
		// 그개 넣었으니 실행 가능
		// System.out.println(queue.remove()); // 예외 발생
		// System.out.println(queue.poll()); // null
		
		
//		// 조회
		System.out.println(queue.element()); // 예외 발생
		System.out.println(queue.peek()); // 그냥 null
		
		// add, remove, element : 예외를 발생시킨다
		// offer, poll, peek : 값을 리턴한다.

	}
}
