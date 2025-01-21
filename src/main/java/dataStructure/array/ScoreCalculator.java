package dataStructure.array;

import java.util.*;

public class ScoreCalculator {
    public static int solution(int[] scores){
  	int total = 0;
    int temp = 0;
    if (scores[0] == 1) {
        temp++;
        total++;
    }

    for (int i=1; i<scores.length;i++){
    	if (scores[i] == 1){
        	if (scores[i-1] == 1) {temp ++;}
          	else {temp = 1;}
            total += temp;
        }
    }

    return total;
  }
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    int size = in.nextInt();
    int[] scores = new int[size];
    for (int i=0; i<size; i++){
    	scores[i] = in.nextInt();
    }
    System.out.println(solution(scores));
    return ;
  }
}
