package array;

import java.util.*;

public class BiggerNumPrinter {
    public static ArrayList<Integer> solution(int size, int[] numbers){
        ArrayList<Integer> result = new ArrayList<>();

        result.add(numbers[0]);

        for (int i=1; i<size;i++){
            if (numbers[i] > numbers[i-1]) result.add(numbers[i]);
        }
    return result;
  }
  public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int size = in.nextInt();
        int[] numbers = new int[size];
        for (int i=0; i<size;i++){
            numbers[i] = in.nextInt();
        }

        for (int x:solution(size, numbers)){
            System.out.print(x+" ");
        }
  }

}
