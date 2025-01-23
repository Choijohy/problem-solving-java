package 깊이우선탐색;

import java.util.*;
import java.io.*;

public class Subset {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] s = br.readLine().split(" ");
    int total = 0;
    for (int i=0; i<n;i++){
    	arr[i] = Integer.parseInt(s[i]);
    	total += arr[i];
    }
    Solution solution = new Solution(total, arr);
    //bw.write(solution.solution(n));
    System.out.println(solution.solution(n));
      bw.flush();


    br.close();
    bw.close();
    return ;
  }
}


class Solution{
    int total;
    int[] arr;
    String answer = "NO";
    boolean flag = false;

    public Solution(int total, int[] arr){
        this.arr = arr;
        this.total = total;
    }

	public String solution(int n){
 		int depth = 0;
         int sum = 0;
        dfs(n, new int[]{depth,sum});
        return answer;
    }
  	public void dfs(int n, int[] node){
      if (flag) return;

      int depth = node[0];
      int sum = node[1];
      if(sum > total/2) return;
      // 합이 같은 부분집합인가?
      if(depth == n){
      	if(sum == (total-sum)) {
      		flag = true;
        	answer = "YES";
      	}
      }
      else{
        depth ++;
        dfs(n,new int[]{depth, sum});
        dfs(n,new int[]{depth, sum + arr[depth-1]});
      }
    }
}

