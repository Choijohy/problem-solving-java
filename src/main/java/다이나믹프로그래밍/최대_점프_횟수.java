package 다이나믹프로그래밍;

import java.util.*;
import java.io.*;

/*
문제: 최대 점프 횟수
유형: dp
공부:
    1) 테스트 케이스
        - 엣지 케이스
        - 첫 칸이 0일때
        - 더이상 전진 못하는 구간 이후(110005678)
*/
public class 최대_점프_횟수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
            dp[i] = -1;
        }

        dp[0] = 0;
        int answer = 0;
        for (int i=1; i<n;i++){
            for (int diff = 1; diff <= i; diff++){
                if (dp[i-diff] == -1) continue;
                if (arr[i-diff] >= diff){
                    dp[i] = Math.max(dp[i], dp[i-diff]+1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}