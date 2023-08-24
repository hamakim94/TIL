package aps_220214;

public class String_atoi_itoa {

	public static void main(String[] args) {
		
		System.out.println(atoi("1234"));
		System.out.println(itoa(1234));
		
		// 현실
		// 1234 + ""
		// String.valueOf(1234)
	}

	// 문자열을 정수로 만들자!!
	public static int atoi(String text) {
		int value = 0;

		int digit; // 여기서 인트니까, 최종 char계산도 int로 바뀜
		// 앞에섭터 하나씩 읽어와서 숫자로 바꾸고 더한다.
		// 자리수를 바꾸어주기위해 *10을 한뒤 더한다
		for (int i = 0; i < text.length(); i++) {
			char num = text.charAt(i);
			// 일단 i번쨰 자리가 숫자인지 확인.
			if (num >= '0' && num <= '9') {
				digit = num - '0';
			} else {
				break;
			}
			value = 10 * value + digit;

		}

		return value;

	}

	// 숫자를 문자열로 바꿔보자
	public static String itoa(int value) {
		StringBuilder sb = new StringBuilder();

		int tmp = value;
		while (tmp > 0) {
			char c = (char) (tmp % 10 + 48);
			sb.append(c);
			tmp /= 10;
		}
		return sb.reverse().toString();

	}
}
