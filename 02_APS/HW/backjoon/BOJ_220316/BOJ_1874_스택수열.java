package BOJ_220316;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_1874_스택수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int [N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 스택을 두개 쓸거
		// 거꾸로 넣을 스택
		Stack<Integer> temp = new Stack<>();
		for(int i=N; i>=1; i--) {
			temp.add(i);
		}
		// 정답을 만들기 위해 넣는 스택
		Stack<Integer> stack = new Stack<>();
		// arr인덱스를 가지고 놀기 위한 변수
		
		//일단 1 넣고 시작

		int idx = 0;
		boolean flag = true;
		StringBuilder sb = new StringBuilder();
		while(idx < N) {
			
			// 스택이 비어있으면,넣어준다
			if (stack.isEmpty()) {
				stack.add(temp.pop());
				sb.append("+").append("\n");
				continue;
			}
			// 문제에서 입력된 수열의 idx번째 값
			int now = arr[idx];
			
			// 현재 로직은, stack에 peek값이 arr[idx]랑 다르면 무조건 추가
			// 정상적으로 들어갔으면, 최대값 만났을 때 
			// 하나씩 빼면서, arr[idx]랑 now랑 값이 같은 경우에 계속 pop해서 while문 종료
			// 비정상적으로 들어가면, stack.peek에서 값이 다를 때, temp에 있는거 추가해야하는데
			// temp가 비어있다면 문제가 발생 -> 뽑을 수 없는 경우를 말하는듯
			
			
			// 정답을 만들기 위해 넣는 스택의 가장 나중에 넣은 값이 문제에서 입력된 수열과 다르다면
			if(stack.peek() != now) {
				// 다르면 추가해야 하는데, temp가 비어있으면 뭔가 오류가 생겼다는 뜻?
				if(temp.isEmpty()) {
					flag = false;
					break;
				}
				stack.add(temp.pop());
				sb.append("+").append("\n");
				System.out.println("-------------------------");
				System.out.println("idx = " + idx + " arr[idx] = " + arr[idx]);
				System.out.println(stack.toString());
				System.out.println(temp.toString());
			// 현재 넣어야할 수와 정답을 뽑기 위해만든 stack의 peek이 같다면! 
			} else {
				System.out.println("-------------------------");
				System.out.println("idx = " + idx + " arr[idx] = " +now );
				// 아닌 경우엔
				// 다음 수로 넘어가고
				idx++;
				// 스택에서 하나 빼준다
				stack.pop();
				sb.append("-").append("\n");
				
				System.out.println(stack.toString());
				System.out.println(temp.toString());
			}
			
		} // end while
		if(flag) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}
	}
}
	