package 넓이우선탐색;
/*
문제: 그래프 탐색
유형: BFS
공부:
    1) 메모리 초과: 현재 문제는 정점 개수(n) 최대 20000개 -> 20001 * 20001 * 4bytes = 1,600,000,000 = 약 1.6 GB
        - 인접행렬: O(n^2)
        - 인접 리스트: O(n+E)
        ** 공간복잡도 256MB 정도 잡고 풀기.

    2) 인접행렬 -> 공간 낭비가 크지만, 두 정점간의 연결 여부 확인이 O(1)로 빠름. ex) graph[i][j] == 1 -> 정점은 적지만, 간선이 많은 경우 유용
       인접리스트 -> 정점 개수가 많을 수록 메모리 측면에서 매우 효율적.  -> 정점이 많지만, 간선이 적은 희소 그래프에서 유용
*/

import java.util.*;

class GraphSearch {
    public int solution1(int n, int[][] edge) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }

        // 리스트 구성
        for (int i=0; i<edge.length; i++){
            int x = edge[i][0];
            int y = edge[i][1];

            list.get(x).add(y);
            list.get(y).add(x);
        }

        int[] visited = new int[n+1];
        visited[1] = 1;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        int count = 0;

        while (!queue.isEmpty()){
            int size = queue.size();
            count++;
            for (int i=0; i<size; i++){
                int cur = queue.poll();
                for (int x: list.get(cur)){
                    if (visited[x] == 0){
                        visited[x] = count;
                        queue.offer(x);
                    }
                }
            }
        }

        int answer = 0;
        if (count == 1) return answer;
        for (int i=2; i<=n; i++){
            if ((count-1) == visited[i]) answer++;
        }
        return answer;
    }
    public int solution2(int n, int[][] edge){
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i=0; i<=n; i++){
            arr.add(new ArrayList<Integer>());
        }
        boolean[] visited = new boolean[n+1];

        // 인접 노드 정보 추가
        for (int i=0; i<edge.length; i++){
            int[] temp = edge[i];
            int a = temp[0];
            int b = temp[1];

            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        if(arr.get(1).isEmpty()) return 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[1] = true;

        int answer = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            answer = size;
            for (int i=0; i<size; i++){
                int cur = queue.poll();
                ArrayList<Integer> next = arr.get(cur);
                for (int x: next){
                    if (visited[x]==false){
                        visited[x] = true;
                        queue.offer(x);
                    }
                }
            }
        }

        return answer;
    }
}