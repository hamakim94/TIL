import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_5073_삼각형과세변 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            if (start == 0) {
                break;
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            pq.add(start);
            pq.add(Integer.parseInt(st.nextToken()));
            pq.add(Integer.parseInt(st.nextToken()));
            int maxi = pq.poll();
            int midi = pq.poll();
            int mini = pq.poll();

            if (maxi >= midi + mini) {
                System.out.println("Invalid");
            } else {
                if (maxi == midi && midi == mini) {
                    System.out.println("Equilateral");
                } else if (maxi == midi || midi == mini || mini == maxi) {
                    System.out.println("Isosceles");
                } else {
                    System.out.println("Scalene");
                }
            }

        }

    }
}
