package dfs_bfs;

import java.util.*;

public class Tomato {
    public static void main (String[]args){
        Tomato tomato = new Tomato();
        Solution solution = tomato.new Solution();
        System.out.print(solution.solution());
    }

    class Solution{
        int m,n;
        int[][] graph;
        boolean[][] visited;
        List<int[]> riped = new ArrayList<>();
        int[] xGenerator = new int[]{-1,1,0,0};
        int[] yGenerator = new int[]{0,0,-1,1};

        public int solution(){

            Scanner scanner = new Scanner(System.in);
            m = scanner.nextInt();
            n = scanner.nextInt();

            graph = new int[n][m];
            visited = new boolean[n][m];
            Queue<int[]> queue = new LinkedList<>();

            // O(n^2)
            for (int i=0; i<n; i++){
                for (int j=0; j<m;j++){
                    int input = scanner.nextInt();
                    graph[i][j] = input;
                    if (input == 1){
                        queue.add(new int[]{i,j});
                    }
                }
            }

            int day = -1;
            while(!queue.isEmpty()){
                day ++;
                bfs(queue);
            }
            for (int i=0; i<n;i++){
                for (int j=0; j<n; j++){
                    if (graph[i][j] == 0){
                        return -1;
                    }
                }
            }
            return day;
        }

        public void bfs(Queue<int[]> queue){
            int size = queue.size();
            for (int i= 0; i<size; i++){
                int[] current = queue.poll();
                int currentX = current[0];
                int currentY = current[1];
                for (int j=0; j<4;j++){
                    int newX = currentX + xGenerator[j]; // O(1)
                    int newY= currentY + yGenerator[j];

                    if (newX >= 0 && newX < n && newY >=0 && newY <m){
                        if(graph[newX][newY] == 0 && !visited[newX][newY]){
                            queue.add(new int[]{newX, newY});
                            visited[newX][newY] = true;
                            graph[newX][newY] = 1;
                        }
                    }
                }
            }


        }
    }
}
