package dp;
/*
문제: LIS
알고리즘: dp
기타:
    - num = {1,5,7,3,4,8}
    - dp[]에서 저장하는 값은 nums에서 i번째에 해당하는 값(ex. i=1이라면, 5)을 마지막 항으로 했을때 부분 수열의 길이
    - i번째 이전의 숫자 중에서 i번째 해당값 보다 작고 + dp가 최대인 값을 구하고, 거기에 +1을 한다.
    - 최종적으로 dp[]중에 최댓값을 반환하면 된다.
    * 이분탐색으로 더 빠르게 (O(NlogN)) 풀이 가능
*/

import java.util.*;

public class Lis {
    public static int solution(int size, int[] nums){
  	int[] dp = new int[size];
    dp[0] = 1;

    for (int i=1;i<size;i++){
      	int temp = 0;
    	for (int j=i-1; j > -1; j--){
        	if (nums[j] < nums[i]) temp = Math.max(temp, dp[j]);
        }
      	dp[i] = temp + 1;
    }
    int result = 0;
    for (int i=0;i<size;i++){
    	result = Math.max(result, dp[i]);
    }
    return result;
  }
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    int size = in.nextInt();
    int[] nums = new int[size];
    for (int i=0; i<size;i++){
    	nums[i] = in.nextInt();
    }
    System.out.println(solution(size, nums));
    return ;
  }
}
