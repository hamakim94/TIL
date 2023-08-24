package aps_220216;

import java.util.Scanner;
import java.util.Stack;

public class Stack_05_실행취소 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Stack<String> ctrlZ = new Stack<>();
		Stack<String> ctrlY = new Stack<>();

		String work = "작업1";

		while (true) {
			System.out.println("1. 새로운 작업");
			System.out.println("2. Ctrl + Z");
			System.out.println("3. Ctrl + Y");
			System.out.println("0. 종료(아무 숫자 입력해도 종료됨)");
			// 내가 선택한 메뉴
			int N = sc.nextInt();
			if (N == 1) { // 새로운 작업을 입력한다

				// 작업 순서는?
				// 1. 현재 작업을 Z스택에 저장한다.
				// 2. 새로운 작업을 입력받는다.
				// 3. Y스택을 비운다
				// 3-1. while문을 이용해서 지운다 요소가 공복상태가 될 때 까지 뽑느다.
				// 3-2. new라는 키워드를 이용해서 새로운 인스턴스를 생성한다.
				// 3-3. clear라는 메서드를 활용한다.
				// 4. 입력받은 작업을 출력(선택사항)

				ctrlZ.push(work);
				work = sc.next();
				ctrlY.clear();
				System.out.println(work);

			} else if (N == 2) { // 실행을 취소한다(뒤로)
				if (ctrlZ.isEmpty()) {
					System.out.println("Z스택이 공백상태");
				} else {
					// 1. 현재 작업을 Y에 넣는다
					// 2. Z에서 작업을 꺼내어 넣는다.
					ctrlY.push(work);
					// 팝 확인이 필요
					work = ctrlZ.pop();
					System.out.println(work);
				}

			} else if (N == 3) { // 실행 취소를 취소한다(앞으로)
				if (ctrlY.isEmpty()) {
					System.out.println("지금이 최신 작업이라 꺼낼게 없음");
				} else {
					// 1. 현재 작업을 Z스택에 넣기(z에 넣기)
					// 2. Y에서 작업을 꺼내어 현재에 넣는다(덮어쓴다)
					// 3. 현재 작업을 출력(선택)
					ctrlZ.push(work);
					work = ctrlY.pop();
					System.out.println(work);
				}

			} else { // 그 외 입력 : 종료
				System.out.println("종료");
				break;
			}

		}
	}
}
