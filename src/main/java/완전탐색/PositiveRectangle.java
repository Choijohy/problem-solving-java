package 완전탐색;

/*
* 문제: 최대 양수 사각형
* 유형: 완전 탐색
* 공부:
*   - 테스트 케이스
*       1) 엣지 케이스(n=1, m=1)
*       2) 양 끝이 정답이 되는 겅유
* */
import java.util.*;
import java.io.*;

public class PositiveRectangle {
    static int n, m;
    static int[][] grid;
    static int answer = -1;

    private static int checkifPositive(int startX, int startY, int endX, int endY){
        for (int x = startX; x <=endX ; x++){
            for (int y = startY; y<=endY; y++){
                if (grid[x][y] <= 0)
                    return -1;
            }
        }
        //System.out.println("(x1,y1): "+startX+","+startY+"(x2,y2): "+endX+","+endY);
        //System.out.println("넓이: "+(endX - startX +1) * (endY - startY +1));
        return (endX - startX +1) * (endY - startY +1);
    }

    private static void makeAllRectangles(int startX, int startY){
        for (int endX = startX; endX < n; endX++ ){
            for (int endY = startY; endY < m; endY++){
                answer = Math.max(answer, checkifPositive(startX, startY, endX, endY));
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 행
        m = Integer.parseInt(st.nextToken()); // 열
        grid = new int[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }
        // 격자내의 모든 지점이 각각 좌측 상단 모서리일 경우 완전 탐색
        for (int i=0; i<n; i++){
            for (int j=0; j<m;j++){
                makeAllRectangles(i,j);
            }
        }
        System.out.println(answer);
        br.close();
    }
}
