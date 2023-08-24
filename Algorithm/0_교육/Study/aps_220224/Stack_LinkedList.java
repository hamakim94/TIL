package aps_220224;

public class Stack_LinkedList {

	// top 변수 : 리스트이 마지막 노드를 가리키는 변수
	private NodeStack top;

	public Stack_LinkedList() {
		this.top = null;
	}
	// 메소드 : push : 그냥 넣어주기

	public void push(String data) {
		// 연결은 해야함
		NodeStack newNode = new NodeStack(data);
		newNode.link = top;
		top = newNode;

	}

	public String pop() {
		if (top == null) {
			return "비어있음";
		}
		String data = top.data;
		top = top.link;
		return data;
	}
	// pop : 마지막거 빼기

	public void printInverse() {
		while (top != null) {
			System.out.print(top.data + "<-- ");
			top = top.link;
		}
		System.out.println();
	}

}
