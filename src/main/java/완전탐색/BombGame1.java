package 완전탐색;

import java.util.*;
import java.io.*;
/*
문제: 1차원 폭발 게임
유형: 시뮬레이션
공부:
    - 테스트케이스
        1) 엣지 케이스
        2) 기본케이스 1 : 1,2,2,3
        3) 기본케이스 2: 1,1,1,2,2,2,3 (m=5) -> prev를 저장하는 과정에서 로직 설계 틀렸었음
*/
public class BombGame1 {
    static int m;
    public static ArrayList<Integer> explosion(ArrayList<Integer> bombs){

        while(!bombs.isEmpty()){
            int prev = bombs.get(0);
            int count = 1;
            boolean flag = false; // 터진 폭탄이 있는지?

            ArrayList<Integer> temp = new ArrayList<>();

            for (int i=1; i<bombs.size(); i++){
                int cur = bombs.get(i);

                if(prev == cur) count++;
                else{
                    if (count < m) {
                        for (int j=0; j< count; j++) temp.add(prev);
                    }
                    else flag = true;

                    prev = cur;
                    count = 1;
                }
            }

            if (count < m) {
                // 쌓인 개수 만큼 옮겨주기
                for (int j=0; j<count; j++)temp.add(prev);
            }
            else flag = true;

            bombs = temp;
            if (!flag) break;
        }
        return bombs;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in
        ));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> bombs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bombs.add(Integer.parseInt(br.readLine()));
        }

        ArrayList<Integer> result = explosion(bombs);
        System.out.println(result.size());
        for (int i=0; i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
}