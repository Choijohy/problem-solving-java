package string;
import java.util.*;

public class DecodeString {
    public static String solution(int num, String str){
  	char[] codes = new char[num];
    for (int i=0; i<num; i++){
    	char code = decodeString(str.substring(7*i, 7*i+7));
        codes[i] = code;
    }
    return String.valueOf(codes);
  }
  public static char decodeString(String str){
  	int value = 0;
    for (int i=0; i < 7; i++){
      if (str.charAt(6-i) == '#') value = value + (int)Math.pow(2,i);
    }
    return (char) value;
  }

  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    int num = in.nextInt();
    String str = in.next();
    System.out.println(solution(num, str));
  }
}
