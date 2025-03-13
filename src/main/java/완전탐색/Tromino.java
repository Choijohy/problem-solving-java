package 완전탐색;
/*
* 문제: 트로미노[Medium]
* 유형: 완전 탐색(격자 안에서 완전 탐색)
* 공부:
   다른 풀이: dx,dy 배열 이용 x. 미리 3차원 배열에 도형 만들어두기.(모서리가 항상 좌측 상단)
*/




import java.util.*;
import java.io.*;

public class Tromino {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader
        (System.in));

        int[] dx1 = {-1,-1,0,1,0,-1};
        int[] dy1 = {0,0,1,0,-1,0};
        int[] dx2 = {0,0,1,0,0,1};
        int[] dy2 = {-1,1,0,-1,1,0};

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]); // 행
        int M = Integer.parseInt(str[1]); // 열

        int[][] graph = new int[N][M];
        for (int i=0;i<N;i++){
            str = br.readLine().split(" ");
            for (int j=0; j<M;j++){
                graph[i][j] = Integer.parseInt(str[j]);
            }
        }

        int answer = 0;
        for (int x=0; x<N; x++){
            for (int y=0; y<M; y++){
                int cur = graph[x][y];
                for (int k=0; k<6;k++){
                    int nx1 = x + dx1[k];
                    int ny1 = y + dy1[k];
                    int nx2 = x + dx2[k];
                    int ny2 = y + dy2[k];
                    if (nx1 > -1 && nx1 < N && nx2 > -1 && nx2 < N
                    && ny1 > -1 && ny1 < M && ny2 > -1 && ny2 < M){
                        int sum = cur + graph[nx1][ny1] + graph[nx2][ny2];
                        answer = Math.max(answer, sum);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}