package aps_220408;

public class recursion {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		print(1);

	}

	private static void print(int i) {
		
		if(i > 5)
			return;
		
		System.out.println(i);
		print(i+1);
		System.out.println(i);
	}
}
