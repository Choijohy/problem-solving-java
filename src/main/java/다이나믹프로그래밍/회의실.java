package 다이나믹프로그래밍;

import java.util.*;
import java.io.*;

public class 회의실 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    List<Meeting> list = new ArrayList<>();

    for (int i=0; i<n; i++){
      	String[] str = br.readLine().split(" ");
    	list.add(new Meeting(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
    }
    Collections.sort(list); // 1차 정렬: 시작시간 오름차순 , 2차 정렬: 종료시간 오름차순

    Solution_회의실 solution = new Solution_회의실(n, list);
    bw.append(String.valueOf(solution.solution()));
    br.close();
    bw.flush();
    bw.close();
    return ;
  }
}

class Meeting implements Comparable<Meeting>{
	int start;
  	int finish;

  	Meeting(int start, int finish){
    	this.start = start;
      	this.finish = finish;
    }

  	@Override
  	public int compareTo(Meeting o){
    	if (this.start > o.start) return 1;
      	else if (this.start == o.start){
        	if (this.finish > o.finish) return 1;
          	else if (this.finish < o.finish) return -1;
          	else return 0;
        }
      	else return -1;
    }
}

class Solution_회의실 {
	int[] dp;
  	int answer = 1;
  	int n;
  	List<Meeting> list;

  	Solution_회의실(int n, List<Meeting> list){
    	this.n = n;
      	this.list = list;
      	dp = new int[n];
    }

  	public int solution(){
    	dp[0] = 1;

    	// 수업 선택지를 하나씩 추가
    	for (int i=1; i<n; i++){
          	Meeting current = list.get(i);
        	int max = 0;
          	for (int j=0; j<i;j++){
              	Meeting prev = list.get(j);
            	if (prev.finish <= current.start && dp[j] > max){ // 현재 회의 이전에 끝나는 회의들
					if (prev.start != current.start || prev.finish != current.finish) // 동시간대 회의 제외
						max = dp[j];
				}
            }
          	dp[i] = max + 1;
          	answer = Math.max(answer, dp[i]);
        }
      	return answer;
    }
}