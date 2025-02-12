package 스택큐;

import java.util.*;
import java.io.*;

public class RemoveParentheses {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    Deque<Character> stack = new ArrayDeque<>();
    for (char x: str.toCharArray()){
    	if (x == ')'){
          	char c = stack.pop();
          	while (c != '('){c = stack.pop();}
        }
        else stack.push(x);
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()){
    	sb.append(stack.pop());
    }
    System.out.println(sb.reverse().toString());
    return ;
  }
}