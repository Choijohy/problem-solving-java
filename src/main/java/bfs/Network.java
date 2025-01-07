package bfs;

/*
 문제: 프로그래머스 네트워크(https://school.programmers.co.kr/learn/courses/30/lessons/43162?language=java)
 자료구조:
    1) BFS - 큐
    2) DFS - 단순 배열

 알고리즘:
    DFS, BFS 모두 O(n^2)을 가짐. 해당 문제에서는 n <=200으로 제한이 있기 때문에 크게 문제 되지 않음.
    다만, DFS는 재귀호출을 통해 풀이가 되므로 노드 수가 매우 많고, 깊이가 매우 깊어지는 경우에는 스택 오버플로우 문제를 주의해야함.
    BFS는 반복문 + 큐 기반의 힙 메모리를 사용하기 때문에 더 안전함.

 */

import java.util.LinkedList;
import java.util.Queue;

class Network {
    public static void main(String[] args) {
        // Network 인스턴스 생성
        Network network = new Network();
        // Inner class 생성
        Solution solution = network.new Solution();

//        System.out.println(solution.solution_bfs(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
//        System.out.println(solution.solution_bfs(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
//        System.out.println(solution.solution_bfs(1, new int[][]{{1}}));
        System.out.println(solution.solution_dfs(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution.solution_dfs(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
        System.out.println(solution.solution_dfs(1, new int[][]{{1}}));
    }

    class Solution{
        static int nums;
        static boolean[] checked;
        static int[][] network;

        public int solution_bfs(int n, int[][] computers) {
            // 각 컴퓨터별 네트워크 탐색 완료 여부
            checked = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();

            int answer = 0;

            // 2차원 배열 bfs 탐색
            for (int k =0; k < n; k++) {
                if (checked[k] == false){
                    answer++;
                    for (int i = 0; i < n; i++) {
                    if (computers[k][i] == 1 && checked[i] == false) { // 현재 컴퓨터와 연결된 모든 노드들을 일단 큐에 삽입
                        checked[i] = true;
                        queue.add(i);
                    }

                    while (!queue.isEmpty()) { // 위에서 삽입된 컴퓨터를 하나씩 탐색하며, 새로운 연결 컴퓨터가 있다면 큐에 삽입
                        int current = queue.poll();
                        for (int j = 0; j < n; j++) {
                            if (computers[current][j] == 1 && checked[j] == false) {
                                checked[j] = true;
                                queue.add(j);
                            }
                        }

                    }}
                }
            }
            return answer;
        }

        public int solution_dfs(int n, int[][] computers) {
            checked = new boolean[n];
            network = computers;
            nums = n;

            int answer = 0;

            for (int i = 0; i < n; i++) {
                if (!checked[i]) {
                    checked[i] = true;
                    answer ++;

                    for (int j = 0; j < n; j++) {
                        if (computers[i][j] == 1 && !checked[j]) {
                            dfs(j);
                        }
                    }
                }

            }
            return answer;
        }
        private void dfs(int index){
            for (int i=0; i<nums; i++){
                checked[index] = true;
                if ((network[index][i] == 1) && (!checked[i])){
                    dfs(i);
                }
            }
        }
    }
}