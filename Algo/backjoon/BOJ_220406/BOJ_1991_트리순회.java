package BOJ_220406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class BOJ_1991_트리순회 {

	// 한 번 노드 만들어서 해보자

	static class Node {

		String now;
		Node left;
		Node right;

		public Node(String now, Node left, Node right) {
			super();
			this.now = now;
			this.left = left;
			this.right = right;
		}

		public Node() {
		}

		public Node(String now) {
			this.now = now;
		}

		public void setNow(String now) {
			this.now = now;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		@Override
		public String toString() {
			return "Node [now=" + now + ", left=" + left + ", right=" + right + "]";
		}

	}

	static HashMap<String, Node> nodes = new HashMap<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 중복 생성을 막기 위한 HashSet

		for (int i = 0; i < N; i++) {
			String[] now = br.readLine().split(" ");

			Node k;
			// 가장 첫 입력값이 key로 주어져있지 않으면.
			if (!nodes.containsKey(now[0])) {
				// 새로 노드를 만들어서 그 값을 정해주고
				k = new Node(now[0]);
				// nodes map에 넣어준다.
				nodes.put(now[0], k);
			} else {
				// 아닌 경우 k에 그냥 해당 노드 가져오기.(관계설정을 위함)
				k = nodes.get(now[0]);
			}
			//
			if (!now[1].equals(".")) {
				// B, 두번째 입력값이 없다면!
				if (!nodes.containsKey(now[1])) {
					// 새로 노드를 만들어서 그 값을 정해주고
					Node left = new Node(now[1]);
					// nodes map에 넣어준다.
					nodes.put(now[1], left);
					// 그리고 관계 설정
					k.left = left;
				}
			}
			if (!now[2].equals(".")) {
				if (!nodes.containsKey(now[2])) {
					Node right = new Node(now[2]);
					right.setNow(now[2]);
					nodes.put(now[2], right);
					k.right = right;
				}
			}
		} // end for : 입력 완료
		VLR(nodes.get("A"));
		sb.append("\n");
		LVR(nodes.get("A"));
		sb.append("\n");
		LRV(nodes.get("A"));
		System.out.println(sb);
	}// end main
		// 이제 순회해야하는데
		// 전위 : VLR

	public static void VLR(Node node) {
		// 처리, 전위
		sb.append(node.now);
		if (node.left != null) // null이면 더 돌지 말라는 뜻!
			VLR(node.left);
		if (node.right != null)
			VLR(node.right);
	}

	// 중위 : LVR
	public static void LVR(Node node) {

		if (node.left != null)
			LVR(node.left);
		sb.append(node.now);
		if (node.right != null)
			LVR(node.right);
	}

	// 후위 : LRV
	public static void LRV(Node node) {

		if (node.left != null)
			LRV(node.left);

		if (node.right != null)
			LRV(node.right);
		sb.append(node.now);
	}

}
