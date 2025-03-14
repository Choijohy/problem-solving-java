package 완전탐색;
/*
* 문제: 금 채굴하기[Medium]
* 유형: 완전 탐색
* 공부:
*   - 테스트케이스
*       1) N = 1
*       2) M = 1
*       3) K = 0
*       4) 모든 그리드가 포함되어야 정답이 되는 경우
*       5) 어떤 금도 채굴되면 안되는 경우
*   - K 범위에 따라 마름모 범위 탐색 방법(기본적으로 모든 격자는 거리 k내의 값들)
* */
import java.util.*;
import java.io.*;

public class GoldMining {
    static int n;
    static int m;
    static int[][] grid;

    // 접근 1: 모든 격자를 순회하면서, K 범위 안에 드는지 확인
    // public static int countGold(int k, int x, int y){
    //     int count = 0;
    //     for (int i=0; i<n; i++){
    //         for (int j=0; j<n;j++){
    //             if ((Math.abs(x-i)+Math.abs(y-j)) <= k && grid[i][j] == 1)
    //                 count ++;
    //         }
    //     }
    //     return count;
    // }

    // 접근 2: 중심점에 대해 마름모 영역만 계산하여 확인하기(dx, dy 활용)
    // public static int countGold(int k, int row, int col){
    //     int count = 0;
    //     // k =0
    //     count += grid[row][col];

    //     int[] dx = {-1,-1,1,1};
    //     int[] dy = {1,-1,-1,1};

    //     // k=1 ~ k
    //     // 출발점 -> x, y-k
    //     for (int curK = 1; curK <= k; curK++){
    //         int x = row + curK;
    //         int y = col;
    //         for (int i=0; i<4; i++){
    //             for (int step =0; step < curK; step++){

    //                 int nx = x + dx[i];
    //                 int ny = y + dy[i];

    //                 if (nx>-1 && nx < n && ny >-1 && ny<n){

    //                     count += grid[nx][ny];
    //                 }
    //                 x = nx;
    //                 y = ny;
    //             }
    //         }
    //     }
    //     return count;

    // }

    // 접근 3: 중심점이 주어질때, 마름모 영역만 계산 + 값 재사용
    public static int countGold(int k, int row, int col){
        int[] dx = {-1,-1,1,1};
        int[] dy = {1,-1,-1,1};
        int x = row + k; // 시작행
        int y = col; // 시작열
        int count = 0;

        if (k==0){
            return grid[row][col];
        }

        for (int i=0; i<4; i++){
            for (int step=0; step<k;step++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx>-1 && nx<n && ny>-1 && ny<n){
                    count += grid[nx][ny];
                }
                x = nx;
                y = ny;
            }
        }
        return count;
    }

    public static int solution(){
        int answer = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                int gold = 0;
                for (int k=0; k<= 2*(n-1); k++){
                    int cost = k*k+(k+1)*(k+1); // Math.pow() -> double
                    gold += countGold(k, i, j); // 금의 개수
                    int temp = gold*m - cost;
                    if (temp >= 0){
                        answer = Math.max(answer, gold);
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