package string;

import java.util.*;
/*
* 문제: 가장 긴 단어 찾기
* 카테고리: 문자열
* 기타:
*   - indexOf(), substring()을 통해 풀이할 수도 있음
*   - indexOf(" ") -> 처음으로 " "(띄어쓰기)가 발견된 곳의 인덱스
*   - substring(a,b) -> 문자열의 a ~ b-1 인덱스까지의 문자 추출
*/

public class LongestString {
    public static String solution1(String str){
  	    String answer = "";
        String[] strArray = str.split(" ");
        for (String x: strArray){
    	    if (answer.length() < x.length()){
        	    answer = x;
            }
        }
        return answer;
    }

    public static String solution2(String str){
        String answer = "";
        int pos;
        while((pos = str.indexOf(" ")) != -1){
            String tmp = str.substring(0, pos);
            if (tmp.length() > answer.length()){
                answer = tmp;
            }
            str = str.substring(pos+1);
        }

        if (str.length() > answer.length()) answer = str;
        return answer;
    }
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String str = in.nextLine();
    System.out.println(solution2(str));
  }
}
