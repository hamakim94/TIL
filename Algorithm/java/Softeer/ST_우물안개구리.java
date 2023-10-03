import java.util.*;
import java.io.*;


public class ST_우물안개구리
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] weights = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i <= N; i++){
            weights[i] = Integer.parseInt(st.nextToken());
        }
        PriorityQueue<Integer>[] caculate = new PriorityQueue[N+1];
        for(int i=1; i<=N; i++){
            caculate[i] = new PriorityQueue<Integer>((a, b) -> b - a);
        }

        // int[PriorityQueue]를 만들어서, 관계 있는 무게를 넣고
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            caculate[start].add(weights[end]);
            caculate[end].add(weights[start]);
        }
        int answer = 0;

        // 1부터 for문을 돌면서, 
        for(int i=1; i<=N; i++){
            // 만약 리스트가 비어있으면, 그사람은 점수에 추가
            if(caculate[i].size() == 0){
                answer++;
            } else{
                // 첫 번쨰 값이랑 내 값이랑 비교 후, 크면 답
                if(weights[i] > caculate[i].poll()){
                    answer++;
                }
            }

        } // end for
        System.out.println(answer);

    }
}