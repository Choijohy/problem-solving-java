package 구현;

import java.util.*;
import java.io.*;

public class 십자_모양_폭발_1 {
    static int n;
    static int[][] grid;

    private static void gravity(){
        for (int c = 0; c<n; c++){
            for (int r = n-1; r > 0; r--){
                // 중력이 적용될 칸이 존재한다면
                if (grid[r][c] == 0){
                    for (int k=r-1; k>-1; k--){
                        int num = grid[k][c];
                        // 중력 이동
                        if (num != 0){
                            grid[r][c] = num;
                            grid[k][c] = 0;
                            break;
                        }
                    }

                }
            }
        }
    }
    private static void explosion(int x, int y){
        final int[] dx = {0,0,-1,1};
        final int[] dy = {1,-1,0,0};

        int num = grid[x][y] - 1;
        grid[x][y] = 0; // 중심점 폭발

        for (int k=0;k<4;k++){
            int sx = x;
            int sy = y;
            for (int i=0; i<num;i++){
                int nx = sx + dx[k];
                int ny = sy + dy[k];
                if (nx>-1 && nx<n && ny >-1 && ny<n){
                    grid[nx][ny] = 0;
                    sx = nx;
                    sy = ny;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in));

        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        explosion(r-1,c-1);
        gravity();

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}