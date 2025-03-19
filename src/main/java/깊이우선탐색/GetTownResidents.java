package 깊이우선탐색;

import java.util.*;
import java.io.*;

public class GetTownResidents {
    static int n;
    static int[][] grid;

    public static int dfs(final int x, final int y){
        final int[] dx = {1,-1,0,0};
        final int[] dy = {0,0,-1,1};
        int people = 1;

        for (int i =0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx>-1 && nx <n && ny >-1 && ny <n && (grid[nx][ny] ==1)){
                grid[nx][ny] = 0;
                people += dfs(nx,ny);
            }
        }
        //System.out.println(x+","+y+": "+people);
        return people;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];

        for (int i = 0; i < n; i++){
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++)
                grid[i][j] = Integer.parseInt(str[j]);
        }

        int town = 0;
        ArrayList<Integer> people = new ArrayList<>();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1){
                    grid[i][j] = 0;
                    int count = dfs(i,j);
                    town++;
                    people.add(count);
                }

                // peopleNum을 static 변수로 두고 푸는 방식
//                if (grid[i][j] == 1){
//                    grid[i][j] = 0;
//                    peopleNum = 1;
//                    dfs(i,j); // dfs안에서 peopleNum ++
//                    town++;
//                    people.add(peopleNum);
//                }
        }

        Collections.sort(people);
        System.out.println(town);
        for (int x: people){
            System.out.println(x);
        }
    }
}