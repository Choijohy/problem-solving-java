package 문자열;

/*
문제: 숫자만 추출
카테고리: 문자열
기타:
    - 수학 공식을 도출해서 풀어보기:
        answer = 0 초기화, answer = answer * 10 + (c-48)
        * ascii코드에서 숫자는 48 ~ 57
    - Integer.parseInt()
        answer = "" 초기화, answer = answer + c (StringBuilder 사용가능) -> Integer.parseInt(answer)
*/
import java.util.*;

public class ExtractNumbers {
    public static String solution(String str){
  	String numbers = str.replaceAll("[^0-9]","");

    while (numbers.charAt(0) == '0'){
    	numbers = numbers.substring(1,numbers.length());
    }

    return numbers;
  }

  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String str = in.nextLine();
    System.out.println(solution(str));
    return ;
  }
}
