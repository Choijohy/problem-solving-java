package 다이나믹프로그래밍;

import java.util.*;
import java.io.*;

class LIS3{
    public static ArrayList<Integer> solution(int N, int[] arr){
        int[][] dp = new int[N+1][3]; // x번째 요소까지 모두 사용할때, 만들 수 있는 최장 증가 부분 수열 정보
        int answerTotal = 1;
        int answerIndex = 1;
        dp[1] = new int[]{0,arr[1],1}; // 직전 요소 인덱스, 현재까지의 최댓값, 현재까지 증가 수열 개수
        for (int i=1; i<=N; i++){
            int cur = arr[i];
            int count = 1;
            int prev = 0;
            for (int j=i-1; j>0; j--){
                int prevMax = dp[j][1];
                int prevCount = dp[j][2];
                if (cur > prevMax && prevCount+1 > count){
                    count = prevCount +1;
                    prev = j;
                }
            }
            dp[i] = new int[]{prev, cur, count};
            if (count > answerTotal ){
                answerTotal = count;
                answerIndex = i;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        int prev = answerIndex;
        while (prev > 0){
            int[] answer = dp[prev];
            result.add(answer[1]);
            prev = answer[0];
        }
        return result;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        String[] str = br.readLine().split(" ");
        for (int i=1; i <= N; i++){
            arr[i] = Integer.parseInt(str[i-1]);
        }

        ArrayList<Integer> result = solution(N, arr);
        bw.append(String.valueOf(result.size()));
        bw.newLine();
        for (int i=result.size()-1; i > -1; i--){
            bw.append(String.valueOf(result.get(i))).append(" ");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}