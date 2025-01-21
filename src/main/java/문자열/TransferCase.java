package 문자열;

import java.util.*;

/*
* 문제: 대소문자 변환
* 카테고리: 문자열
* 기타:
*   - Character 클래스에서 제공하는 메서드 활용
*   - Ascii number로도 풀이가능(대문자: 65 ~ 90 / 소문자: 97 ~ 122)
*       if (x>=65 && x<= 90) answer+= (char)(x-32)
*
*/

public class TransferCase {

    public static String solution(String str){
        String answer = "";
        for (char x: str.toCharArray()){
            if(Character.isUpperCase(x)) answer += Character.toLowerCase(x);
            else answer += Character.toUpperCase(x);
        }
        return answer;
    }

    public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String str = in.nextLine();
    System.out.println(solution(str));
    }
}
