package 구현;

class FlexibleWorkSystem {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length; // 학생수
        int[] limits = new int[n];
        int answer = 0; // 총 선물 받을 명수

        // 직원별 출근 제한 시간
        for (int i=0; i<n;i++){
            limits[i] = (schedules[i] + 10)%100 >=60 ? schedules[i]+50 : schedules[i] + 10  ;
        }


        for (int i=0; i<n; i++){
            int day = startday;
            boolean flag = true;

            for(int j=0; j<7; j++){ // 날짜
                if ((day < 6) && (timelogs[i][j] > limits[i])){
                    flag = false;
                    break;
                }
                if (day == 7) day = 1;
                else day++;
            }
            if (flag) answer ++;
        }
        return answer;
    }
}