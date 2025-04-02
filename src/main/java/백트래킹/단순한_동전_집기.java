package 백트래킹;

import java.io.*;
/*
문제: 단순한 동전 챙기기
유형: 백트래킹

*/

public class 단순한_동전_집기 {
    static int answer = Integer.MAX_VALUE;
    static int n;
    static int[][] arr;
    static final int START = 0;
    static final int END = 10;

    private static void dfs(int coin, int L, int sum){
        //System.out.println("coin: "+coin+" L: "+L+" sum: "+sum);
        if(L==3){

            sum += Math.abs(arr[coin][0]-arr[END][0]) + Math.abs(arr[coin][1]-arr[END][1]);
            //System.out.println("방법1: "+sum);
            answer = Math.min(answer,sum);
            return;
        }
        for (int i=coin+1;i<=9;i++){
            if (arr[i][0] == -1) continue;
            int dis = Math.abs(arr[coin][0]-arr[i][0]) + Math.abs(arr[coin][1]-arr[i][1]);
            dfs(i, L+1, sum + dis);

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in));

        n = Integer.parseInt(br.readLine());

        // S,E,1~9까지의 위치 좌표
        arr = new int[11][2];
        for (int i=0; i<11; i++){
            for (int j=0; j<2; j++){
                arr[i]= new int[]{-1,-1};
            }
        }

        // 입력
        for (int i=0; i<n; i++){
            String str = br.readLine();
            for (int j=0; j<n; j++){
                char c = str.charAt(j);
                if (c == 'S'){
                    arr[START][0] = i;
                    arr[START][1] = j;
                }
                else if (c == 'E'){
                    arr[END][0] = i;
                    arr[END][1] = j;
                }
                else if (c != '.'){
                    int num = c - 48;
                    arr[num][0] = i;
                    arr[num][1] = j;
                }
            }
        }


        dfs(0,0,0);

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer);
    }
}