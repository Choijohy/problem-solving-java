package brute_force_search;
/*
  문제: 전산망 분리(프로그래머스: https://school.programmers.co.kr/learn/courses/30/lessons/86971)
  자료구조:
    - dfs 탐색용 인접 행렬(그래프)
  알고리즘:
    - dfs + 완전 탐색

  틀린이유:
    1) 잘못된 접근법
        - 2차원 행렬을 만들지 않고, dfs 탐색이 필요할때마다 wires 배열을 순회하는 식으로 생각(dfs_bfs/TransformWord 주석 참고)
        - 하지만, 본 문제에서는 양방향 간선에 대한 고려가 필요하므로, (2,3) (3,2) 이런 형식이 아니라 (2,3)이렇게만 연결 정보를 가지는 wires를
        그대로 사용하면 안됨.

    2) dfs 탐색에 따른 방문 노드 계산 처리
        - dfs를 통해, 하나의 root로 부터 방문 가능한 모든 노드의 수를 구할때는 아래 2가지 방식을 고려한다.
        (1) 전역변수 child 등을 두고, dfs가 한번 실행 될때마다 +1. dfs함수는 리턴값을 가지지 않음
        (2) dfs에서 반환값을 두고, 이를 상위 호출에서 누적 계산하는 형식

  기타: 못 풀음. 복습 필요 😂😂😂
 */
public class SplitElectricGrid {
    public static void main(String[] args){
        SplitElectricGrid splitElectricGrid = new SplitElectricGrid();
        Solution solution = splitElectricGrid.new Solution();

        System.out.println(solution.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
        System.out.println(solution.solution(4, new int[][]{{1,2},{2,3},{3,4}}));
        System.out.println(solution.solution(7, new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}));
    }

    class Solution {
        boolean[] visited;
        boolean[][] graph;
        int child;

        public int solution(int n, int[][] wires){
            int minDiff = n;

            for (int i=0; i <wires.length; i++){
                graph = new boolean[n+1][n+1];
                visited = new boolean[n+1];
                child = 0;
                int tempX = wires[i][0];
                int tempY = wires[i][1];

                // 간선 끊기
                wires[i][0] = -1;
                wires[i][1] = -1;

                // 2차원 인접행렬 생성
                for (int j =0; j <wires.length; j++){
                    // 끊어진 간선 미포함 하도록
                    if (i != j){
                        graph[wires[j][0]][wires[j][1]] = graph[wires[j][1]][wires[j][0]] = true;
                    }
                }

                // (전제) 전산망은 2개의 영역으로만 분리됨
                dfs(1,n);
                int topCount1 = child;
                int topCount2 = n - child;

                minDiff = Math.min(minDiff, Math.abs(topCount1 - topCount2));

                // 끊은 간선 복구(다음 연산을 위해)
                wires[i][0] = tempX;
                wires[i][1] = tempY;
            }
            return minDiff;
        }

        // node = 0 ~ n-1
        public void dfs(int node, int topTotalCount){
            visited[node] = true;
            child ++;
            for (int i=1; i <= topTotalCount;i++){;
                if ((graph[node][i] == true) && (!visited[i])){
                    dfs(i,topTotalCount);
                }
            }
        }


    }
}
