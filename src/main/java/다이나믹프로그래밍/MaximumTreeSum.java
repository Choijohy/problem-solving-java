package 다이나믹프로그래밍;

import java.util.*;

class MaximumTreeSum {
    public int solution(int[][] triangle) {
        int level = triangle.length; // 트리 높이
        int[] dp = new int[level*(level+1)/2+1];
        dp[1] = triangle[0][0];
        int index = 0;
        int depth = 0;

        for (int k=0; k<level-1;k++){
            int size = triangle[k].length;
            depth ++;
            for (int i=0; i<size; i++){
                index ++;
                dp[index+depth] = Math.max(dp[index+depth],dp[index] + triangle[depth][i]);
                dp[index+depth+1] = Math.max(dp[index+depth+1],dp[index] + triangle[depth][i+1]);
            }
        }

        int answer = 0;
        int s = (depth*(depth+1)/2) +1;
        for (int i=s; i<=s+depth;i++){
                answer = Math.max(answer, dp[i]);
            }
        return answer;
    }
}