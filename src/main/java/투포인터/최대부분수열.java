package 투포인터;

import java.util.*;
import java.io.*;

public class 최대부분수열 {
  public static int solution(int n, int k, String[] str){
  	int lt=0;
    int rt = 0;
	int count = 0; // 1로 바꾼 횟수
    int answer = 0;
    while (lt <= rt && rt <= n-1){
      	if (str[rt].equals("0")) {
            count ++;
            while(count > k){
                if (str[lt].equals("0")) count --;
                lt++;
            }
        }

        answer = Math.max(answer, rt-lt+1);
        if (rt != n-1) rt++;
        else break;
    }

    return answer;
  }
  public static void main(String[] args) throws IOException{
   	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] temp = br.readLine().split(" ");
    int n = Integer.parseInt(temp[0]);
    int k = Integer.parseInt(temp[1]);
	String[] str = br.readLine().split(" ");
    System.out.println(solution(n,k,str));

    return ;
  }
}