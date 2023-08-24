package aps_220227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA_1220_Magnatic {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = 10;
		for (int tc = 1; tc <= testCase; tc++) {

			int cnt = 0; // 총 합을 구할 변수

			int size = Integer.parseInt(br.readLine());
			String[][] arr = new String[size][size];
			for (int i = 0; i < size; i++) {
				arr[i] = br.readLine().split(" ");
			}
			ArrayList<String> line;
			// 한 열씩 볼거야
			for (int i = 0; i < size; i++) {
				line = new ArrayList<>();

				for (int j = 0; j < size; j++) {
					// 1과 2일 때만 넣을거야
					if (arr[j][i].equals("1") || arr[j][i].equals("2")) {
						line.add(arr[j][i]);
					}

				} // 한 열 입력 완료(세로방향)
					// 위 쪽이 N극이므로, S극을 만나면 내려가게 된다
				for (int idx = 0; idx < line.size()-1; idx++) {
					if (line.get(idx).equals("1") && line.get(idx + 1).equals("2")) {
						cnt++;
					}
				} // end for : count 끝
				

			} // end for  : cnt 완료
			System.out.println("#" + tc + " " + cnt);
		} // end testCase

	}
}
