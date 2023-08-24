import java.util.Scanner;

public class PGS_직사각형별찍기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int col = sc.nextInt();
		int row = sc.nextInt();

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
