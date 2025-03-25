package 구현;

import java.util.*;
import java.io.*;
/*
문제: 숫자가 가장 큰 인접한 곳으로 동시에 이동
유형: 구현
공부:
    - 테스트 케이스
        1) 모두 안 사라지는 경우
        2) 모두 사라지는 경우
        3) 구슬이 1개인 경우
        4) 구슬이 꽉 찬 경우
*/
public class 숫자가_가장_큰곳으로_이동 {
    static int n;
    static int[][] grid;
    static int[][] marbles;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    private static void simulate(){
        int[][] temp = new int[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                temp[i][j] = marbles[i][j];
            }
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                // 구슬이 있다면
                if (temp[i][j]== 1){
                    // 상하좌우 탐색
                    int max = 0;
                    int[] location = new int[]{i,j};
                    for (int k=0; k<4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx>-1 && nx<n && ny>-1 && ny<n && (max < grid[nx][ny])){
                            max = grid[nx][ny];
                            location[0] = nx;
                            location[1] = ny;
                        }
                    }
                    marbles[location[0]][location[1]] = marbles[location[0]][location[1]] +1;
                    marbles[i][j] = marbles[i][j] -1;
                }
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                //System.out.println("i: "+i+" j: "+j+" 구슬 개수: "+marbles[i][j]);
                if (marbles[i][j] >= 2)
                    marbles[i][j] = 0;

            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        marbles = new int[n][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            marbles[r-1][c-1] = 1;
        }

        for (int i=0; i<t; i++)
            simulate();

        int count = 0;
        for (int i=0; i<n;i++){
            for (int j=0; j<n; j++){
                if (marbles[i][j] == 1) count ++;
            }
        }
        System.out.println(count);
    }
}