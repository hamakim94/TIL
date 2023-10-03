import java.util.Arrays;

public class Comb {

    static int N;
    static int K;
    static int[] sel;

    public static void main(String[] args) {
        N = 4;
        K = 2;
        sel = new int[N];

        comb(0, 0);

    }

    private static void comb(int start, int depth) {
        if(depth == K){
            System.out.println(Arrays.toString(sel));
            return;
        }
        for(int i=start; i<N; i++){
            if(sel[i] == 0){
                sel[i] = 1;
                comb(i+1, depth+1);
                sel[i] = 0;
            }

        }
    }

}
