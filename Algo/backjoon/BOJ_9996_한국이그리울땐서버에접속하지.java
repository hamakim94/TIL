import java.util.Scanner;
import java.util.regex.Pattern;


public class BOJ_9996_한국이그리울땐서버에접속하지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] startEnd = sc.next().split("\\*");
		String start = startEnd[0];
		String end = startEnd[startEnd.length-1];
		
		String pattern = String.format("^%s.*%s$", start, end);
		System.out.println(pattern);
		Pattern p = Pattern.compile(pattern);
		for(int i=0; i<N; i++) {
			if(p.matcher(sc.next()).matches()) {
				System.out.println("DA");
			} else {
				System.out.println("NE");
			}
		}
	}
}
