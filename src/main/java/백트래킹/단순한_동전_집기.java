package 백트래킹;

import java.util.*;
import java.io.*;
/*
문제: 단순한 동전 챙기기
유형: 백트래킹
기타:
    - char -> int: (int)c - '0'
*/

public class 단순한_동전_집기 {
    static int[][] arr = new int[11][2];
    static final int END = 10;
    static int answer = Integer.MAX_VALUE;

    private static void dfs(int coin, int L, int sum){
       if (L==3){
            sum += Math.abs(arr[coin][0]-arr[END][0]);
            sum += Math.abs(arr[coin][1]-arr[END][1]);
            answer = Math.min(answer, sum);
            return;
       }
       for (int i=coin+1; i<END; i++){
            if (arr[i][0] != -1){
                sum += Math.abs(arr[coin][0]-arr[i][0]);
                sum += Math.abs(arr[coin][1]-arr[i][1]);

                dfs(i, L+1, sum);

                sum -= Math.abs(arr[coin][0]-arr[i][0]);
                sum -= Math.abs(arr[coin][1]-arr[i][1]);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<=END;i++){
            Arrays.fill(arr[i],-1);
        }

        for (int i=0; i<n; i++){
            String line = br.readLine();
            for (int j=0; j<n; j++){
                char c = line.charAt(j);
                if (c == '.') continue;
                else if (c == 'S') arr[0] = new int[]{i,j};
                else if (c == 'E') arr[10] = new int[]{i,j};
                else arr[(int)c-'0'] = new int[]{i,j};
            }
        }

        dfs(0,0,0);

        if (answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }
}