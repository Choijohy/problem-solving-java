package 문자열;

/*
문제: 팰린드롬 검사
카테고리: 문자열
기타:
    - 문자열_객체.replaceAll("[정규식]", 바꿀 문자)
    - 정규식: a-z(소문자)/ A-Z(대문자)/0-9(숫자)/  (공백)/^ (아닌 경우 전부)
*/

import java.util.*;

public class PalindromeChecker2 {
    public static String solution(String str){
        String cleaned = str.replaceAll("[^a-zA-Z]","");
        String reversed = new StringBuilder(cleaned).reverse().toString();
        System.out.println(cleaned);
        System.out.println(reversed);
        if (cleaned.equalsIgnoreCase(reversed)) return "YES";
        else return "NO";
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(solution(str));
    }
}


