package BOJ_220223;

import java.util.Scanner;

public class BOJ_2564_경비원 {
	public static void main(String[] args) {
		// 입력부터 좌표로 잘 받자..
		Scanner sc = new Scanner(System.in);
		int width = sc.nextInt();
		int height = sc.nextInt();

		int N = sc.nextInt();
		// x, y 좌표를 담을 배열
		int[][] locations = new int[N][2];
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			locations[i] = makeXandY(x, y, width, height);

		} // end for : 좌표 입력 완료
//		for(int[] arr : locations) {
//			System.out.println(Arrays.toString(arr));
//		}

		// 현재 위치를 좌표료 변환한 값 : now
		int[] now;
		int x = sc.nextInt();
		int y = sc.nextInt();
		now = makeXandY(x, y, width, height);
		// 값을 더해줄 함수
		int total = 0; //

		// now[0]의 값에 따라서,
		for (int i = 0; i < N; i++) {
			int[] toCal = locations[i];
			// 1.북쪽인 경우 - 높이가 height 인 경우

			if (now[1] == height) {
				// 남쪽을 만나면 계산 빡세/나머진 그냥 좌표차이 절댓값 더하기
				if (toCal[1] == 0) {
					total += Math.min((now[0] + toCal[0] + height), (width - now[0] + width - toCal[0] + height));
				} else {
					total += (Math.abs(now[0] - toCal[0]) + Math.abs(now[1] - toCal[1]));
				}
				// 2.남쪽인 경우 - 북쪽을 만나면 계산 빡세/나머진 그냥 좌표차이 절댓값 더하기
			} else if (now[1] == 0) {
				if (toCal[1] == height) {
					total += Math.min((now[0] + toCal[0] + height), (width - now[0] + width - toCal[0] + height));
				} else {
					total += (Math.abs(now[0] - toCal[0]) + Math.abs(now[1] - toCal[1]));
				}
				// 3.서쪽인 경우 - 동쪽을 만나면 계산 빡세/나머진 그냥 좌표차이 절댓값 더하기
			} else if (now[0] == 0) {
				if (toCal[0] == width) {
					total += Math.min((now[1] + toCal[1] + width), (height - now[1] + height - toCal[1] + width));
				} else {
					total += (Math.abs(now[0] - toCal[0]) + Math.abs(now[1] - toCal[1]));
				}
				// 4.동쪽인 경우 - 서쪽을 만나면 계산 빡세/나머진 그냥 좌표차이 절댓값 더하기
			} else if (now[0] == width) {
				if (toCal[0] == 0) {
					total += Math.min((now[1] + toCal[1] + width), (height - now[1] + height - toCal[1] + width));
				} else {
					total += (Math.abs(now[0] - toCal[0]) + Math.abs(now[1] - toCal[1]));
				}
			}

		} // end for : total 계산 완료
		System.out.println(total);
		sc.close();

	}

	// 좌표 변환
	public static int[] makeXandY(int input0, int input1, int width, int height) {
		int x;
		int y;
		int[] location = new int[2];
		switch (input0) {
		case 1: // 북쪽
			x = input1;
			y = height;
			location[0] = x;
			location[1] = y;
			break;
		case 2: // 남쪽
			x = input1;
			y = 0;
			location[0] = x;
			location[1] = y;
			break;

		case 3:// 서쪽
			x = 0;
			y = height - input1;
			location[0] = x;
			location[1] = y;
			break;
		case 4:// 동쪽
			x = width;
			y = height - input1;
			location[0] = x;
			location[1] = y;
			break;
		}
		return location;

	}
}
