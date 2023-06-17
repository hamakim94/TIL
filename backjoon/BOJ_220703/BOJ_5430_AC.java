package BOJ_220703;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_5430_AC {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			Deque<Integer> deque = new LinkedList<>();
			char[] command = br.readLine().toCharArray();
			int size = Integer.parseInt(br.readLine());
			String strArr = br.readLine();
			String[] input = strArr.substring(1, strArr.length() - 1).split(",");
			for (String s : input) {
				if (!s.equals("")) {
					deque.add(Integer.valueOf(s));
				}
			}
			System.out.println(AC(command, deque));

		}
	}

	private static String AC(char[] command, Deque<Integer> deque) {
		
		StringBuilder sb = new StringBuilder();
		boolean reverse = false;
		for(char com : command) {
			if(com == 'R') {
				reverse = !reverse;
			} else {
				if(!reverse) {
					deque.pollFirst();
				} else {
					deque.pollLast();
				}
			}
		}
		if(deque.size() == 0) {
			return "error";
		}
		sb.append('[');
		while(!deque.isEmpty()) {
			if(!reverse) {
				if(deque.size() == 1) {
					sb.append(deque.pollFirst());
				} else {
					sb.append(deque.pollFirst()).append(',');
				}
			} else {
				if(deque.size() == 1) {
					sb.append(deque.pollLast());
					break;
				} else {
					sb.append(deque.pollLast()).append(',');
				}
			}
		}
		sb.append(']');
		return sb.toString();
	}
}
