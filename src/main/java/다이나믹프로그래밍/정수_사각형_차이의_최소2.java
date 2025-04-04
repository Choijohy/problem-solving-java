package 다이나믹프로그래밍;


import java.util.*;
import java.io.*;

public class 정수_사각형_차이의_최소2 {
    static final int MIN = 0;
    static final int MAX = 1;
    static final int DIFF = 2;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[n][n][3]; // min,max,diff

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                dp[i][j][2] = Integer.MAX_VALUE;
            }
        }
        dp[0][0][MIN] = grid[0][0];
        dp[0][0][MAX] = grid[0][0];
        dp[0][0][DIFF] = 0;

        // 1행 전체
        for (int i=1; i<n; i++){
            int prevMin = dp[0][i-1][MIN];
            int prevMax = dp[0][i-1][MAX];
            int prevDiff = dp[0][i-1][DIFF];

            int cur = grid[0][i];

            if (cur < prevMin){
                dp[0][i][MIN] = cur;
                dp[0][i][MAX] = prevMax;
                dp[0][i][DIFF] = prevMax - cur;
            }
            else if (cur > prevMax){
                dp[0][i][MIN] = prevMin;
                dp[0][i][MAX] = cur;
                dp[0][i][DIFF] = cur-prevMin;
            } else{
                dp[0][i][MIN] = prevMin;
                dp[0][i][MAX] = prevMax;
                dp[0][i][DIFF] = prevDiff;
            }
        }

        // 1열 전체
        for (int i=1; i<n; i++){
            int prevMin = dp[i-1][0][MIN];
            int prevMax = dp[i-1][0][MAX];
            int prevDiff = dp[i-1][0][DIFF];

            int cur = grid[i][0];

            if (cur < prevMin){
                dp[i][0][MIN] = cur;
                dp[i][0][MAX] = prevMax;
                dp[i][0][DIFF] = prevMax - cur;
            }
            else if (cur > prevMax){
                dp[i][0][MIN] = prevMin;
                dp[i][0][MAX] = cur;
                dp[i][0][DIFF] = cur-prevMin;
            } else{
                dp[i][0][MIN] = prevMin;
                dp[i][0][MAX] = prevMax;
                dp[i][0][DIFF] = prevDiff;
            }
        }

        int[] dx = {0,-1};
        int[] dy = {-1,0};
        // 나머지
        for (int x=1; x<n; x++){
            for (int y=1; y<n; y++){
                for (int k=0; k<2;k++){
                    int px = x + dx[k];
                    int py = y + dy[k];

                    int prevMin = dp[px][py][MIN];
                    int prevMax = dp[px][py][MAX];
                    int prevDiff = dp[px][py][DIFF];

                    int cur = grid[x][y];
//                    System.out.println("x: "+x+" y: "+y+" cur: "+cur);
                    if (prevMin > cur){
                        if ((prevMax - cur) < dp[x][y][DIFF]){
                            dp[x][y][MIN] = cur;
                            dp[x][y][MAX] = prevMax;
                            dp[x][y][DIFF] = prevMax - cur;
//                            System.out.println("최소값 갱신");
//                            System.out.print(dp[x][y][MIN]+ ",");
//                            System.out.print(dp[x][y][MAX]+ ",");
//                            System.out.print(dp[x][y][DIFF]+ " ");
//                            System.out.println();
                        }
                        }
                    else if (cur > prevMax){
                        if ((cur - prevMin) < dp[x][y][DIFF]){
                            dp[x][y][MIN] = prevMin;
                            dp[x][y][MAX] = cur;
                            dp[x][y][DIFF] = cur - prevMin;
//                            System.out.println("최대값 갱신");
//                            System.out.print(dp[x][y][MIN]+ ",");
//                            System.out.print(dp[x][y][MAX]+ ",");
//                            System.out.print(dp[x][y][DIFF]+ " ");
//                            System.out.println();
                        }
                    }
                    else{
                        if (prevDiff < dp[x][y][DIFF]){
                            dp[x][y][MIN] = prevMin;
                            dp[x][y][MAX] = prevMax;
                            dp[x][y][DIFF] = prevDiff;
//                            System.out.println("최대 최소 갱신 없이 이전값 그대로");
//                        System.out.print(dp[x][y][MIN]+ ",");
//                        System.out.print(dp[x][y][MAX]+ ",");
//                        System.out.print(dp[x][y][DIFF]+ " ");
//                        System.out.println();
                        }
                    }

                }
            }
        }

//        for (int i=0; i<n; i++){
//            for (int j=0; j<n; j++){
//                System.out.print(dp[i][j][MIN]+",");
//                System.out.print(dp[i][j][MAX]+",");
//                System.out.print(dp[i][j][DIFF]+" ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[n-1][n-1][DIFF]);

    }
}