package 깊이우선탐색;
/*
공부:
  1) 반례: 12345
  -> 기존의 오답 풀이는 배열의 i번째 요소를 넣는 경우/안 넣는 경우로 나누어
  dfs(sum+arr[l], l+1);
  dfs(sum, l+1);
  처리했음.
  그리고 각 합들에 대해, set에 넣어 비교함. if(set.contains(sum)) flag = true;
  이런 로직은 {1,3,5},{2,3,4} 가 서로소 집합이 아님에도 동일합부분집합이 있다고 판단함.
  이 문제는 서로소 집합에 대해 풀이해야 하므로, 위와 같은 접근이 아닌 sum == Total -sum 으로 접근
*/
import java.util.*;
import java.io.*;

public class SameSumSubset {
  static int[] arr;
  static HashSet<Integer> set = new HashSet<>();
  static boolean flag = false;
  static int N;
  static int total;
  public static void dfs(int sum, int l) {
    if (flag) return;
    if (l == N) {
      if (total - sum == sum) {
        flag = true;
      }
    }
    else {
        dfs(sum + arr[l], l + 1);
        dfs(sum, l + 1);
    }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    String[] str = br.readLine().split(" ");
    total = 0;
    for (int i=0;i<N; i++){
    	arr[i] = Integer.parseInt(str[i]);
        total += arr[i];
    }
    dfs(0,0);
    if (flag) System.out.println("YES");
    else System.out.println("NO");
    return ;
  }
}
