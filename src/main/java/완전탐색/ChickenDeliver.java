package 완전탐색;
/*
문제: 치킨 배달
유형: 완전탐색 + 백트래킹
공부:
    1) 그리디로 풀 수 없는 이유 - 가장 가까운 치킨집 != 도시 치킨거리의 최소를 구하는 루트
    2) 최대 M개 -> M 이하를 전부 고려해야 하는가? No. "이 도시에서 가장 수익을 많이 낼 수 있는  치킨집의 개수는 최대 M개라는 사실" = 정확히 M개만을 유지하여 최대 수익과 최소 도시 치킨거리를 구해야 한다.
    3) 선택하지 않을 경우를 추가적으로 탐색하고 있었으나, 결국 중복 탐색
        selected.add(stores.get(i));
        dfs(M-1, i+1); // 선택할 경우
        selected.remove(selected.size()-1);
        dfs(M-1, i+1); // 선택하지 않을 경우
    4) 올바르지 않은 경로인지 판단해야 하는 경우 이외에도, 여러 조합을 찾는 과정에서 자원을 되돌려야 할때 백트래킹 고려.
*/
import java.io.*;
import java.util.*;

class ChickenDeliver{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        List<Location> homes = new ArrayList<>();
        List<Location> stores = new ArrayList<>();
        for (int i=0; i<N; i++){
            str = br.readLine().split(" ");
            for (int j=0; j<N; j++){
                if (str[j].equals("1")) homes.add(new Location(i,j));
                else if (str[j].equals("2")) stores.add(new Location(i,j));
            }
        }

        Solution_ChickenDeliver solution = new Solution_ChickenDeliver(N,M,homes, stores);
        solution.dfs(M,0);
        System.out.println(solution.answer);
    }

}
class Location{
    int x;
    int y;
    Location(int x, int y){this.x = x; this.y=y;}
}

class Solution_ChickenDeliver{
    int N, M;
    int answer = Integer.MAX_VALUE;
    List<Location> homes;
    List<Location> stores;
    List<Location> selected = new ArrayList<>();
    Solution_ChickenDeliver(int N, int M, List<Location> homes, List<Location> stores){
        this.N = N;
        this.M = M;
        this.homes = homes;
        this.stores = stores;
    }

    public void dfs(int M, int start){
        if (M==0){
            int sum = 0;
            for (Location home:homes){
                int dis = Integer.MAX_VALUE;
                for (Location store:selected){
                    dis = Math.min(dis, Math.abs(home.x-store.x)+Math.abs(home.y-store.y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i=start; i<stores.size();i++){
                selected.add(stores.get(i));
                dfs(M-1, i+1); // 선택할 경우
                selected.remove(selected.size()-1);
            }
        }
    }
}