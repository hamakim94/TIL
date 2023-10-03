public class PGS_43165_타겟넘버{
    class Solution {

        int answer = 0;

        public int solution(int[] numbers, int target) {
            recursive(numbers, 0, target, 0);
            return answer;
        }

        public void recursive(int[] numbers, int depth, int target, int sum){
            if(depth == numbers.length){
                if(sum == target){
                    answer++;
                }
                return;
            }
            // recursive case
            recursive(numbers, depth + 1, target, sum + numbers[depth]);
            recursive(numbers, depth + 1, target, sum - numbers[depth]);

        }
    }
}
