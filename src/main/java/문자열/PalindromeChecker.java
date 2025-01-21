package 문자열;

import java.util.*;

public class PalindromeChecker {
    public static boolean solution(String word){
    char[] chars = word.toCharArray(); // ["g","o","i","o","d"]
    int lt = 0;
    int rt = word.length() -1;

    while(lt < rt){
    	if (Character.toUpperCase(chars[lt]) != Character.toUpperCase(chars[rt])) return false;
		lt ++;
      	rt --;
    }
    return true;
  }

  // StringBuilder를 활용한 풀이
  public static boolean solution2(String word){
        String sb = new StringBuilder(word).reverse().toString();
        if (sb.equalsIgnoreCase(word)) return true;
        else return false;
  }
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String word = in.next();
    boolean result = solution(word);
    if (result) System.out.println("YES");
    else System.out.println("NO");
  }

}
