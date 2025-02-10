package 슬라이딩윈도우;

import java.util.*;
import java.io.*;

public class ContinuousSum {
  public static int solution(int n){
    int lt = 1;
    int rt = 2;
    int answer = 0;
    while (lt < rt && rt <=n/2+1){
    	int sum = 0;
      	for(int i=lt; i<=rt; i++){
        	sum += i;
        }
      	if (sum < n) rt ++;
      	else if (sum == n){
        	answer ++;
          	lt++;
        }else lt ++;
    }

    return answer;

  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    bw.append(String.valueOf(solution(n)));

    br.close();
    bw.flush();
    bw.close();
    return ;
  }
}