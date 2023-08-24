package aps_220223;

public class LinkedList_01_단순연결리스트 {
	public static void main(String[] args) {
		SingleLinkedList slist = new SingleLinkedList();
		slist.printList();
		slist.addFirst("AA");
		slist.printList();
		slist.addFirst("BB");
		slist.printList();
		slist.addLast("CC");
		slist.printList();
		slist.add(1, "DD");
		slist.printList();
		System.out.println(slist.remove());
		slist.printList();
		System.out.println(slist.remove(1));
		slist.printList();
		
		

	}
}
