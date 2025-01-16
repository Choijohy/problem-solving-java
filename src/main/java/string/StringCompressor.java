package string;

import java.util.*;

public class StringCompressor {
    public static String solution(String str){
  	StringBuilder sb = new StringBuilder();

    char prior = str.charAt(0);
    int count = 0;
    for (char c: str.toCharArray()){
    	if (prior == c) count ++;
      	else {
          	if (count == 1) {
                  sb.append(prior);
            }
        	else {
                sb.append(prior).append(Character.forDigit(count,10));
            }
          	prior = c;
          	count = 1;
        }
    }

    // 마지막 문자 처리
    if (count ==1) sb.append(prior);
    else sb.append(prior).append(Character.forDigit(count,10));

    return sb.toString();
  }
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String str = in.nextLine();
    System.out.println(solution(str));
  }
}
