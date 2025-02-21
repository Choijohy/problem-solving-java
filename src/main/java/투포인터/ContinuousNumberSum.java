package 투포인터;


import java.util.*;
import java.io.*;

public class ContinuousNumberSum {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] arr = new int[N/2+2];
    for (int i=1; i<(N/2)+2; i++){
    	arr[i] = i;
    }

    int lt = 1;
    int rt = 2;
    int sum = arr[lt]+arr[rt];
    int answer = 0;
    while(rt < N/2+1 && lt <=rt){
    	if (sum == N){
            answer++;
            rt++;
          	sum += arr[rt];
        }
        else {
            if (sum < N) {
                rt++;
                sum += arr[rt];
            } else {
                sum -= arr[lt];
                lt++;
            }
        }
    }
    if (sum == N) answer++;
    System.out.println(answer);
  }
}