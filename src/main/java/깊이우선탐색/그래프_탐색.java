package 깊이우선탐색;

import java.util.*;
import java.io.*;

public class 그래프_탐색 {
    static int n;
    static int m;
    static int answer = 0;
    static ArrayList<Integer>[] u;
    static boolean[] visited;

    private static void dfs(int v){
        ArrayList<Integer> next = u[v];
        for (int i=0; i<next.size();i++){
            int nv = next.get(i);
            if (!visited[nv]) {
                visited[nv] = true;
                answer ++;
                dfs(nv);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        u = new ArrayList[n+1];
        for (int i=0; i<=n; i++){
            u[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            u[v1].add(v2);
            u[v2].add(v1);
        }

        visited = new boolean[n+1];
        visited[1] = true;
        dfs(1);
        System.out.println(answer);
    }
}