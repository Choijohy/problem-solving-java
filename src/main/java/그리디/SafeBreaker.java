package 그리디;

/*
* 문제: 금고털이
* 카테고리: 배열 정렬 + 그리디
* 기타:
*   배열 정렬시, Comparator보다 람다식 사용이 가능하면 람다식 사용하기(미세하지만, 더 빠름. 연습 문제 풀이시, Comparator의 compare()사용으로 시간 초과)
*/

import java.io.*;
import java.util.*;

public class SafeBreaker {
    public static int solution(int w, int n, int[][] items){

        // O(NlogN)
        Arrays.sort(items, (o1,o2) -> o2[1] - o1[1]
        );

        // O(N)
        int index = 0;
        int value = 0;
        for (int i=0; i<n;i++){
            // loop안에서만 쓰이는 변수는 loop 안에서 선언 및 할당 -> 스코프 최소화(성능면에서는 큰 차이 없음)
            int totalWeight = items[i][0];
            int pricePerWeight = items[i][1];
            if (w < 0) return value;
            if (w >= totalWeight) {
                value += totalWeight*pricePerWeight;
                w -= totalWeight;
            }
            else {
                value += w*pricePerWeight;
                return value;
            }
        }

        return value;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int w = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);

        int[][] items = new int[n][2];

        // 여기다tmp 선언하는게 좋은가?
        for (int i=0;i<n;i++){
            String[] tmp = br.readLine().split(" ");
            items[i][0] = Integer.parseInt(tmp[0]);
            items[i][1] = Integer.parseInt(tmp[1]);
        }
        System.out.println(solution(w,n,items));
    }
}
