package aps_220224;

import java.util.Scanner;

public class SWEA_1873_상호의배틀필드 {
	public static void main(String[] args) {
		// 입력부터 받아서 확인 지도 확인해보자

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			int H = sc.nextInt(); // 높이
			int W = sc.nextInt(); // 너비

			// 현재 위치를 받을거
			int nowRow = 0;
			int nowCol = 0;
			String nowStatus = "";

			String[][] map = new String[H][W];
			for (int height = 0; height < H; height++) {
				String now = sc.next();
				for (int j = 0; j < now.length(); j++) {
					char nowChar = now.charAt(j);
					if (nowChar == '<' || nowChar == '^' || nowChar == 'v' || nowChar == '>') {
						nowRow = height;
						nowCol = j;
						nowStatus = now.charAt(j) + "";
					}
					map[height][j] = now.charAt(j) + "";
				}
				// System.out.println(Arrays.toString(map[height]));
			} // 입력 완료

			// 명령어들 for문 돌 배열 만들기
			int num = sc.nextInt();
			String[] command = new String[num];
			command = sc.next().split("");

			for (int i = 0; i < command.length; i++) {

//			U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
				if (command[i].equals("U")) {
					nowStatus = "^"; // 위를 바라보게 하고
					int nextRow = nowRow - 1; // 올라갈 곳
					if (nextRow >= 0 && map[nextRow][nowCol].equals(".")) { // 올라갈 곳의 좌표가 0보단 크고, .이라면

						map[nowRow][nowCol] = "."; // 현재 위치 바꿔
						nowRow = nextRow; // 현재 행을 한칸 위로
					} // 아니면 그냥 방향만 바뀜
					map[nowRow][nowCol] = nowStatus;

//			D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
				} else if (command[i].equals("D")) {
					nowStatus = "v"; // 위를 바라보게 하고
					int nextRow = nowRow + 1; // 내려갈 곳
					if (nextRow < H && map[nextRow][nowCol].equals(".")) { // 올라갈 곳의 좌표가 0보단 크고, .이라면

						map[nowRow][nowCol] = "."; // 현재 위치 바꿔
						nowRow = nextRow; // 현재 행을 한칸 위로
					} // 아니면 그냥 방향만 바뀜
					map[nowRow][nowCol] = nowStatus;

//			L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
				} else if (command[i].equals("L")) {
					nowStatus = "<"; // 위를 바라보게 하고
					int nextCol = nowCol - 1; // 왼쪽으로 갈 곳
					if (nextCol >= 0 && map[nowRow][nextCol].equals(".")) { // 올라갈 곳의 좌표가 0보단 크고, .이라면

						map[nowRow][nowCol] = "."; // 현재 위치 바꿔
						nowCol = nextCol; // 현재 행을 한칸 위로
					} // 아니면 그냥 방향만 바뀜
					map[nowRow][nowCol] = nowStatus;

//			R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
				} else if (command[i].equals("R")) {
					nowStatus = ">"; // 위를 바라보게 하고
					int nextCol = nowCol + 1; // 오른쪽으로 갈 곳
					if (nextCol < W && map[nowRow][nextCol].equals(".")) { // 오른쪽으로 갈 곳 좌표가 W보단 작고, .이라면

						map[nowRow][nowCol] = "."; // 현재 위치 바꿔
						nowCol = nextCol; // 현재 행을 한칸 아래로

					} // 아니면 그냥 방향만 바뀜
					map[nowRow][nowCol] = nowStatus;

//			S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
				} else {
					switch (nowStatus) {
					case ("<"):
						int temp = 1;
						while (nowCol - temp >= 0) {
							// 물 만나거나 그냥 평지면
							if (map[nowRow][nowCol - temp].equals(".") || map[nowRow][nowCol - temp].equals("-")) {
								// 다음 열 탐색을 위해..
								temp++;
								// 일반벽 : 해당 벽의 위치를 .으로 바꾸고 끝
							} else if (map[nowRow][nowCol - temp].equals("*")) {
								map[nowRow][nowCol - temp] = ".";
								break;
								// 강철벽 : 그냥 나와
							} else {
								break;
							}
						} // end while: 끝
						break;
					case (">"):
						temp = 1;
						while (nowCol + temp < W) {
							// 물 만나거나 그냥 평지면
							if (map[nowRow][nowCol + temp].equals(".") || map[nowRow][nowCol + temp].equals("-")) {
								// 다음 열 탐색을 위해..
								temp++;
								// 일반벽 : 해당 벽의 위치를 .으로 바꾸고 끝
							} else if (map[nowRow][nowCol + temp].equals("*")) {
								map[nowRow][nowCol + temp] = ".";
								break;
								// 강철벽 : 그냥 나와
							} else {
								break;
							}
						} // end while: 끝
						break;
					case ("v"):
						temp = 1;
						while (nowRow + temp < H) {
							// 물 만나거나 그냥 평지면
							if (map[nowRow + temp][nowCol].equals(".") || map[nowRow + temp][nowCol].equals("-")) {
								// 다음 행 탐색을 위해..
								temp++;
								// 일반벽 : 해당 벽의 위치를 .으로 바꾸고 끝
							} else if (map[nowRow + temp][nowCol].equals("*")) {
								map[nowRow + temp][nowCol] = ".";
								break;
								// 강철벽 : 그냥 나와
							} else {
								break;
							}
						} // end while: 끝
						break;
					case ("^"):
						temp = 1;
						while (nowRow - temp >= 0) {
							// 물 만나거나 그냥 평지면
							if (map[nowRow - temp][nowCol].equals(".") || map[nowRow - temp][nowCol].equals("-")) {
								// 다음 행 탐색을 위해..
								temp++;
								// 일반벽 : 해당 벽의 위치를 .으로 바꾸고 끝
							} else if (map[nowRow - temp][nowCol].equals("*")) {
								map[nowRow - temp][nowCol] = ".";
								break;
								// 강철벽 : 그냥 나와
							} else {
								break;
							}
						} // end while: 끝
						break;
					} // end switch " S일 때
				} // end :if -elseif-elseif-elsif-else : 명령문 하나 좌표값 변경 완료
			} // end for : 명령문 개수만큼 완료
			System.out.print("#" + tc + " ");
			for (int i = 0; i < map.length; i++) {
				for(int j=0; j<W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
				
			}
		} // end for : testCase 완료

	}
}
