package string;

import java.util.*;

public class GetDistance {
    public static int[] solution(String str, char target){
  	int[] result = new int[str.length()];
    int distance = 1000;

    // 왼쪽에서부터 탐색
    for (int i=0; i< str.length(); i++){
        if (str.charAt(i) == target) distance = 0;
        result[i] = distance;
        distance ++;
    }

    distance = 1000;
    for (int i=str.length()-1; i > -1; i --){
        if (str.charAt(i) == target) distance = 0;
        result[i] = Math.min(result[i], distance);
        distance ++;
    }

    return result;
  }
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String str = in.next();
    String c = in.next();

   	int[] result = solution(str,c.charAt(0));
    for (int i=0; i < result.length; i++) {
      System.out.print(result[i]);
      System.out.print(" ");
    }
    return ;
  }
}
