import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19948_음유시인영재 {
    public static void main(String[] args) throws IOException {
        // 스페이스바 입력 횟수가 모자르면 -1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input = br.readLine();
        int spaceCnt = Integer.parseInt(br.readLine()); // 스페이스 수
        boolean flag = true; // 가능 여부
        String title = "";
        int[] charCnt = new int[26];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<26; i++){
            charCnt[i] = Integer.parseInt(st.nextToken());
        }
        int space = 0;
        Queue<Character> que = new LinkedList<>();
        for(int i=0; i<input.length(); i++) {
            que.add(input.charAt(i));
        }
        char before = '3';
        while(!que.isEmpty()){
            char now = que.poll();
            if(before == '3'){
                title += toBig(now);
                charCnt[toBig(now)-'A']--;
            } else{
                if(now == before) continue;
                if(now == ' '){
                    space++;
                    if(space > spaceCnt){
                        flag = false;
                        break;
                    }
                } else{
                    if(before == ' '){
                        title += toBig(now);
                    }
                    charCnt[toBig(now) - 'A']--;
                    if(charCnt[toBig(now) - 'A'] < 0){
                        flag = false;
                        break;
                    }
                }
            }
            before = now;

        }
        if(flag) {
            boolean newFlag = true;
            que = new LinkedList<>();
            for (int i = 0; i < title.length(); i++) {
                que.add(title.charAt(i));
            }
            before = '3';
            while (!que.isEmpty()) {
                char now = que.poll();
                if (before == '3') {
                    charCnt[toBig(now)-'A']--;
                } else {
                    if (now == before) continue;
                    charCnt[toBig(now) - 'A']--;
                }
                if (charCnt[toBig(now) - 'A'] < 0) {
                    newFlag = false;
                    break;
                }
                before = now;
            }
            if (newFlag) {
                System.out.println(title);
            } else {
                System.out.println(-1);
            }
        } else {
            System.out.println(-1);
        }

    }
    public static char toBig(char now){
        if(now - 'a' >= 0){
            return ((char) (now + ('A' - 'a')));
        } else{
            return now;
        }
    }
}
