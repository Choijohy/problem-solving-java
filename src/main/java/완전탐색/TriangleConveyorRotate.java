package 완전탐색;

import java.io.*;
import java.util.*;

public class TriangleConveyorRotate {
    static int n;
    static int[][] convey;

    public static void move(){
        int moveToSecond = convey[0][n-1];
        int moveToThird = convey[1][n-1];
        int moveToFirst = convey[2][n-1];

        // 오른쪽으로 한 칸씩 이동
        for (int i=0; i<3; i++){
            for (int j=n-1; j>=1; j--){
                convey[i][j] = convey[i][j-1];
            }
        }

        convey[0][0] = moveToFirst;
        convey[1][0] = moveToSecond;
        convey[2][0] = moveToThird;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        convey = new int[3][n];

        for (int i=0;i<3; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                convey[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=1; i<=t; i++)
            move();

        for (int i=0;i<3; i++){
            for (int j=0; j<n; j++){
                System.out.print(convey[i][j]+ " ");
            }
            System.out.println();
        }

    }
}
