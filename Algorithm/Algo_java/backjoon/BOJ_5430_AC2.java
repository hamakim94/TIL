import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_5430_AC2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            boolean isError = false;
            boolean isReverse = false;
            char[] commands = br.readLine().toCharArray();
            int size = Integer.parseInt(br.readLine());
            String input = br.readLine();
            String[] split = input.substring(1, input.length()-1).split(",");
            Deque<String> deque = new LinkedList<>();
            if(!input.equals("[]")){
                deque.addAll(Arrays.asList(split));
            }
            for (char c : commands){
                if (c == 'R') {
                    isReverse = !isReverse;
                } else {
                    if (deque.size() == 0) {
                        isError = true;
                        break ;
                    } else{
                        if (isReverse) {
                            deque.removeLast();
                        } else {
                            deque.removeFirst();
                        }
                    }

                }

            }

            if (isError) {
                sb.append("error").append('\n');
            } else{
                if (isReverse) {
                    sb.append('[');
                    while (!deque.isEmpty()) {
                        sb.append(deque.removeLast());
                        if(deque.isEmpty()) break;
                        sb.append(',');
                    }

                } else {
                    sb.append('[');
                    while (!deque.isEmpty()) {
                        sb.append(deque.removeFirst());
                        if(deque.isEmpty()) break;
                        sb.append(',');
                    }
                }
                sb.append(']').append('\n');
            }


        }
        System.out.println(sb);

    }
}
