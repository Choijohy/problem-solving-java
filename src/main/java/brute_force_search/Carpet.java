package brute_force_search;

/*
문제: 프로그래머스 카펫(https://school.programmers.co.kr/learn/courses/30/lessons/42842)
레벨: 2
자료구조:
알고리즘:
    - 완전 탐색(약수 구하기): 제곱근까지만 순회하여, 탐색 속도 줄이기
    - 문제를 정리해보면, 다음과 같은 2차 방정식으로 풀이 가능. 아래 2조건을 만족시키는 x,y를 찾으면 됨.
        x,y는 중앙에 배치되는 노란 타일로만 구성된 사각형의 가로/세로 조합
        x*y = 노란 타일의 총 개수
        2(x+y+2) = 갈색 타일의 총 개수
*
*/

import java.util.Arrays;

public class Carpet {
    public static void main(String[] args) {
        Carpet carpet = new Carpet();
        Solution solution = carpet.new Solution();
        System.out.println(Arrays.toString(solution.solution(10, 2)));
        System.out.println(Arrays.toString(solution.solution(8, 1)));
        System.out.println(Arrays.toString(solution.solution(24, 24)));
    }

    class Solution{
        public int[] solution(int brown, int yellow) {
            // 노란 타일 총 개수의 약수 탐색
            for (int i=1; i*i <= yellow; i++){
                if (yellow % i == 0){
                    // 곱해서 yellow가 나오는 조합 (= 중앙에 배치된 노란 타일 사각형의 가로(x), 세로(y)로 볼 수 있음)
                    int x = i;
                    int y = yellow/i;

                    if (2*(x+y+2) == brown){
                        if (x > y){
                            return new int[]{x+2, y+2}; // 가로 길이 >= 세로 길이
                        } else{
                             return new int[]{y+2,x+2};
                        }

                    }
                }
            }
            return null;
        }
    }
}
