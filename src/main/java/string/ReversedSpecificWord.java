package string;

import java.util.*;

public class ReversedSpecificWord {
    public static String solution(String word){
        char[] str = word.toCharArray();
        int lt = 0;
        int rt = word.length() -1;

        while (lt < rt){
            if (!Character.isAlphabetic(str[lt])) lt ++;
            else if (!Character.isAlphabetic(str[rt])) rt --;
            else{
                char tmp = str[lt];
                str[lt] = str[rt];
                str[rt] = tmp;
                lt ++;
                rt --;
            }
        }

        return String.valueOf(str);
    }

    public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String word = in.next();
    System.out.println(solution(word));
    return ;
    }
}
