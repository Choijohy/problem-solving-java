package 스택큐;

import java.io.*;
import java.util.*;

public class 커리큘럼 {
    public static String solution(Queue<Character> queue, String plan){

        for (char x: plan.toCharArray()){
            if (queue.contains(x)){
                if (x == queue.peek()) queue.poll();
                else return "NO";
            }
            if (queue.isEmpty()) return "YES";
        }

        if (queue.isEmpty()) return "YES";
        else return "NO";
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Character> queue = new ArrayDeque<>();

        for(char x: br.readLine().toCharArray()){
            queue.offer(x);
        }

        String plan = br.readLine();
        System.out.println(solution(queue, plan));

    }
}
