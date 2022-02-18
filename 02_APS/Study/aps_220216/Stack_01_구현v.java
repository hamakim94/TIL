package aps_220216;

import java.util.Arrays;

public class Stack_01_구현v {

	public static int top = -1;

	public static int[] arr = new int[100];

	public static void main(String[] args) {
		push(1);
		push(2);
		peek();
		pop();
		peek();
		pop();
		peek();
		printNow();
		push(2);
		push(2);
		push(2);	
		printNow();
		pop();
		printNow();

	}

	public static boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}

	public static boolean isFull() {
		if (top == 99) {
			System.out.println("꽉 차있어요");
			return true;
		}
		return false;

	}

	public static boolean push(int input) {
		if (!isFull()) {
			arr[++top] = input;
			return true;
		} else {
			System.out.println("꽉 차서 못 합니다");
			return false;
		}

	}

	public static boolean pop() {
		if (!isEmpty()) {

			System.out.println(arr[top--] + " 가 빠졌습니다.");
			return true;
		}
		System.out.println("비어있어서 못 해요");
		return false;

	}

	public static boolean peek() {
		if (top >= 0) {
			System.out.println("현재 최상단은 " + arr[top] + " 입니다.");
			return true;
		}
		System.out.println("현재 arr이 비어있습니다");
		return false;

	}

	public static void printNow() {

		if (top >= 0) {
			for (int i = 0; i <= top; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		} else {
			System.out.println("비어있음 ㅠ");
		}
	}

}
