package 정렬;
/*
* 문제: 카드 섞기
* 유형: 그리디 + 우선순위 큐(정렬)
* 공부:
*   - 우선순위큐 최대입: new PriorityQueue<>(Collections.reverseOrder());
*   - 그리디 규칙 잘못 생각함(Arrays.sort()) -> 반례: 10 20 30 31 32 33 34
* */
import java.util.*;
import java.io.*;

class CardShuffle{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소힙

        for (int i=0;i<N;i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }
        int answer = 0;
        while(pq.size()>1){
            int sum = pq.poll() + pq.poll();
            answer += (sum);
            pq.offer(sum);
        }

        System.out.println(answer);
    }
}