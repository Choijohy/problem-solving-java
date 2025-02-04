package 깊이우선탐색;
/*
문제: 피보나치 수열
기타:
    - 재귀: 스택 사용 -> 무거움. 메모리 . 성능 저하
    - for문 + 배열 -> 오버헤드 적음.
* */
import java.io.*;
public class 피보나치수열 {
    // 재귀
    static int count = 1;
    static BufferedWriter bw;

    public static String recursive(int n, int pre1, int pre2) throws IOException {
        if (count == n-2) return pre1  +" " + pre2 +" "+ (pre1 + pre2);
        else{
            count ++;
            return pre1 + " " + recursive(n, pre2, pre1+pre2);
        }
    }

    // 메모이제이션
    public static int[] getFibonacci(int n) {
        int[] mem = new int[n+1];
        for (int i=1; i<n+1;i++){
            if(i==1 || i==2) mem[i]=1;
            else mem[i] = mem[i-1] + mem[i-2];
        }
        return mem;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] result = getFibonacci(n);
        for (int i =1; i<n+1; i++){
            System.out.print(result[i]+ " ");
        }
    }
}
