package 그리디;
/*
문제: 회의실 배정
유형: 그리디
공부:
    - 전형적인 그리디. 빨리 끝나는 것 부터 선택한다.
    - 요구사항 파악 미흡. (T,T) 미팅이 여러개라면 모두 포함되어야 한다. T시간까지 사용했다고 했을때, T시간부터 시작하는 미팅은 포함하도록 로직이 전개되므로.
*/
import java.util.*;
import java.io.*;

public class MeetingRoom {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    List<Meeting> list = new ArrayList<>();

    for (int i=0; i<n; i++){
      	String[] str = br.readLine().split(" ");
    	list.add(new Meeting(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
    }
    Collections.sort(list);

    Solution_MeetingRoom solution = new Solution_MeetingRoom(n, list);
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
  	public int compareTo(Meeting o){ // 1차 정렬: 종료 시간 오름차순(빨리 끝나는 순) 2차 정렬: 시작 시작 오름차순(빨리 시작하는 순)
    	if (this.finish > o.finish) return 1;
      	else if (this.finish == o.finish){
        	if (this.start > o.start) return 1;
          	else if (this.start < o.start) return -1;
          	else return 0;
        }
      	else return -1;
    }
}

class Solution_MeetingRoom {
	int n;
  	List<Meeting> meetings;
  	int answer = 0;

      Solution_MeetingRoom(int n, List<Meeting> list){
          this.n = n;
          this.meetings = list;
      }

	public int solution(){
  		Meeting prev = new Meeting(-1,-1);
      	for (Meeting x: meetings){
        	if (prev.finish <= x.start){
                	answer ++;
                    prev = x;
            }
        }
    	return answer;
    }

}