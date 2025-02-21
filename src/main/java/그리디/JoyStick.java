package 그리디;

import java.util.*;

class JoyStick {
    public int solution(String name) {
        int n = name.length();
        int answer = 0;
        int move = n-1; // 좌우중 단방향으로만 움직일때
        for (int i=0; i<n; i++){
            // 상하 움직임
            answer += Math.min(name.charAt(i)-'A', 1+'Z'-name.charAt(i));
            // 좌우 움직임

            int index = i+1;
            while(index < n && name.charAt(index) == 'A') index++;
            move = Math.min(move, i*2+n-index);
            move = Math.min(move, (n-index)*2 + i);
        }

        return answer + move;
    }
}