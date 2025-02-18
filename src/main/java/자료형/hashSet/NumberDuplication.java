package 자료형.hashSet;

import java.util.*;
import java.io.*;

public class NumberDuplication {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] nums = br.readLine().split(" ");

    HashSet<Integer> set = new HashSet<>();
    for (int i=0;i<n;i++){
    	int num = Integer.parseInt(nums[i]);
    	if (set.contains(num)) {
        	System.out.println("D");
          	return;
        }
      	else set.add(num);
    }

    System.out.println("U");

    return ;
  }
}