package string;
import java.util.Scanner;
/*
* 문제: 문자 찾기
* 카테고리: 문자열
* 기타:
*   1. String은 대소문자 무관하게 동일여부를 판단할 수 있는 메서드가 있음. str.equalsIgnoreCase(str2)
*   2. char는 위와 같은 메서드가 없음. 또한 equals()를 통해 내용의 동일 여부를 비교하는 String 타입과 다르게, '=='연산자로 비교
*   3. str.toCharArray()-> 문자열을 문자로 구성된 배열로 변환  --> 향상된 for문으로 풀이 가능(String 자체는 루프에서 직접 순회x)
*
*/
public class FindSameString {
  public static int solution1 (String str, char c){
  	int count =  0;
    for (int i=0; i<str.length(); i++){
      if (Character.toLowerCase(str.charAt(i)) == Character.toLowerCase(c)) count ++;
    }
    return count;
  }

  public static int solution2 (String str, char c){
  	int count =  0;
    for (char x:str.toCharArray()){
      if (Character.toLowerCase(x) == Character.toLowerCase(c)) count ++;
    }
    return count;
  }

  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String input = in.nextLine();
    char c = in.nextLine().charAt(0); // 입력받은 문자열에서 문자 한 개 추
    System.out.println(solution1(input, c));
  }
}
