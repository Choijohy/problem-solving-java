package 다이나믹프로그래밍;

import java.util.*;
import java.io.*;
/*
문제: 배낭 채우기
유형: dp
공부:
    - 테스트케이스
        1) w=m일때가 최대 가치가 아닐때(m보다 적은 무게를 담았지만, 더 최대가치일때)
    - dp 갱신 -> 같은 턴에서 갱신한 값을 또 재사용해서 틀림.
    - 실수 많았던 풀이
*/
public class 배낭_채우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] w = new int[n+1];
        int[] v = new int[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
        // dp[i]: 무게가 i 일때, 최대 value
        int[][] dp = new int[n+1][10001];

        // 아이템을 하나씩 더해가면서 dp 갱신
        for (int i=1; i<=n;i++){
            int weight = w[i];
            int value = v[i];
            for (int j=0; j<=m;j++){
                // if(dp[i-1][j] > 0 && j+weight <=m){
                        // 기존에 쌓은 짐이 있는 경우(value >0) 거기에 현재 아이템을 추가한다
                //     dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                //     dp[i][j+weight] = Math.max(dp[i-1][j+weight], dp[i-1][j]+value);
                //     System.out.println("i: "+i+" j: "+j+" -> dp "+dp[i][j]);
                //     System.out.println("i: "+i+" j+weight: "+(j+weight)+" -> dp "+dp[i][j+weight]);
                // }
                    // 현재 아이템과 동일한 무게일때, 현재 아이템 vs 다른 아이템 조합 중에 선택한다.
                // if (weight == j) {
                //     dp[i][j] = Math.max(dp[i-1][j],value);
                //     System.out.println("i: "+i+" j: "+j+" -> dp "+dp[i][j]);
                // }

                // j >= weight[i]인 경우에는 Case 1, Case 2 중 더 좋은 값을 선택합니다.
                if(j >= w[i])
                    dp[i][j] = Math.max(dp[i - 1][j - weight] + valaue, dp[i - 1][j]);

                // j < weight[i]인 경우에는, Case 2만 가능합니다.
                else
                    dp[i][j] = dp[i - 1][j];

            }
        }

        int answer = 0;
        for (int i=0; i<=m; i++){
            answer = Math.max(answer, dp[n][i]);
        }
        System.out.println(answer);
    }
}