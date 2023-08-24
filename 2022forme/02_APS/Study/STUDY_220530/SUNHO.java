package STUDY_220530;

import java.util.Scanner;

public class SUNHO {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int tc=0;tc<T;tc++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			//�듅�젙 �룷�씤�듃�뱾�쓣 諛곗뿴濡� ����옣
			//�빐�떦 媛믪쓽 �씪李⑥썝 諛곗뿴�뿉 row��� column����옣
			int[][] points=new int[M+1][2];
			int[][] arr = new int[N][N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j]=sc.nextInt();
					//醫뚰몴 ����옣
					if(arr[i][j]>0) {
						points[arr[i][j]][0]=i;
						points[arr[i][j]][1]=j;
					}
				}
			}//�솗�옣�븳 諛곗뿴 留뚮뱾湲�			
			
			
			int stIdx=1;  // �떆�옉 �씤�뜳�뒪
			int stR=N;    // �떆�옉 row
			int stC=N;    // �떆�옉 column
			int result=0; // 寃곌낵媛�
			
			// �쇊履� �쐞, �쐞, �삤瑜몄そ �쐞, �쇊履�, 以묎컙, �삤瑜몄そ, �쇊履� �븘�옒, �븘�옒, �삤瑜몄そ �븘�옒
			int[] dr= {0, 0, 0, N, N, N, 2*N, 2*N, 2*N};
			int[] dc= {0, N, 2*N, 0, N, 2*N, 0, N, 2*N};
			//�씤�뜳�뒪媛� M�씠 �맆�븣源뚯��
			while(stIdx<=M) {
				//�떎�쓬 紐⑺몴媛� �맆 row��� column �꽕�젙
				int nextR=points[stIdx][0];
				int nextC=points[stIdx][1];
				//理쒖냼媛� 珥덇린�솕(媛��옣 �겙 媛믪씠湲� �븣臾�)
				int min=2*N;
				//珥� 9諛⑺뼢�뿉 ����븳 湲몄씠�쓽 理쒖냼媛� 援ы븯湲�
				for(int i=0;i<9;i++) {
					//諛⑺뼢蹂� ���源껋쓽 醫뚰몴 援ы븯湲�
					int targetR=nextR+dr[i];
					int targetC=nextC+dc[i];
					//李⑥씠 援ы븯湲�
					int distance=Math.abs(stR-targetR)+Math.abs(stC-targetC);
					//理쒖냼媛� 
					min=Math.min(min, distance);
				}
				result+=min;   //理쒖냼媛믪쓣 寃곌낵�뿉 �뜑�빐二쇨린
				//�떎�쓬醫뚰몴 以�鍮�
				stR=nextR+N;
				stC=nextC+N;
				stIdx++;
			}
			
			System.out.printf("#%d %d\n",tc+1,result);
		}
		
	}
}
