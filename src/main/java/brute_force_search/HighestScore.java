package brute_force_search;

import java.util.* ;
public class HighestScore {
    public static void main(String[] args){
        HighestScore highestScore = new HighestScore();
        Solution solution = highestScore.new Solution();
        System.out.print(Arrays.toString(solution.solution(new int[]{1, 3, 2, 4, 2})));
    }
    class Solution {

        public int[] solution(int[] answers) {
            int n = answers.length;

            int score1 = 0, score2 = 0, score3 = 0;
            int answer1 = 1, answer2 = 2, answer3 = 3;

            int[] pattern1 = {1, 2, 3, 4, 5};
            int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

            for (int i=0; i<n; i++){
                int answer = answers[i];
                if (answer == pattern1[i % pattern1.length]){
                    score1 ++;
                }
                if (answer == pattern2[i % pattern2.length]){
                    score2 ++;
                }
                if (answer == pattern3[i % pattern3.length]){
                    score3 ++;
                }

            }

            List<Integer> result = new ArrayList<>();
            int maxScore = Math.max(score1, Math.max(score2, score3));

            if (maxScore == score1) result.add(1);
            if (maxScore == score2) result.add(2);
            if (maxScore == score3) result.add(3);

            return result.stream().mapToInt(Integer::intValue).toArray();
        }

    }
}
