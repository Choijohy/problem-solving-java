package 깊이우선탐색;

/*
* 문제: 사다리타기[hard]
* 유형: dfs(n개 중에 k개 고르기)
* 공부:
*    - dfs() 시간 복잡도: 2^M (각 사다리마다 포함 or 미포함 2가지)
*    - possible() 시간 복잡도: O(N+M)
*    - 시간 복잡도: O(2^M×(N+M))
*    - 계산해야 할 경우의 수는 전체 집합의 부분집합이다. = 백트래킹
* */
import java.util.*;
import java.io.*;

public class BridgeGame {
    static int N;
    static int M;
    static int answer;
    static ArrayList<Bridge> selected = new ArrayList<>();
    static ArrayList<Bridge> bridges = new ArrayList<>();
    static int[] target;

    static public void dfs(int L){
        if (L==M) {
            if (possible()){
                answer = Math.min(answer, selected.size());
            }
            return;
        }
        selected.add(bridges.get(L));
        dfs(L+1);
        selected.remove(selected.size()-1);
        dfs(L+1);
    }

    static public boolean possible(){
        int[] result = new int[N+1];

        for (int i=1; i<=N; i++){
            result[i]= i;
        }
        for (Bridge x: selected){
            int index = x.a; // 세로줄
            int temp = result[index];
            result[index] = result[index+1];
            result[index+1] = temp;
        }

        for (int i=1; i<=N; i++){
            if (target[i]!=result[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in
        ));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        answer = M;
        for (int i=0; i<M; i++){
            str = br.readLine().split(" ");
            bridges.add(new Bridge(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
        }

        // 가로줄 기준 오름차순
        Collections.sort(bridges);

        // 입력된 사다리타기 결과: 가로줄 마다, 세로줄간의 양 옆 숫자 바꾸기
        target = new int[N+1];
        for (int i=1; i<=N;i++){
            target[i] = i;
        }

        for (Bridge x:bridges){
            int index = x.a; // 세로줄
            int temp = target[index];
            target[index] = target[index+1];
            target[index+1] = temp;
        }

        dfs(0);

        System.out.println(answer);

    }
}

class Bridge implements Comparable<Bridge>{
    int a; // 세로줄
    int b; // 가로줄

    Bridge(int a, int b){this.a = a; this.b = b;}

    @Override
    public int compareTo(Bridge o){
        return this.b - o.b;
    }
}