package 완전탐색;
/*
* 문제: 최고의 33[Easy]
* 유형: 완전탐색
* 공부:
*   - 재귀호출 or for문
*   - 격자에서의 완전 탐색 -> 모서리 x,y값을 인자로 호출 or for문 탐색
*   - 테스트케이스
*       1) 맨 마지막 탐색이 정답이 되는 경우
*       2) 유효 범위 벗어날 수 있는 경우
* */
import java.io.*;

public class Maximum33 {
    static int N;
    static int answer = 0;
    static int[][] graph;

    // for문
    public static void getCoin2(int x, int y){
        int sum = 0;
        for (int i=x; i<x+3;i++){
            for (int j=y; j< y+3; j++){
                sum += graph[i][j];
            }
        }
        answer = Math.max(answer, sum);
    }
    // 재귀함수
    public static void getCoin(int x, int y){

        if (x+2 >= N) return;

        int sum = 0;
        for (int i=x; i<x+3;i++){
            for (int j=y; j< y+3; j++){
                sum += graph[i][j];
            }
        }
        answer = Math.max(answer, sum);

        if (y == N-3) getCoin(x+1, 0);
        else getCoin(x, y+1);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in
        ));

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        for (int i=0;i<N;i++){
            String[] str = br.readLine().split(" ");
            for (int j=0; j<N;j++){
                graph[i][j] = Integer.parseInt(str[j]);
            }
        }
        getCoin(0,0);

        //for (int i=0; i<N-2; i++){
        //    for (int j=0; j<N-2;j++){
        //        getCoin2(i,j);
        //    }
        // }
        System.out.println(answer);
        br.close();
    }
}