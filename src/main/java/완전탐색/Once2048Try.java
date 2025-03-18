package 완전탐색;

import java.io.*;
import java.util.*;
/*
문제: 단 한번의 2048 시도
유형: 시뮬레이션(격)
공부:
    - 방향이 여러개일 경우 어떻게 처리할 것인가?
    - 격자 내의 터지고 떨어지는 경우-> temp 배열을 사용하면, 보다 쉽게 접근할 수 있다.

*/
class Once2048Try{
    static final int NONE = -1;
    static final int n = 4;
    static int[][] grid = new int[n][n];

    private static void drop(){
        int[][] temp = new int[n][n];

        for (int r=0; r<n;r++){
            int keepNum = NONE, tempCol = n-1;

            for (int c=n-1; c>=0; c--){
                if (grid[r][c] == 0) continue;

                if (keepNum == NONE) keepNum = grid[r][c];
                else if (keepNum == grid[r][c]){
                    temp[r][tempCol--] = keepNum * 2;
                    keepNum = NONE;
                }
                else{
                    temp[r][tempCol--] = keepNum;
                    keepNum = grid[r][c];
                }
            }

            if (keepNum != NONE){
                temp[r][tempCol] =keepNum;
            }
        }

        // grid에 최종 결과 복사
        for (int i=0; i<n;i++){
            for (int j=0; j<n; j++)
                grid[i][j] = temp[i][j];
        }
    }
    private static void rotate(int move){
        int[][] rotated = new int[n][n];
        // 오른쪽으로 90도씩 회전
        for (int i=0; i<move; i++){
            // 회전
            for (int r=0; r<n; r++){
                for (int c=0; c<n; c++){
                    rotated[r][c] = grid[n-1-c][r];
                }
            }

            // 기존 grid에 결과 복사
            for (int r=0; r<n; r++){
                for (int c=0; c<n; c++){
                    grid[r][c] = rotated[r][c];
                }
            }
        }
    }

    private static void tilt(int move){
        // 오른쪽으로 90도 회전
        rotate(move);

        // 오른쪽으로 전부 떨어뜨리기
        drop();

        // 재회전
        rotate(n-move);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in
        ));
        StringTokenizer st;

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        HashMap<Character, Integer> dirMap = new HashMap<>();
        dirMap.put('R',0);
        dirMap.put('U',1);
        dirMap.put('L',2);
        dirMap.put('D',3);
        char dir = br.readLine().charAt(0);

        tilt(dirMap.get(dir));

        for (int i=0; i<n;i++){
            for (int j=0; j<n; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}