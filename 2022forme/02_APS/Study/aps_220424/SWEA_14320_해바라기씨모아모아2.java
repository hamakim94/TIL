package aps_220424;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_14320_해바라기씨모아모아2 {

	static int N, K, B; // N : 집까지거리 K : 해바라기 수 B : 합
    static int startIdx; // 시작 인덱스 저장?
    static int[] arr, sel, ansCandidate; // arr : 도토리 무게들 , sel : 선택한 도토리스, 정답후보
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            N = sc.nextInt();
            K = sc.nextInt();
            B = sc.nextInt();
 
            arr = new int[N];
            sel = new int[K];
            startIdx = 0;
            ansCandidate = new int[K];
            // 입력 완료
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
 
            pick(0, 0, 0);
            int sumAns = 0;
            for (int k : ansCandidate)
                sumAns += k;
            if (sumAns == 0) {
                sb.append(-1);
            } else {
                Arrays.sort(ansCandidate);
                for (int i : ansCandidate) {
                    if(i == 0) continue;
                    sb.append(i).append(" ");
                }
            }
            sb.append("\n");
        } // end testCase
        System.out.println(sb);
    }
 
    private static void pick(int idx, int sidx, int sum) {
        // base case
        if (sum > B) // 합이 B보다 크면 그냥 out!
            return;
        if (sum == B) { // 합이 B인 경우, 시작인덱스 0 보다 시작점이 크거나 같다면
            if (startIdx <= sel[0]) {
                // 값 복사
            	ansCandidate = new int[K];
                for (int k = 0; k < sidx; k++) {
                    ansCandidate[k] = arr[sel[k]];
                }
            }
            return;
        }
        // sidx==K 이면 그만해야함, 만약 합이 B인 경우는 위에서 알아서 return되고, idx==끝까지 가면 끝
        if (sidx == K || idx == N) {
            return;
        }
 
        // 하나 넣기
        sel[sidx] = idx;
        pick(idx + 1, sidx + 1, sum + arr[idx]);
        pick(idx + 1, sidx, sum); // 여기선, sidx 증가 안 했으니, 다음 idx에서 값 최신
 
    }
}
 