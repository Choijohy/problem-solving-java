package 넓이우선탐색;

import java.util.*;


import java.util.*;

class TransformWord2{
    String target;
    String[] words;
    int len;
    int num;

    public boolean isConvertable(String str1, String str2){
        int diff = 0;
        for (int i=0; i<len; i++){
            if (str1.charAt(i) != str2.charAt(i)) {
                diff ++;
                if (diff > 1) return false;
            }
        }
        return true;
    }
    public int solution(String begin, String target, String[] words){
        this.target = target; // 타겟 단어
        this.words = words; // 단어 집합
        this.len = target.length(); // 단어당 길이
        this.num = words.length; // 총 단어 개수
        boolean[] visited = new boolean[num];

        // words에 target이 포함되지 않은 경우
        boolean flag = false;
        for (int i=0; i<num; i++){
            if (words[i].equals(target)) flag = true;
        }
        if (!flag) return 0;

        // 탐색
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(begin);
        int level = 0; // 변환 횟수

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                String word = queue.poll();
                if (word.equals(target)) return level;
                for (int j=0; j<num; j++){
                    String next = words[j];
                    if (!visited[j] && isConvertable(word, next)){
                        visited[j] = true;
                        queue.offer(next);
                    }
                }
            }
            level++;
        }

        return 0;
    }

}