package aps_220224;

public class LinkedListStackShow {
	public static void main(String[] args) {
		Stack_LinkedList stack = new Stack_LinkedList();
		
		stack.push("1번말");
		stack.printInverse();
		stack.push("2번말");
		stack.printInverse();
		stack.push("3번말");
		stack.printInverse();
		System.out.println(stack.pop());
		stack.printInverse();
		
		
		
	}
}
