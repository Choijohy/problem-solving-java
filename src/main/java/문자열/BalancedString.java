package 문자열;

import java.util.*;
import java.io.*;
public class BalancedString {

    public static String solution(String str){

        StringBuilder sb = new StringBuilder();
        char pre = str.charAt(0);
        for (int i=1; i<str.length(); i++){
            char cur = str.charAt(i);

            if (pre == ')' && cur == ')'){
                sb.append(pre);
                if (i == str.length()-1) sb.append(cur);
            }
            else if (pre == ')' && cur == '('){
                sb.append(pre).append('+');
            }
            else if (pre == '(' && cur == '('){
                sb.append(pre);
            }
            else if (pre == '(' && cur == ')'){
                sb.append(pre).append('1');
                if (i == str.length()-1) sb.append(cur);
            }
            pre = cur;
        }
        return sb.toString();


    }
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));
    }
}
