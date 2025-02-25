package 깊이우선탐색;

import java.util.*;

class Tourist {
    List<String> answer = new ArrayList<>();
    HashMap<String, Queue<String>> routes = new HashMap<>();
    Boolean flag = false;
    int total;

    public List<String> solution(String[][] tickets) {
        total = tickets.length + 1;
        // 도착지 기준 알파벳순 정렬
        Arrays.sort(tickets, Comparator.comparing(ticket -> ticket[1]));

        for (String[] x : tickets) {
            String depart = x[0];
            String dest = x[1];
            routes.computeIfAbsent(depart, k -> new ArrayDeque<>()).offer(dest);
        }

        // DFS
        dfs("ICN");

        return answer;
    }

    public void dfs(String departure) {
        answer.add(departure);

        if (answer.size() == total) {
            flag = true;
            return;
        }

        Queue<String> q = routes.get(departure);

        if (q != null && !q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String next = q.poll();
                dfs(next);
                if (flag) return;
                q.offer(next);
            }
        }
        answer.remove(answer.size() - 1);

    }
}