package 자료형.hashMap;

import java.util.*;

class 가장_많이_받은_선물{
    public int solution(String[] friends, String[] gifts){
    int n = friends.length;
    // grid내의 인덱스 및 선물지수 저장용
    HashMap<String, Friend> map = new HashMap<>();

    for (int i=0; i<n; i++){
        map.put(friends[i], new Friend(i));
    }

    int[][] grid = new int[n][n];
    for (String x:gifts){
        String[] pair = x.split(" ");
        String giver = pair[0];
        String receiver = pair[1];

        grid[map.get(giver).index][map.get(receiver).index] += 1;
        map.get(giver).giftScore ++;
        map.get(receiver).giftScore --;
    }

    int answer = 0;
    // 다음달에 받을 선물 계산
    for (int i=0; i<n; i++){
        int sum = 0;
        for (int j=0; j<n; j++){
            if (i==j) continue;
            String p1 = friends[i];
            String p2 = friends[j];
            // p1이 더 많은 선물을 줘서 다음달 선물을 받는 경우
            if (grid[i][j] > grid[j][i]) sum++;
            // p1과 p2가 주고받은 선물이 같으나, p1의 선물지수가 더 높은 경우
            else if (grid[i][j] == grid[j][i]){
                if (map.get(p1).giftScore > map.get(p2).giftScore) sum++;
             }
        }
        answer = Math.max(sum, answer);
    }

        return answer;
    }
}


class Friend{
    int index;
    int giftScore;

    Friend(int index){
        this.index = index;
        this.giftScore = 0;
    }
}