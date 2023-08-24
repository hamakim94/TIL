package aps_220224;

public class SingleLinkedList_me {

	private Node head;
	private int size;
	
	
	public SingleLinkedList_me() {
		this.head = null;
		this.size = 0;
	}

	// 메서드
	public void addFirst(String data) {
		Node freshNode = new Node(data);
		freshNode.link = head;
		head = freshNode;
		size++;

	}

	// search

	public Node search(int idx) {
		if (idx < 0 || idx >= size) {
			return null;
		}
		// 0일떈 head만 반환
		Node curr = head;
		// 1 이상이면 ㅣ i번째 원소 반환
		for (int i = 0; i < idx; i++) {
			curr = curr.link;
		}
		return curr;
	}

	// 마지막 원소
	public void addLast(String data) {
		Node freshNode = new Node(data);
		if (size == 0) {
			addFirst(data);
			return;
		}
		Node curr = head;
		while (curr.link != null) {
			curr = curr.link;
		}
		
		curr.link = freshNode;
		size++;

	}

	public void add(int idx, String data) {
		// 특정 idx번째
		if (idx < 0 || idx > size) {
			return;
		}

		// 양 끝 부분이 문제되니까..
		if (idx == 0) {
			addFirst(data);
			return;
		}
		if (idx == size) {
			addLast(data);
			return;
		}

		Node preNode = search(idx - 1);
		Node freshNode = new Node(data);
		freshNode.link = preNode.link;
		preNode.link = freshNode;
		size++;

	}

	// 연결리스트 첫 번째 원소 삭제
	public String remove() {
		if(head == null) {
			return "Nothing";
		}
		String data = head.data;
		head = head.link;
		size--;
		
		return data;
	}

	public String remove(int idx) {
		if(idx == 0) {
			remove();
		}
		if(idx > size) {
			return "못 뽑음";
		}
		Node pre = search(idx - 1);
		String data = pre.link.data;
		pre.link = pre.link.link;
		size--;
		return data;
		
		
	}
	
	public void printList() {
		Node curr = head;
		if (head == null) {
			System.out.println("비어있엉");
			return;
		}
		
		while(curr != null) {
			System.out.print(curr.data + "--> ");
			curr = curr.link;
		}
		System.out.println();
		
	}

}
