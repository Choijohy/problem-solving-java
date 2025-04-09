package 투포인터;

import java.util.*;

class 퍼즐_게임_챌린지 {
    public int solution(int[] diffs, int[] times, long limit) {
        final int MAX_LEVEL = 100000;

        int lt = 1;
        int rt = MAX_LEVEL;
        int mid = 0;

        while (lt < rt){
            mid = (lt+rt)/2;

            long sum = 0;
            for (int i=0; i<diffs.length; i++){
                // 이전 퍼즐을 다시 풀어야 하는 경우
                if (diffs[i] > mid){
                    int gap = diffs[i] - mid;
                    sum += (times[i-1]+times[i])*gap;
                }
                // 현재 퍼즐 풀이
                sum += times[i];
            }

            if (sum<=limit) {
                rt = mid; // rt는 mid까지 범위로 잡아야 한다. 기존 mid 또한 limit을 만족시키는 답 중 하나이기 때문
            }
            else {
                lt = mid+1;
            }
        }

            return rt; // mid로 return하면 x
        }
}