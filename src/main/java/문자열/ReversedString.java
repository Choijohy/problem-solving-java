package 문자열;

import java.util.*;

/*
문제: 문자열 뒤집기
카테고리: 문자열
기타:
    - 문자열 연산이 많이 필요할 때는 StringBuilder객체 혹은 char[]을 활용한 방식 고려
    -> String은 불변객체이므로, String 객체간의 문자열 연산은 계속 새로운 String 객체를 생성함)

    - String.valueOf(char[]) -> char[]요소를 합쳐 String 객체 생성

*/

public class ReversedString {

    public static ArrayList<String> solution(String[] words){
        ArrayList<String> answer = new ArrayList<>();

        for (String word: words){
            char[] str = word.toCharArray();
            int lt = 0;
            int rt = word.length() -1;

            while(lt != rt){
                char tmp = str[lt];
                str[lt] = str[rt];
                str[rt] = tmp;
                lt ++;
                rt --;
            }

            answer.add(String.valueOf(str));
        }
        return answer;
    }

    // tmp연산에서 불필요한 String 객체가 계속 생성됨
    public static String[] solutionDeprecated(int num, String[] words){
        String[] result = new String[num];

        for (int i=0; i<num; i++){
            int strLength = words[i].length();

            String tmp = "";
            for (int j=0; j<strLength; j++){
                tmp = words[i].charAt(j) + tmp;
            }
            result[i] = tmp;
        }
        return result;
    }

    public static void main(String[] args){

        Scanner in=new Scanner(System.in);
        int num = in.nextInt();
        in.nextLine();
        String[] words = new String[num];

        for (int i=0; i<num; i++){
            words[i] = in.nextLine();
        }

        ArrayList<String> result = solution(words);
        for (int i=0; i<num; i++){
            System.out.println(result.get(i));
        }
    }
}
