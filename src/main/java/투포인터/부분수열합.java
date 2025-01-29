package 투포인터;
/*
문제: 부분수열의 합
카테고리: 투포인터
기타:
    - 투 포인터는 단순히 배열 2개를 쓰는 경우 이외에도, lt & rt를 통해 제어하는 알고리즘도 함께 생각해볼 수 있음
    - 아래 코드는 2N번 최대 실행으로, O(n)
*/
import java.util.*;
import java.io.*;

public class 부분수열합 {
  static int lt, rt = 0;
  static int sum;
  static int[] nums;

  public static void addRight(){
  	rt++;
    sum += nums[rt];
  }
  public static void removeLeft(){
  	sum -= nums[lt];
    lt++;
  }

  public static int solution(int n, int m, int[] arr){
        int count = 0;
        nums = arr;
        sum = nums[0];
        while (rt < n){
            if (sum == m){
                count ++;
                removeLeft();
                if (rt == n -1) break;
                addRight();
            }else if (sum < m){
                if (rt == n -1) break;
                addRight();
            }else {
                removeLeft();
                if (lt > rt) rt++;
            }
        }
        return count;
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s1 = br.readLine().split(" ");
    int n = Integer.parseInt(s1[0]);
    int m = Integer.parseInt(s1[1]);
    int[] nums = new int[n];

    String[] s2 = br.readLine().split(" ");
    for (int i=0; i<n; i++){
    	nums[i] = Integer.parseInt(s2[i]);
    }
    System.out.println(solution(n, m, nums));
    br.close();
    return ;
  }
}