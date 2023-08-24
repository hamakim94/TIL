package aps_220223;

// 데이터를 저장하고, 다음 링크를 가지고 있어야 합니다.
public class Node {
	// 데이터를 저장
	public String data;
	
	// 링크를 저장
	public Node link; // 다음 노드의 주소를 저장함
	                  // 노드를 가리키려고 설정한 멤버변수같은겅
	
	public Node() {
	}

	public Node(String data) {
		super();
		this.data = data;
		this.link = null; // 필요없음, 짜피 참조형
	}
	
}
