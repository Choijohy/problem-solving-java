package 구현;
/*
문제: 톱니바퀴
유형: 구현, 시뮬레이션
공부:
    1) 톱니바퀴 연쇄 반응 구현
        - 재귀 호출 -> checked 배열로 재귀 중단
        - for 문(https://tussle.tistory.com/968): 기준 톱니에서 왼쪽 순회 & 오른쪽 순회
*/

import java.io.*;

class WheelScore{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] wheels = new int[5][8]; // 1~4번 톱니바퀴 정보(인덱스 0은 미사용)
        for (int i=1; i <= 4; i++){
            String[] str = br.readLine().split("");
            int[] wheel = new int[8];
            for(int j=0; j < 8; j++){
                wheel[j] = Integer.parseInt(str[j]);
            }
            wheels[i] = wheel;
        }

        int k = Integer.parseInt(br.readLine()); // 회전 횟수
        Solution_WheeScore solution = new Solution_WheeScore(wheels);
        System.out.println(solution.solution(k, br));
    }
}

class Solution_WheeScore {
    int[][] wheels;

    Solution_WheeScore(int[][] wheels){
        this.wheels = wheels;
    }

    private int[] turnClockDirection(int[] wheel){
        int prior = wheel[0];
        int temp;
        for (int i=0; i<8; i++){
            if (i==7) wheel[0] = prior;
            else {
                temp = wheel[i+1];
                wheel[i+1] = prior;
                prior = temp;
            }
        }
        return wheel;
    }

    private int[] turnReversedClockDirection(int[] wheel){
        int prior = wheel[7];
        int temp;
        for (int i=7; i > -1; i--){
            if (i==0) wheel[7] = prior;
            else {
                temp = wheel[i-1];
                wheel[i-1] = prior;
                prior = temp;
            }
        }
        return wheel;
    }

    public boolean[] getPairs(){
        boolean[] pairs = new boolean[4]; // 1번: 1~2번의 톱니바퀴 연쇄작용 필요 여부, 2번: 2~3번, 3번: 3~4번
        if (wheels[1][2] != wheels[2][6]) pairs[1] = true;
        if (wheels[2][2] != wheels[3][6]) pairs[2] = true;
        if (wheels[3][2] != wheels[4][6]) pairs[3] = true;
        return pairs;
    }

    public void turn(int n, int d, boolean[] pairs, boolean[] checked){
        checked[n] = true;
        // 톱니바퀴 돌리기
        if (d==1) {wheels[n] = turnClockDirection(wheels[n]);}
        else {wheels[n] = turnReversedClockDirection(wheels[n]);}

        // 연쇄작업
        if (0 < n && n < 4){
            if (pairs[n] && !checked[n+1]) {
//                checked[n+1] = true;
                turn(n+1, d*(-1), pairs, checked);
            }
        }

        if (n >= 2 && n <= 4){
            if(pairs[n-1] && !checked[n-1]){
//                checked[n-1] = true;
                turn(n-1, d*(-1), pairs, checked);
            }
        }
    }

    public int solution(int k, BufferedReader br) throws IOException{
        for (int i=0; i<k; i++){
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int d = Integer.parseInt(str[1]);
            boolean[] pairs = getPairs();

            boolean[] checked = new boolean[5];
            turn(n, d, pairs, checked);
        }

        // 점수 구하기
        int answer = 0;
        int score = 1;
        for(int i=1; i<=4; i++){
            if(wheels[i][0] == 1) answer += (score);
            score *= 2;
        }
        return answer;
    }
}