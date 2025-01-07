package brute_force_search;

/*
 문제: 프로그래머스 피로도(https://school.programmers.co.kr/learn/courses/30/lessons/87946?language=java)
 자료구조:
    LinkedList 기반 리스트

 알고리즘:
    - 재귀호출
    - 재귀호출 과정에서 리스트 복제가 발생 O(n) -> 복제없이 방문여부를 표시하여 원본 배열만 가지고도 풀 수 있도록(Fatigue2 풀이)
 */

import java.util.LinkedList;
import java.util.List;

public class Fatigue {
    public static void main(String[] args){
        Fatigue fatigue = new Fatigue();
        Solution solution = fatigue.new Solution();

        System.out.println(solution.solution(80,new int[][]{{80,20},{50,40},{30,10}}));
        System.out.println(solution.solution(80,new int[][]{{80,20}}));
    }

    class Solution {
        public int solution(int k, int[][] dungeons) {
            List<int[]> remains = new LinkedList<>();

            int size = dungeons.length;
            for (int i = 0; i < size; i++) {
                remains.add(dungeons[i]);
            }

            return checkFatigue(k, remains, 0);
        }

        /**
         * @param k        현재 남은 피로도
         * @param dungeons 아직 탐험하지 않은 던전 목록
         * @param visited  현재까지 탐험한 던전 수
         * @return 이 상태에서 탐험할 수 있는 최대 던전 수
         */
        public int checkFatigue(int k, List<int[]> dungeons, int visited) {
            int maxValue = visited; // 현재까지의 최대 탐험 개수

            for (int[] dungeon : dungeons) {
                if (!dungeons.isEmpty()) {
                    int required = dungeon[0]; // 최소 피로도
                    int consume = dungeon[1];

                    if (k >= required) { // 탐험 가능
                        List<int[]> nextRemains = new LinkedList<>(dungeons);
                        nextRemains.remove(dungeon);
                        int temp = checkFatigue(k - consume, nextRemains, visited + 1);
                        maxValue = Math.max(maxValue, temp);
                    }
                }
            }
            return maxValue;
        }
    }
}
