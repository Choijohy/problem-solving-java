package 다이나믹프로그래밍;

import java.util.*;
import java.io.*;


public class 벽돌쌓기 {
  public static int solution(int n, ArrayList<Brick> arr){
  	Collections.sort(arr);
    int[] dp = new int[n]; // n번째 벽돌까지 사용했을 때, 최대 탑의 높이 (0번째 벽돌까지의 최대 높이 = dp 인덱스 0)
    dp[0] = arr.get(0).h;

    int answer = dp[0];
    // 넓이가 증가하는 순서로 벽돌 추가
    for (int i=1; i<n;i++){
    	int maxValue = 0;
      	Brick current = arr.get(i);
      	// 현재 벽돌 위에 쌓을 수 있는 벽돌 세트 중, 최대 탑 높이를 가진 세트
      	for (int j=0;j<i;j++){
        	Brick prior = arr.get(j);
          	if (prior.w < current.w && dp[j] > maxValue) maxValue = dp[j];
        }
      	dp[i] = maxValue + current.h;
      	answer = Math.max(answer, dp[i]);
    }
    return answer;

  }
  public static void main(String[] args) throws IOException{
   	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  	int n = Integer.parseInt(br.readLine());

    ArrayList<Brick> arr = new ArrayList<>();
    for (int i=0; i<n; i++){
    	String[] str = br.readLine().split(" ");
      	int s = Integer.parseInt(str[0]);
        int h = Integer.parseInt(str[1]);
        int w = Integer.parseInt(str[2]);
      	arr.add(new Brick(s,h,w));
    }
    System.out.println(solution(n, arr));
    return ;
  }
}

class Brick implements Comparable<Brick>{
	int s;
  	int h;
  	int w;

  	Brick(int s, int h, int w){
    	this.s = s;
      	this.h = h;
    	this.w = w;
    }

  	@Override
  	public int compareTo(Brick o){ // 밑면 넓이 기준으로 오름차순 정렬
    	return this.s - o.s;
    }
}