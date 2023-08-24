package aps_220216;

public class Stack_10_PowerSet_For {
	public static void main(String[] args) {
		int[] sel = new int [4];
		
		String[] ingre = {"단무지", "당근", "참치", "햄"};
		int N = ingre.length;
		
		for(int i=0; i<2; i++) {
			sel[0] = i;
			for(int j=0; j<2; j++) {
				sel[1] = j;
				for(int k=0; k<2; k++) {
					sel[2] = k;
					for(int l=0; l<2; l++) {
						sel[3] = l;
						
						// 이제 다 뽑았으니;;
						for(int a=0; a< N;a++) {
							if(sel[a] == 1) {
								System.out.print(ingre[a]);
							}

						}
						System.out.println(":김밥");
					}
				}
			}
		}
	}
}
