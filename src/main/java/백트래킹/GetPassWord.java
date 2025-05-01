package 백트래킹;
import java.io.*;
import java.util.*;

public class GetPassWord {
    static int L, C;
    static char[] arr;

    private static boolean isVowel(char c){
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        return vowels.contains(c);
    }

    private static void dfs(int count, int next, StringBuilder password, int con, int vow){
        if (count == L){
            if(con >= 2 && vow >= 1) {
                System.out.println(password.toString());
            }
            return;
        }

        if (C-next < L - count) return;

        for (int i=next; i<C; i++){
            char c = arr[i];
            if (isVowel(c)) dfs(count+1, i+1, password.append(c), con, vow+1);
            else dfs(count+1, i+1, password.append(c), con+1, vow);
            password.deleteCharAt(password.length()-1);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        L = Integer.parseInt(str[0]); // 암호 개수
        C = Integer.parseInt(str[1]); // 알파벳 개수

        str = br.readLine().split(" ");
        arr = new char[C];
        for (int i=0; i<C; i++){
            arr[i] = str[i].charAt(0);
        }
        // 알파벳순 정렬
        Arrays.sort(arr);

        for (int i=0; i<=C-L;i++){
            StringBuilder password = new StringBuilder();
            char c = arr[i];
            if (isVowel(c)) dfs(1, i+1, password.append(c), 0, 1);
            else dfs(1, i+1, password.append(c), 1, 0);
        }

    }
}

