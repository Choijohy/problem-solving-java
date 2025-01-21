package dataStructure.array;
import java.util.*;
public class Fibonacci {
    public static ArrayList<Integer> solution(int input1){
  	ArrayList<Integer> result = new ArrayList<>();
    result.add(1);
    result.add(1);

    for (int i=2; i<input1; i++){
    	result.add(result.get(i-1) + result.get(i-2));
    }
    return result;
  }

  public static void main(String[] args){
    Scanner in=new Scanner(System.in);

    int input1 = in.nextInt();
    for (int x: solution(input1)){
    	System.out.print(x+" ");
    }
    return ;
  }
}

