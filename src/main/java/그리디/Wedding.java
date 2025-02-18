package 그리디;

import java.util.*;
import java.io.*;

public class Wedding {
  public static int solution(List<TimeLine> timeLine){
  	int answer = 0;
    int count = 0;

    for (TimeLine x: timeLine){
    	if (x.type == 's') count ++;
        else count --;
      	answer = Math.max(count, answer);
    }
    return answer;
  }
  public static void main(String[] args) throws IOException{
   	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    List<TimeLine> timeLine = new ArrayList<>();
    for (int i=0; i<n; i++){
    	String[] temp = br.readLine().split(" ");
      	timeLine.add(new TimeLine(Integer.parseInt(temp[0]), 's'));
        timeLine.add(new TimeLine(Integer.parseInt(temp[1]), 'e'));
    }

    Collections.sort(timeLine);
    System.out.println(solution(timeLine));
    return ;
  }
}

class TimeLine implements Comparable<TimeLine>{
	int time;
  	char type;

  	TimeLine(int time, char type){
    	this.time = time;
      	this.type = type;
    }

  	@Override
  	public int compareTo(TimeLine o){
    	if (this.time > o.time) return 1;
      	else if (this.time < o. time) return -1;
      	else {
        	if (this.type > o.type) return 1;
          	else if (this.type < o.type) return -1;
          	else return 0;
        }
    }
}