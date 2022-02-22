package aps_220222;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 새콤달콤 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 마이쮸 개수
		int n = 40;

		// 또 인덱스 가지고 놀래 : 일단 100으로 설정
		int[] arr = new int[n + 1]; // 사람의 수 만큼 배열 생성

		int idx = 0;

		// queue 생성
		Queue<Integer> line = new LinkedList<>();

		// 일단 한 명 넣자
		// 1번 사람이
		idx = 1;
		// 1개 가져갈 수 있다고 해놓고,
		arr[idx] += 1;
		line.add(idx);
		// queue에 넣어둔다
		while (true) {
			sc.nextLine();
			// 맨 앞 뽑고
			int nowIdx = line.poll();
			// 사탕 개수 배열에서 인덱스로 받을 사탕 개수를 뺴주고
			n -= arr[nowIdx];
			// 근데 이게 음수가 딱 되는 시점이, 정답!
			if (n <= 0) {
				System.out.println("최종 : " + nowIdx + "번째 손님");
				break;
			}
			// 뒤어 넣어주고
			line.add(nowIdx);
			// 가질 수 있는 마이쮸 개수 1 추가
			arr[nowIdx] += 1;
			// 뒤에 한 명 줄 서 (idx라는 변수를 통해 1씩 증가시켜서 넣는다
			line.add(++idx);
			// 가질 수 있는거 하나
			arr[idx]++;
			System.out.println(n + " " + line.toString());
			System.out.println(Arrays.toString(arr));

		}

	}
}
