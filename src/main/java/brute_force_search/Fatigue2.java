package brute_force_search;


public class Fatigue2 {
    public static void main(String[] args){
        Fatigue fatigue = new Fatigue();
        Fatigue.Solution solution = fatigue.new Solution();

        System.out.println(solution.solution(80,new int[][]{{80,20},{50,40},{30,10}}));
        System.out.println(solution.solution(80,new int[][]{{80,20}}));
    }

    class Solution {
        static boolean[] visited;

        public int solution(int k, int[][] dungeons) {
            visited = new boolean[dungeons.length];
            int answer = 0; // 탐험 횟수
            return checkFatigue(k, dungeons, answer);
        }

        public int checkFatigue(int k, int[][] dungeons, int answer) {
            int maxValue = answer;

            for (int i = 0; i < dungeons.length; i++) {
                int required = dungeons[i][0];
                int consume = dungeons[i][1];

                if (!visited[i] && k>= required){
                    visited[i] = true;
                    int temp = checkFatigue(k - consume, dungeons, answer+1);
                    visited[i] = false;
                    maxValue = Math.max(maxValue, temp);
                }
            }
            return maxValue;
        }
    }
}
