package 완전탐색;
import java.util.*;
import java.io.*;
/*
문제: 금 채굴하기
유형: 완전 탐색
공부:
    - 또 틀린 부분
    1) 마름모 dx,dy테크닉으로 구하는법
    2) 영역 밖으로 넘어갈 수 있다고 할때, 최대 마름모의 거리(k) = 2*(n-1)
*/

public class GoldMining2 {
    static int n;
    static int m;
    static int[][] grid;
    static int[] dx = {1,1,-1,-1};
    static int[] dy = {-1,1,1,-1};

    private static int goldCount(int sx, int sy, int k){
        if (k==0) return grid[sx][sy];
        int count = 0;
        if (grid[sx][sy]==1) count ++;


        //System.out.println("x: "+x+" y: "+y+ " k:"+k);
        for (int curK=1;curK<=k;curK++){
            // 마름모의 맨 꼭대기 출발점
            int x = sx - curK;
            int y = sy;
            for (int i=0;i<4;i++){
                for (int j=1; j<=curK; j++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx>-1 && nx <n && ny>-1 && ny<n && grid[nx][ny]==1){
                        count++;
                    }
                    x = nx;
                    y = ny;
                }
            }
        }

        return count;
    }

    private static int solution(){
        int answer = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                for (int k=0;k<=2*(n-1);k++){
                    int count = goldCount(i,j,k);
                    int cost = ((int)Math.pow(k,2) + (int)Math.pow(k+1,2));
                    int income = count*m - cost;

                    if (income >= 0){
                        //System.out.println("i: "+i+" j: "+j+" k: "+k);
                        //System.out.println("income: "+income+" cost: "+ cost+ " count: "+count);
                        answer = Math.max(answer, count);
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in
        ));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        grid = new int[n][n];

        for (int i = 0; i < n; i++){
            str = br.readLine().split(" ");
            for (int j = 0; j < n; j++){
                grid[i][j] = Integer.parseInt(str[j]);
            }
        }
        System.out.println(solution());
    }
}