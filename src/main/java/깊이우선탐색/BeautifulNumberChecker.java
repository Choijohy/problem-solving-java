package 깊이우선탐색;


import java.util.*;
import java.io.*;

public class BeautifulNumberChecker {
    static int answer = 0;
    static int num, count = 0;
    static int n;
    static int[] arr = {0,1,2,3,4};

    private static void dfs(int L){
        if (L==n){
            if (count == num) {
                answer ++;
                //System.out.println("아름다운 숫자! "+answer);
            }
            return;
        }
        if (count == num){
            for (int i=1;i<=4; i++){
                if (arr[i]<= n-L){
                    //System.out.println("L: "+L+" 다음숫자(i): "+i);
                num=arr[i];
                count = 1;
                dfs(L+1);
                }
            }
        }
        else if(count < num){
            count ++;
            dfs(L+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dfs(0);
        System.out.println(answer);
    }
}