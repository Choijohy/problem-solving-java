package 투포인터;

import java.util.*;
import java.io.*;

public class FindAllAnagram {
  public static int solution(char[] s, char[] t){
  	HashMap<Character, Integer> map1 = new HashMap<>();
    HashMap<Character, Integer> map2 = new HashMap<>();

    int answer = 0;

    for(int i=0; i<t.length;i++){
        map1.put(t[i], map1.getOrDefault(t[i],0)+1);
    	map2.put(s[i], map2.getOrDefault(s[i],0)+1);
    }

    if (map1.equals(map2)) answer++; // 첫번째 부분 문자열에 대한 결과

    int lt = 0;
    int rt = t.length-1;

    while(rt < s.length -1){
        // lt 증가시킴으로써, 부분문자열에서 빠질 문자
      	map2.put(s[lt], map2.getOrDefault(s[lt],0)-1);
        if (map2.get(s[lt]) == 0) {map2.remove(s[lt]);}
      	lt ++;

        // rt 증가시킴으로써, 부분문자열에 새롭게 추가될 문자
      	rt++;
      	map2.put(s[rt], map2.getOrDefault(s[rt],0)+1);
     	if (map1.equals(map2)) {answer ++;}
    }
    return answer;
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] s = br.readLine().toCharArray();
    char[] t = br.readLine().toCharArray();

    System.out.println(solution(s,t));

    return ;
  }
}