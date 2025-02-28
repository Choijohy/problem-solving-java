package 그리디;

import java.util.*;
import java.io.*;

class MoveBalls{
    public static int solution(int len, String s){
        char[] balls = new char[]{'R','B'};

        // X공을 왼쪽으로 옮기는 경우
        int answer = 500000;
        for (int i=0; i<2; i++){
            char target = balls[i]; // 옮길 공
            boolean pass = s.charAt(0) == target; // 옮기려는 색깔의 공부터 시작된는 경우, 스킵할 수 있도록 플래그
            int move = 0; // 옮겨야 할 공의 개수
            for (int j=1; j<len; j++){
                char cur = s.charAt(j);
                if (cur == target && !pass) move++;
                else if(cur != target && pass) pass = false;
            }
            answer = Math.min(answer, move);
        }

        for (int i=0; i<2; i++){
            char target = balls[i]; // 옮길 공
            boolean pass = s.charAt(len-1) == target;
            int move = 0;
            for (int j=len-2; j>-1; j--){
                char cur = s.charAt(j);
                if (cur == target && !pass) move++;
                else if(cur != target && pass) pass = false;
            }
            answer = Math.min(answer, move);
        }

        return answer;


    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        System.out.println(solution(n, s));

    }
}






















