package 넓이우선탐색;

import java.util.*;
import java.io.*;

class CityFinder{
    public static ArrayList<Integer> solution(ArrayList<Integer>[] graph, int N, int X, int K)
    {
        boolean[] visited = new boolean[N+1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{X,0}); // (city, dis)
        visited[X] = true;

        ArrayList<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            if (cur[1] == K) answer.add(cur[0]);
            else if (cur[1] > K) break;
            else{
                for (int x:graph[cur[0]]){
                    if (!visited[x]){
                        visited[x] = true;
                        queue.offer(new int[]{x,cur[1]+1});
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]); // 도시 개수
        int M = Integer.parseInt(str[1]); // 거리 개수
        int K = Integer.parseInt(str[2]); // 최단 거리
        int S = Integer.parseInt(str[3]); // 시작 도시
        // HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); // 도시별 연결된 도시

        //for (int i=0; i<M;i++){
        //    str = br.readLine().split(" ");
        //    map.computeIfAbsent(Integer.parseInt(str[0]), k -> new ArrayList<>())
        //       .add(Integer.parseInt(str[1]));
        //}



        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for (int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0;i<M;i++){
            str = br.readLine().split(" ");
            graph[Integer.parseInt(str[0])].add(Integer.parseInt(str[1]));
            //map.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
        }


        ArrayList<Integer> answer = solution(graph,N,S,K);
        if (answer.isEmpty()) bw.append(String.valueOf(-1));
        else{
            Collections.sort(answer);
            for (int x: answer){
                bw.append(String.valueOf(x));
                bw.newLine();
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}