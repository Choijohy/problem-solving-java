package 다이나믹프로그래밍;
/*
문제: 동전 교환
카테고리: dp
기타:
    접근 방식(목표 금액 15, 동전 종류: 1,2,5 일때)
    0 ~ 15까지의 배열 생성
    1로 만드는 경우 필요한 동전 수 -> 0, 1, 2, 3, 4, 5, ... , 15
    1+2로 만드는 경우 필요한 동전 수 -> 2를 추가하여 j라는 금액을 만들려고 할때, j-2의 값을 조회 (=2를 사용하기 전까지 필요한 동전수)하여, 거기에 +1

*/
import java.util.*;

public class CoinExchange {
    // 오답 풀이 -> greedy로 접근 하면 안됨(반례: 1 4 6으로 8 만들기)
    public static int solutionDeprecated(int n, int[] types, int target){
        Arrays.sort(types);
        int result = 0;
        for (int i=types.length -1; i > -1; i--){
            while(target >= types[i]){
                target -= types[i];
                result ++;
            }
            if(target == 0) return result;
        }
        return -1;
    }

    // 정답 풀이 -> dp로 접근 
    public static int solution(int n, int[] types, int target){
//        Arrays.sort(types);
        int[] dp = new int[target+1];
        Arrays.fill(dp, Integer.MAX_VALUE-100);
        dp[0] = 0;


        // 동전 종류마다 반복
        for (int i=0; i<n; i++){
            int coin= types[i]; // 코인 종류
            for (int j = coin; j <= target; j++){
                dp[j] = Math.min(dp[j], dp[j-coin] + 1);
            }
        }

        return dp[target];
    }



  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    int n = in.nextInt();
    int[] types = new int[n];
    for (int i=0; i<n;i++){
    	types[i] = in.nextInt();
    }
    int target = in.nextInt();
    System.out.println(solution(n, types, target));
    return ;
  }
}
