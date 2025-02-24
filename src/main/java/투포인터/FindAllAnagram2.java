package 투포인터;

import java.util.*;
import java.io.*;

public class FindAllAnagram2 {
  public static void main(String[] args) throws IOException{
   	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String S = br.readLine();
    String T = br.readLine();

    HashMap<Character, Integer> mapAnswer = new HashMap<>(); // 정답용
    HashMap<Character, Integer> mapTemp = new HashMap<>(); // 비교용

   	for (char c: T.toCharArray()){
    	mapAnswer.put(c, mapAnswer.getOrDefault(c,0)+1);
    }

    int lt = 0;
    int rt = lt+T.length()-1;
    for (int i=0; i<T.length()-1; i++){
    	char c = S.charAt(i);
      	mapTemp.put(c, mapTemp.getOrDefault(c,0)+1);
    }

    int answer = 0;
    for (int i=rt; i<S.length(); i++){
    	char c = S.charAt(i);
      	mapTemp.put(c, mapTemp.getOrDefault(c,0)+1);

        if (mapAnswer.equals(mapTemp)) answer++;

        char old = S.charAt(lt);
        mapTemp.put(old, mapTemp.get(old)-1);
        if (mapTemp.get(old) == 0) mapTemp.remove(old);
        lt ++;
    }
    System.out.println(answer);
  }
}