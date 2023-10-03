package BOJ_220218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2628_종이자르기2 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken()); // 가로길이 : 열
		int N = Integer.parseInt(st.nextToken()); // 세로길이 : 행

		int tc = Integer.parseInt(br.readLine());

		ArrayList<Integer> lineCol = new ArrayList<>(); // 열 인덱스 담을 함수(가위)
		ArrayList<Integer> lineRow = new ArrayList<>(); // 행 인덱스 담을 함수(가위)
		// 단순 입력
		for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken()); // 0 : 행, 1 : 열
			int idx = Integer.parseInt(st.nextToken());

			if (now == 0) { // 행 방향이면 행에 idx 넣어
				lineRow.add(idx);

			} else { // 열 방향이면 열배열에 idx 넣어줘
				lineCol.add(idx);

			}

		} // end for : arr에 다 채움
		
		//  인덱스에 0과 N을 더해서, sort해줘서 (i+1) - (i)가 길이가 되도록 해준다
		lineRow.add(0);
		lineRow.add(N);
		lineRow.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1, o2);
			}
		});
		// 인덱스에 0과 M을 더해서, sort해줘서 (j+1) - (j)가 길이가 되도록 해준다
		lineCol.add(0);
		lineCol.add(M);
		lineCol.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1, o2);
			}
		});
//		System.out.println(" 행 " + lineRow.toString());
//		System.out.println(" 열 " + lineCol.toString());
		// 최대값 선정을 위한 변수
		int max = Integer.MIN_VALUE;
		for(int i=0; i<lineRow.size() - 1; i++) {
			for(int j=0; j<lineCol.size() -1; j++) {
				// 각각 나온 길이의 곱들을, 최솟값과 비교하여 따닥!
				int now = (lineRow.get(i+1) - lineRow.get(i))*(lineCol.get(j+1) - lineCol.get(j));
				max = Math.max(now, max);
			}
		}
		System.out.println(max);

	}
}
