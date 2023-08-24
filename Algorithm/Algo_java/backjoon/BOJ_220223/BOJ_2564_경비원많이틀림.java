package BOJ_220223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2564_경비원많이틀림 {
	public static void main(String[] args) throws IOException {
		// 입력부터 좌표로 잘 받자..

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		// 좌표를 넣을 배열
		Queue<int[]> que = new LinkedList<int[]>();
		for (int i = 0; i < N; i++) {
			int[] arr = new int[2];
			st = new StringTokenizer(br.readLine());
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			que.add(arr);
		}

		int[] now = new int[2];
		st = new StringTokenizer(br.readLine());
		now[0] = Integer.parseInt(st.nextToken());
		now[1] = Integer.parseInt(st.nextToken());

		// 전체를 더할 길이
		int total = 0;
		int[] currentLoca = makeXandY(now[0], now[1], width, height);

		while (!que.isEmpty()) {
			int[] pop = que.poll();
			int[] loca = makeXandY(pop[0], pop[1], width, height);

			if (now[0] == 1) {
				// 남쪽인 경우 : x좌표는 입력값이고, y좌표는 0이다
				// 마주보면
				if (pop[0] == 2) {
					// (가로 - x0좌표) + 세로 + (가로- x1좌표) 와 (x0좌표 + 세로 + x1좌표) 중 최소
					total += Math.min( (loca[0] + currentLoca[0] + height),
							(width - loca[0] + width - currentLoca[0] + height));

				} else { // x좌표 차이 절댓값 + y좌표 차이 절댓값이 최단거리
					total += (Math.abs(loca[0] - currentLoca[0]) + Math.abs(loca[1] - currentLoca[1]));

				}
			} else if (now[0] == 2) {
				// 북쪽인 경우
				// 마주보면
				if (pop[0] == 1) {
					// (가로 - x0좌표) + 세로 + (가로- x1좌표) 와 (x0좌표 + 세로 + x1좌표) 중 최소
					total += Math.min((loca[0] + currentLoca[0] + height),
							(width - loca[0] + width - currentLoca[0] + height));

				} else { // x좌표 차이 절댓값 + y좌표 차이 절댓값이 최단거리
					total += (Math.abs(loca[0] - currentLoca[0]) + Math.abs(loca[1] - currentLoca[1]));

				}
			} else if (now[0] == 3) {
				// 서쪽인 경우
				// 마주보면
				if (pop[0] == 4) {
					// (세로 - y0좌표) + 가로 + (세로- y1좌표) 와 (y0좌표 + 세로 + y1좌표) 중 최소
					total += Math.min((loca[1] + currentLoca[1] + width),
							(height - loca[1] + height - currentLoca[1] + width));

				} else { // x좌표 차이 절댓값 + y좌표 차이 절댓값이 최단거리
					total += ( Math.abs(loca[0] - currentLoca[0]) + Math.abs(loca[1] + currentLoca[1]) );

				}
			} else {
				// 동쪽인 경우
				// 마주보면
				if (pop[0] == 3) {
					// (세로 - y0좌표) + 가로 + (세로- y1좌표) 와 (y0좌표 + 세로 + y1좌표) 중 최소
					total += Math.min((loca[1] + currentLoca[1] + width),
							(height - loca[1] + height - currentLoca[1] + width));

				} else { // x좌표 차이 절댓값 + y좌표 차이 절댓값이 최단거리
					total += (Math.abs(loca[0] - currentLoca[0]) + Math.abs(loca[1] + currentLoca[1]));

				}
			} // end if else
		}
		if (total != 0) {
			System.out.println(total);
		} else {
			System.out.println(0);
		}
		br.close();
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
