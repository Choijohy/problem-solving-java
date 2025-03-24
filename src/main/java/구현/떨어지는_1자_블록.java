package 구현;


import java.util.*;
import java.io.*;

public class 떨어지는_1자_블록 {
    static int[][] grid;
    static int n,m,k;

    public static void solution(){
        int rowToFill = n-1;
        boolean flag = true;

        // 채울공간 탐색
        for (int i=0;i<n;i++){
            for (int j=k-1;j<k+m-1;j++){
                if (grid[i][j] == 1){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                rowToFill = i-1;
                break;
            }
        }

        // 채우기
        for (int i=k-1;i<k+m-1;i++) grid[rowToFill][i] = 1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}