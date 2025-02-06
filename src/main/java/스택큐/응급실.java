package 스택큐;
/*
문제: 우선순위에 따라 치료 받을 환자 정하기
카테고리: 우선순위 큐

* */
import java.util.*;
import java.io.*;

public class 응급실 {
  public static int solution(int n, int m, int[] wait, PriorityQueue<Integer> pq){
  	int i =0;
    int count = 0;
    while (true){
    	if (wait[i] == pq.peek()){ // 치료
          if(i == m) return count+1;

          count ++;
          pq.poll();
          wait[i] = -1; // 치료 완료
        }
    	if (i == n-1) i =0;
      	else i ++;
    }
  }
  public static void main(String[] args) throws IOException{
   	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  	String[] str = br.readLine().split(" ");
  	int n = Integer.parseInt(str[0]);
  	int m = Integer.parseInt(str[1]);

  	int[] wait = new int[n];
  	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

  	int i = 0;
  	for (String x: br.readLine().split(" ")){
    	int temp = Integer.parseInt(x);
      	wait[i] = temp;
      	pq.offer(temp);
      	i++;
    }

  	System.out.println(solution(n,m, wait, pq));
  return ;
  }
}