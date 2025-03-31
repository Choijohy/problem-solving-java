package 구현;

import java.io.*;
import java.util.*;

public class 테트로미노{
    static int n,m;
    static int[][] grid;
    static int answer = 0;


    private static void search(int[] dx, int[] dy){
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                int sum = grid[i][j];
                int k;
                for (k = 0; k<3; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx>-1 && nx<n && ny>-1 && ny<m){
                        sum += grid[nx][ny];
                    }
                    else{
                        break;
                    }
                }
                if (k == 3) {
                    answer = Math.max(answer, sum);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1번 도형
        search(new int[]{1,2,3}, new int[]{0,0,0});
        search(new int[]{0,0,0}, new int[]{1,2,3});

        // 2번 도형
        search(new int[]{1,0,1}, new int[]{0,1,1});

        // 3번 도형
        search(new int[]{1,2,2}, new int[]{0,0,1});
        search(new int[]{0,-1,-2}, new int[]{1,1,1});
        search(new int[]{1,1,1}, new int[]{0,1,2});
        search(new int[]{0,1,2}, new int[]{1,0,0});
        search(new int[]{0,0,1}, new int[]{1,2,2});
        search(new int[]{1,0,0}, new int[]{0,1,2});
        search(new int[]{0,1,2}, new int[]{1,1,1});
        search(new int[]{0,0,-1}, new int[]{1,2,2});

        // 4번 도형
        search(new int[]{1,1,2}, new int[]{0,1,1});
        search(new int[]{0,-1,-1}, new int[]{1,1,2});
        search(new int[]{1,1,2}, new int[]{0,-1,-1});
        search(new int[]{0,1,1}, new int[]{1,1,2});

        // 5번 도형
        search(new int[]{0,0,1}, new int[]{1,2,1});
        search(new int[]{0,0,-1}, new int[]{1,2,1});
        search(new int[]{1,2,1}, new int[]{0,0,1});
        search(new int[]{0,-1,1}, new int[]{1,1,1});

        System.out.println(answer);
    }
}