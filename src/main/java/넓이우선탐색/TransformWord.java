package 넓이우선탐색;

/*
문제: 프로그래머스 카펫(https://school.programmers.co.kr/learn/courses/30/lessons/43163)
레벨: 3
자료구조:
    - 큐
    - 인접행렬
알고리즘:
    - BFS: 특정 노드로 가는 "최단 경로" 탐색
    - 초기화 과정에서 N*N(N:target 포함 단어 개수)의 시간을 들여, 인접행렬을 만들지 않아도 됨. 미리 그래프를 만들지 않고,
    다른 풀이를 보면 BFS 탐색을 하면서, 변환 가능한 관계인지를 그때그때 판단하여 탐색하도록 한 풀이가 많았음(단어개수만큼 loop 돌면서)
    -> 그래프 생성을 위한 전처리 시간과 메모리 절약 가능해서 더 효율적인 풀이임.
    대신, 인접행렬이 없으면 중복 계산이 필요하게 될 수도 있고, 단어의 수가 많을때는 미리 행렬을 만들어 두는게 적합해 보임(본 문제는 단어 개수 50개로 제한)
*
*/

import java.util.*;

public class TransformWord {
    public static void main (String[] args){
        TransformWord transformWord = new TransformWord();
        Solution solution = transformWord.new Solution();

        System.out.println(solution.solution("hit","cog",new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(solution.solution("hit","cog",new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    class Solution{
        int size;
        int beginIndex;
        int targetIndex;
        boolean[][] graph;
        boolean[] visited;
        HashMap<Integer, String> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int count = -1;

        public int solution(String begin, String target, String[] inputWords){
            String[] words = new String[inputWords.length+1];
            words[0] = begin;
            System.arraycopy(inputWords, 0, words,1,inputWords.length);

            size = words.length;
            beginIndex = 0;
            targetIndex = 0;

            // 단어별 인덱스 추출용
            for (int i=0; i<size;i++){
                map.put(i, words[i]);
                if (words[i].equals(target)) targetIndex = i;
            }

            graph = new boolean[size][size];

            // BFS 탐색을 위한 인접 행렬 생성
            for(int i=0; i<size; i++){
                for (int j=0; j<size;j++){
                    // 두 개의 단어가 같거나, 알파벳 1개만 차이나는 경우
                    if (this.checkIfCanTransform(map.get(i), map.get(j))){
                        graph[i][j] = true;
                    }
                }
            }

            // BFS 탐색을 위한 자료형 생성
            visited = new boolean[size];
            queue.add(beginIndex);
            visited[beginIndex] = true;

            // BFS 탐색
            while(!queue.isEmpty()){
                count++;
                if (bfs(queue.size(),target)){
                    return count;
                }
            }

            return 0;
        }

        public boolean bfs(int num,String target){
            for (int i=0; i<num;i++){
                int current = queue.poll();

                if (map.get(current).equals(target)){
                    return true;
                }

                for (int j=0; j<size; j++){
                    if (graph[current][j] == true && visited[j] == false){
                        queue.add(j);
                        visited[j] = true;
                    }
                }
            }
            return false;
        }
        public boolean checkIfCanTransform(String word1, String word2){
            // 모든 input 단어의 길이는 동일한걸로 전제
            int size = word1.length();
            int count = 0;
            for (int i=0; i<size; i++){
                if (word1.charAt(i) != word2.charAt(i)){
                    count ++;
                }
            }
            return count <= 1;
        }
    }
}
