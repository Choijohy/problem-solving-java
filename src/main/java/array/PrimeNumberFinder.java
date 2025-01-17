package array;
/*
문제: 소수 찾기
카테고리: 배열
기타:
    - 소수 찾기 = 에라토스테네스 체 풀이가 보통 가장 빠르다고함
    - n이 주어질때, n+1 크기의 배열 생성
    - 2~n-1까지 순회하며, 각 배수에 해당하는 배열 공간에 1로 체크
    - 2~n-1까지 순회하며 각 숫자에 해당하는 배열 공간이 0인지 검사(=소수)
*/
import java.util.*;

public class PrimeNumberFinder {
    public static int solution(int num){
        int[] checked = new int[num+1];

        int count = 0;
        for (int i=2; i<num;i++){
            if (checked[i] == 0) count ++;
            for (int j=i;j<num;j+=i){
                    checked[j] = 1;
                }
        }
        return count;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int num = in.nextInt();
        System.out.println(solution(num));
    }
}
