package 스택큐;

import java.util.*;
import java.io.*;

public class 공주구하기 {
  public static int solution(int n, int k){
  	Queue<Integer> queue = new ArrayDeque<>();
    for (int i=1; i<n+1;i++){
    	queue.offer(i);
    }

    int num = 1;
    while (queue.size() > 1){
    	int temp = queue.poll();
      	if (num != k){
        	queue.offer(temp);
        	num++;
        }else{
        	num = 1;
        }
    }
    return queue.poll();
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int n = Integer.parseInt(s[0]);
    int k = Integer.parseInt(s[1]);

    System.out.println(solution(n,k));
    return ;
  }
}