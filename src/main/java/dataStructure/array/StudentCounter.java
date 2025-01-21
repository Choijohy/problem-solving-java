package dataStructure.array;

import java.util.*;

public class StudentCounter {
    public static int solution(int nums, int[] students){
  	int count = 1; // 맨 앞 학생
    int max = students[0];

    for(int i=1; i<nums;i++){
    	if (max < students[i]){
        	count ++;
          	max = students[i];
        }
    }

    return count;
  }
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    int nums = in.nextInt();
    int[] students = new int[nums];
    for (int i=0; i<nums;i++){
    	students[i] = in.nextInt();
    }
    System.out.println(solution(nums, students));
    return ;
  }
}
