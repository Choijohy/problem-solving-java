package 완전탐색;

import java.util.*;
import java.io.*;

public class BestExplosion {
    static int n;
    static int[][] grid;
    static int answer = 0;

    private static void checkPair(int[][] movedGrid){
        final int[] dx = {0,1};
        final int[] dy = {1,0};

        int count = 0;
        for (int x=0; x<n; x++){
            for(int y=0; y<n; y++){
                int num = movedGrid[x][y];
                if (num != 0){
                    for (int k=0; k<2; k++){
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx>-1 && nx<n && ny>-1 && ny<n)
                            if (num == movedGrid[nx][ny])
                                count++;

                    }
                }

            }
        }
        answer = Math.max(answer, count);
    }
    private static int[][] letDown(int[][] newGrid){
        int[][] temp = new int[n][n];

        for (int c=0; c<n; c++){
            int tempRow = n-1;
            for (int r=n-1; r>=0; r--){
                if (newGrid[r][c] != -1){
                    temp[tempRow--][c] = newGrid[r][c];
                }
            }
        }
        return temp;
    }
    private static int[][] bomb(int r, int c){
        int[][] temp = new int[n][n];
        final int[] dx = {-1,1,0,0};
        final int[] dy = {0,0,-1,1};

        int count = grid[r][c] -1;
        temp[r][c] = -1; // 적중된 칸
        for (int i=0; i<4; i++){ // 상하좌우
            int x = r;
            int y = c;
            for (int j=0; j<count; j++){ // 각 방향별로 전파
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx>-1 && nx <n && ny>-1 && ny<n){
                    temp[nx][ny] = -1;
                    x = nx;
                    y = ny;
                }
            }
        }
        for (int i=0; i<n;i++){
            for (int j=0; j<n;j++){
                if (temp[i][j] != -1) temp[i][j] = grid[i][j];
            }
        }
        return temp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        grid = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                // 십자로 폭탄 터뜨리기
                int[][] bombedGrid = bomb(i,j);

                // 중력 적용
                int[][] movedGrid = letDown(bombedGrid);

                // for (int k=0; k<n;k++){
                //     for (int l=0; l<n; l++){
                //         System.out.print(movedGrid[k][l]+ " ");
                //     }
                //     System.out.println();
                // }
                // System.out.println();

                // 동일값 쌍 개수 구하기
                checkPair(movedGrid);
            }
        }

        System.out.println(answer);



    }
}