package BOJ_220306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;

public class BOJ_1316_그룹단어체커 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 개수
		int N = Integer.parseInt(br.readLine());
		// 그룹 단어 체크를 셀 변수
		int nums = 0;
		//
		for (int t = 0; t < N; t++) {
			// stack에 문장을 돌면서, 
			Stack<Character> stack = new Stack<>();
			char[] now = br.readLine().toCharArray();
			HashSet<Character> set = new HashSet<>();
			
			int cnt = 0;
			// for문 돌면서 stack에 , set에 따로 넣어줘서 넣어주기
			// 문자가 변할 떄 마다 cnt를 + 해준다
			// 만약 a b a 로 변하면, cnt는 a 넣을 떄, b 넣을 떄, a 넣을 때 총 3번
			// set은 2개,(a,b) 
			// 따라서 이 2개를 비교해서 같으면 그룹이고, 다르면 그룹이 아니다
			// 크기를 비교하자
			for (int i = 0; i < now.length; i++) {
				//집합엔 넣어주기(
				set.add(now[i]);
				// 스택이 비어있으면, cnt++ 해주고 stack에 더해주고
				if(stack.isEmpty()) {
					cnt++;
					stack.add(now[i]);
				} // 비어있지 않으면, peek와 비교해서 다르면 cnt++
				else if( stack.peek() != now[i]) {
					cnt++;
					stack.add(now[i]);
				}
				
				
			} // end for : stack을 돌면서 비교 완료
			if(set.size() == cnt) {
				nums++;
			}
			

		} // end for : 문장 수 검사 완료
		System.out.println(nums);

	}
}
