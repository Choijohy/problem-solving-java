package 다이나믹프로그래밍;

import java.util.*;

class NCalculator {
    public int solution(int N, int number) {
        int t = N;
        List<Set<Integer>> list = new ArrayList<>();
        list.add(new HashSet<Integer>()); // 0번지 사용 안하는 set

        for (int i=1; i<=8; i++){
            HashSet<Integer> set = new HashSet<>();
            set.add(t);
            t = t * 10 + N;
            for (int j=1; j<= i/2; j++){
                for (int a: list.get(j)){
                    for (int b: list.get(i-j)){
                        set.add(a+b);
                        set.add(a-b);
                        set.add(b-a);
                        set.add(a*b);
                        if (a !=0) set.add(b/a);
                        if (b !=0) set.add(a/b);
                    }
                }
            }
            list.add(set);
            for (int x: set){

            }
        }

        int answer = 0;
        for (int i=1; i<=8; i++){
            if (list.get(i).contains(number)) return i;
        }

        return -1;
    }
}