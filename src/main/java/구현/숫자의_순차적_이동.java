package 구현;


import java.util.*;
import java.io.*;
/*
문제: 숫자의 순차적 이동
유형: 구현
공부:
    -히든 케이스
     1) 가운데가 주변보다 제일 클 경우(가운데 보다 작더라도, 인근 주변에서 제일 크면 바꿔준다.)
*/

public class 숫자의_순차적_이동 {
    static int n;
    static int m;
    static int[][] grid;
    static int[] dx = {0,0,1,-1,-1,-1,1,1};
    static int[] dy = {-1,1,0,0,-1,1,-1,1};

    private static void solution(){
        for (int target = 1; target<=n*n; target++){
            boolean flag = false;
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    if (grid[i][j] == target){
                        int maxValue = 0;
                        int[] maxLocation = new int[]{i,j};

                        for (int k=0;k<8;k++){
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx>-1 && nx<n && ny>-1 && ny<n && (maxValue < grid[nx][ny])){
                                maxValue = grid[nx][ny];
                                maxLocation = new int[]{nx,ny};
                            }
                        }
                        grid[maxLocation[0]][maxLocation[1]] = grid[i][j];
                        grid[i][j] = maxValue;
                        flag = true;
                        break;
                    }
                }
                if(flag)
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i=0;i<m;i++)
            solution();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                System.out.print(grid[i][j]+" ");
            System.out.println();
        }
    }
}