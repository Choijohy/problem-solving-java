package dataStructure.array;

import java.util.*;

public class ReversePrime {
    public static boolean isPrime(int num){
        if (num ==1 ) return false;
        for (int i=2; i<=Math.sqrt(num);i++){
            if ((num % i) ==0){
                return false;
            }
        }
        return true;
    }
    public static void solution(int[] numbers){
        for (int i=0; i<numbers.length;i++){
            int num = numbers[i];
            // 숫자 뒤집기
            StringBuilder sb = new StringBuilder(String.valueOf(num));
            int reversed = Integer.parseInt(sb.reverse().toString());
            if(isPrime(reversed)) System.out.print(reversed+" ");
        }
    }

    public static void solution2(int[] numbers){
        for (int i=0; i<numbers.length;i++){
            int num = numbers[i];
            // 숫자 뒤집기 다른 풀이
            int reversed = 0;
            while(num >0){
                int temp = num % 10;
                reversed = reversed * 10 + temp;
                num= num/10;
            }

            if (isPrime(reversed)) System.out.print(reversed+" ");
        }
    }
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    int size = in.nextInt();
	int[] numbers = new int[size];
    for (int i=0; i<size; i++){
    	numbers[i] = in.nextInt();
    }
    solution2(numbers);
  }
}
