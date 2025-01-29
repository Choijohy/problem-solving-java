package 자료형.hashMap;

import java.util.*;
import java.io.*;

public class 반장뽑기 {
  public static void main(String[] args) throws IOException{
   	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String s = br.readLine();

    Solution solution = new Solution(s);
    System.out.println(solution.solution());
    return ;
  }
}

class Solution{
  	String s;
  	HashMap<Character, Integer > map;
	Solution(String input){
    	this.s = input;
      	map = new HashMap<>();
    };
  	public char solution(){
      	for(char x: s.toCharArray()){
        	map.put(x, map.getOrDefault(x, 0)+1);
        }

      	int maxValue = 0;
      	char leader = ' ';
      	for (Map.Entry<Character, Integer> entry: map.entrySet()){
        	if (entry.getValue() > maxValue){
            	maxValue = entry.getValue();
              	leader = entry.getKey();
            }
        }
      	return leader;
    }

}
