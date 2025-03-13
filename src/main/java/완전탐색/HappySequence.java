package 완전탐색;
/*
* 문제: 행복한 수열[Easy]
* 유형: 완전 탐색(재귀호출)
* 공부:
*   - 테스트케이스
*       1) M=1 일 경우
*       2) N=1 일 경우
*
*/
import java.util.*;
import java.io.*;

public class HappySequence {
    static int N;
    static int M;
    static int[][] graph;
    static int answer = 0;

    public static void checkRows(int row){
        int count = 1;
        int prev = graph[row][0]; // 시작점
        for (int i=1; i<N;i++){
            int temp = graph[row][i];
            if (prev == temp) count++;
            else count = 1;

            if (count == M){
                answer++;
                break;
            }
            prev = temp;
        }
        if (row < N-1) checkRows(row+1);
    }


    public static void checkCols(int col){
        int count = 1;
        int prev = graph[0][col]; // 시작점
        for (int i=1; i<N;i++){
            int temp = graph[i][col];
            if (prev == temp) count++;
            else count = 1;

            if (count == M){
                answer++;
                break;
            }
            prev = temp;
        }
        if (col < N-1) checkCols(col+1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        graph = new int[N][N];
        for (int i=0; i<N;i++){
            str = br.readLine().split(" ");
            for (int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(str[j]);
            }
        }

        if (M==1) answer = 2*N;
        else{
            checkRows(0);
            checkCols(0);
        }

        System.out.println(answer);
        br.close();

    }
}