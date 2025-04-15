package 스택큐;

import java.util.*;
/*
문제: 서버 증설 횟수
유형: 우선순위 큐
기타:
    - 큐를 쓰는 것 보다(k원소를 삽입한 후, 매 타임때마다 queue에서 -1씩 한 값으로 다시 넣어주기)
    우선순위큐를 쓰는 것이 연산을 훨씬 줄일 수있다.
    -> 매 타임마다 queue의 원소 개수(n) * 2 연산을 생략하고, peek()으로 필요한 연산만 진행.
    -> pq에는 종료시각을 넣는다.
*/
class 서버_증설_횟수 {
    public int solution(int[] players, int m, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int answer = 0;
        for (int i=0; i<24; i++){
            int people = players[i];

            while(!pq.isEmpty() && pq.peek() == i) pq.poll();

            int currentServer = pq.size();
            if (people >= (currentServer+1)*m){
                int gap = people/m - currentServer;

                for (int j=0; j<gap; j++) {
                    answer ++;
                    pq.offer(i+k);
                }
            }
        }

        return answer;
    }
}