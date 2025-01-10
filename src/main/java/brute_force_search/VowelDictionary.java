package brute_force_search;

import java.util.ArrayList;
import java.util.List;

public class VowelDictionary {
    public static void main(String[] args){
        VowelDictionary vowelDictionary = new VowelDictionary();
        Solution solution = vowelDictionary.new Solution();

        System.out.println(solution.solution("AAAAE"));
        System.out.println(solution.solution("AAAE"));
        System.out.println(solution.solution("I"));
        System.out.println(solution.solution("A"));
        System.out.println(solution.solution("EIO"));


    }

    class Solution {
        Character[] vowels = new Character[]{'A', 'E', 'I', 'O', 'U'};
        List<String> dictionary = new ArrayList<>();

        public int solution(String target) {
            makeWords("");

            int index = -1; // 단어 사전의 맨 앞이 ""부터 시작하므로
            for (String word:dictionary){
                index ++;
                if (word.equals(target)) return index;
            }
            return 0;
        }


        public void makeWords(String word) {
            dictionary.add(word);
            if (word.length() == 5) return;

            for(Character vowel :vowels){
               makeWords(word+vowel);
            }
        }
    }
}
