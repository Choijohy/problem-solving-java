package 문자열;
/*
문제: 중복 제거
카테고리: 문자열
기타:
    - StingBuilder 사용시, String 연산에서 불필요한 String 객체 생성을 줄일 수 있음
    - "중복 제거" -> Hash라는 자료구조로 보통 해결되지만, 그 이외의 방법도 있을 수 있다는거!!(indexOf()를 활용한 풀이)
*/

import java.util.*;

public class RemoveDuplication {
  public static String solution(String word){
  	char[] chars = word.toCharArray();

    HashSet<Character> set = new HashSet<>();
    StringBuilder sb = new StringBuilder();

    for(char c:chars){
    	if (!set.contains(c)){
        	set.add(c);
          	sb.append(c);
        }
    }

    return sb.toString();
  }

  // 다른 풀이 - indexOf
    public static String solution2(String word){
      StringBuilder sb = new StringBuilder();

      for (int i=0; i< word.length(); i++){
          char current = word.charAt(i);
          if (i == word.indexOf(current)) sb.append(current);
      }
      return sb.toString();
    }

  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
   	String word = in.next();
    System.out.println(solution(word));
  }
}
