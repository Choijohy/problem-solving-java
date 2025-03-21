package 다이나믹프로그래밍;

import java.util.*;
import java.io.*;
/*
문제: 부분 수열의 합
유형: DP
공부:
    - 시간복잡도: 재귀를 통한 완탐 O(2^N)
    - dp: O(nm)
*/
public class 부분수열합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        boolean[] dp = new boolean[10001];

        int[] arr = new int[n];
        str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        for (int i=0; i<n; i++){
            int num = arr[i];
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(num);
            for (int j=0; j<=m ; j++){
                if (dp[j]&& (j+num<=10000))
                    temp.add(j+num);
            }
            for (int x: temp){
                dp[x] = true;
            }
            if (dp[m]) break;
        }

        if (dp[m]) System.out.println("Yes");
        else  System.out.println("No");
    }
}