package aps_220218;

public class Bit연산 {
	public static void main(String[] args) {
		// 비트단위끼리 & ,| ^: AND, OR, XOR
		System.out.println(3 & 5);
		System.out.println(3 | 5);
		System.out.println(3 ^ 5);

		// ~ : 비트를 반전(2의 보수법) : 개인적 공부, 2의 보수 + 1 해야 음의 값 나옴
		System.out.printf("%d \n", ~3);

		// shift! : A의 비트를 해당 방향으로 B만큼 이동, ㅇ

		// A<<B
		// Left Shilt 7 << 3, 왼쪽으로 한 칸 이동할 때 마다 2배가 돼
		System.out.printf("%d \n", 7 << 3);

		// A>>B : 오른쪽으로 B만큼 이동(2로 나눈 몫!, 나머지 버린다)
		System.out.printf("%d \n", 7 >> 1);
		// 111 => 011 => 110
		System.out.printf("%d \n", (7 >> 1) << 1);

		// A >>> B : 부호를 고려하지 않고 오른쪽으로 이동
	}
}
