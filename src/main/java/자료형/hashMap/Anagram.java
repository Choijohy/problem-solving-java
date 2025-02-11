package 자료형.hashMap;

import java.util.*;
import java.io.*;

public class Anagram {

  public static void main(String[] args) throws IOException{
   	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    HashMap<Character, Integer> map = new HashMap<>();
    String s1 = br.readLine();
    String s2 = br.readLine();

    for (char x: s1.toCharArray()){
    	map.put(x, map.getOrDefault(x, 0)+1);
    }

    for (char x: s2.toCharArray()){
        if (!map.containsKey(x) || map.get(x) == 0) {
            System.out.println("NO");
            return;
        }
        map.put(x,map.get(x)-1);
    }

    System.out.println("YES");
    return ;
  }
}