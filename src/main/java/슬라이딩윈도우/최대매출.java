package 슬라이딩윈도우;

import java.util.*;
import java.io.*;

public class 최대매출 {
  public static int solution(int n, int k, int[] sales){
  	int lt = 0, rt = k-1;
    int sum =0;
    for (int i=0;i<=rt;i++){
    	sum += sales[i];
    }
    int maxValue = sum;

    while (rt < n-1){
    	sum -= sales[lt];
      	lt ++;
      	rt ++;
      	sum += sales[rt];
    	maxValue = Math.max(maxValue, sum);
    }
    return maxValue;
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s1 = br.readLine().split(" ");
    int n = Integer.parseInt(s1[0]);
    int k = Integer.parseInt(s1[1]);

    int[] sales = new int[n];
    String[] s2 = br.readLine().split(" ");
    for (int i=0; i<n; i++){
    	sales[i] = Integer.parseInt(s2[i]);
    }
    System.out.println(solution(n, k, sales));
    return ;
  }
}