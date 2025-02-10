package 투포인터;
/*
문제: GBC
출처: 소프티어
카테고리: 투포인터

*/
import java.io.*;
import java.util.*;

public class GBC {
    public static int[] getArray(BufferedReader br, int[] arr, int n) throws IOException{
        int start = 1;
        for (int i=0; i<n; i++){
            String[] temp = br.readLine().split(" ");
            int distance = Integer.parseInt(temp[0]);
            int velocity = Integer.parseInt(temp[1]);

            for (int j=start;j<start+distance;j++){
                arr[j] = velocity;
            }
            start +=distance;
        }
        return arr;
    }
    public static int solution(int[] limit, int[] test){
        int answer = 0;
        for (int i=1; i<=100; i++){
            answer = Math.max(answer, test[i] - limit[i]);
        }
        return answer;

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int[] limit = new int[101];
        int[] test = new int[101];
        limit = getArray(br, limit, n);
        test = getArray(br, test, m);

        bw.append(String.valueOf(solution(limit, test)));

        br.close();
        bw.flush();
        bw.close();
    }
}
