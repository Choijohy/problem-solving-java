package 스택큐;

import java.util.*;
import java.io.*;

public class MaximumIncome {
  public static int solution(int n, List<Lecture> arr){
    int answer = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    int dmax = arr.get(0).day;
    int j = 0; // j값을 계속 기억하도록 밖에서 초기화
    for (int i=dmax; i>0; i--){
        for (; j<n;j++){
            if(arr.get(j).day < i) break;
            pq.offer(arr.get(j).pay);
        }
        if (!pq.isEmpty()) answer += pq.poll();
        if (j == n-1) break;
    }


    return answer;

  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    List<Lecture> arr = new ArrayList<>();
    for (int i=0; i<n; i++){
    	String[] str = br.readLine().split(" ");
        arr.add(new Lecture(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
    }
    Collections.sort(arr);
    System.out.println(solution(n, arr));
    return ;
  }
}

class Lecture implements Comparable<Lecture>{
	int pay;
  	int day;

  	Lecture(int pay, int day){
      this.pay = pay;
      this.day = day;
    }

  	@Override
  	public int compareTo(Lecture o){
          return o.day - this.day; // 내림차순
    }
}