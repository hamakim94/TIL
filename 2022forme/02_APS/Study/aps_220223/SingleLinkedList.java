package aps_220223;

public class SingleLinkedList {

	private Node head; // 노드의 시작점
	private int size; // 메서드가 아니라 멤버 변수를 저장

	// 특정 위치(idx번째)의 노드를 반환하는 메서드
	public Node search(int idx) {
		// 이러한 상황에서는 예외를 발생시켜 알려주거나. .기타 등등의 작업을 해야함
		if (idx < 0 || idx >= size)
			return null;

		Node curr = head;

		for (int i = 0; i < idx; i++) {
			curr = curr.link;
		}
		return curr;
	}

	// 연결리스트 첫 번째 원소로 노드를 삽입
	public void addFirst(String data) {
		Node newNode = new Node(data);
		// 새로만든 노드의 링크를 head로 변경
		newNode.link = head;
		// head가 가리키는 노드를 새 노드로 변경
		head = newNode;
		size++;

	}

	public void addLast(String data) {

		Node newNode = new Node(data);

		if (size == 0) {
			addFirst(data);
			return;
		}
		// 마지막 찾기

		Node curr = head;
		while (curr.link != null) {
			curr = curr.link;
		}
		curr.link = newNode;
		size++;
	}

	public void add(int idx, String data) {
		// 관대하게 범위 설정 : 인덱스 에러 나도 추가할 수 있도록

		if (idx <= 0) {
			addFirst(data);
		}

		if (idx >= size) {
			addLast(data);
			return;
		}

		// 이전 노드
		Node pre = search(idx - 1);

		Node newNode = new Node(data);
		newNode.link = pre.link;
		pre.link = newNode;
		size++;

	}

	public void printList() {
		Node curr = head;
		if (head == null) {
			System.out.println("공백임");
			return;
		}
		while (curr != null) {
			System.out.print(curr.data + "--> ");
			curr = curr.link;

		}
		System.out.println();
	}

	// 첫 번쨰 원소 삭제
	public String remove() {
		if (head == null) {
			return "삭제 X";
		}
		String data = head.data;
		head = head.link;
		size--;

		return data;
	}
	// 연결리스트 특정 위치 노드 삭제S
	public String remove(int idx) {
		if (idx<1 || idx >= size) {
			return "없엉";
		}
		Node newNode = search(idx);
		String data = newNode.data;
		Node prevNode = search(idx-1);
		prevNode.link = newNode.link;
		size--;
		return data;
	}
}
