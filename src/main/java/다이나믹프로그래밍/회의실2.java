package 다이나믹프로그래밍;

import java.util.*;
import java.io.*;

public class 회의실2 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    List<Meeting2> list = new ArrayList<>();

    for (int i=0; i<n; i++){
      	String[] str = br.readLine().split(" ");
    	list.add(new Meeting2(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
    }
    Collections.sort(list);

    Solution_회의실2 solution = new Solution_회의실2(n, list);
    bw.append(String.valueOf(solution.solution()));
    br.close();
    bw.flush();
    bw.close();
    return ;
  }
}

class Meeting2 implements Comparable<Meeting2>{
	int start;
  	int finish;

  	Meeting2(int start, int finish){
    	this.start = start;
      	this.finish = finish;
    }

  	@Override
  	public int compareTo(Meeting2 o){ // 1차 정렬: 종료 시간 오름차순(빨리 끝나는 순) 2차 정렬: 시작 시작 오름차순(빨리 시작하는 순)
    	if (this.finish > o.finish) return 1;
      	else if (this.finish == o.finish){
        	if (this.start > o.start) return 1;
          	else if (this.start < o.start) return -1;
          	else return 0;
        }
      	else return -1;
    }
}

class Solution_회의실2{
	int n;
  	List<Meeting2> list;
  	int answer = 0;

      Solution_회의실2(int n, List<Meeting2> list){
          this.n = n;
          this.list = list;
      }
	public int solution(){
  		Meeting2 prev = new Meeting2(-1,-1);
      	for (Meeting2 x: list){
        	if (prev.finish <= x.start){
            	if (prev.start != x.start || prev.finish != x.finish){
                	answer ++;
                    prev = x;
                }
            }
        }
    	return answer;
    }

}