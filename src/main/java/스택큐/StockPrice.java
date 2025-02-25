package 스택큐;
import java.util.*;

public class StockPrice{
    public int[] solution(int[] prices){
        int len = prices.length;
        int[] result = new int[len];
        Deque<Stock> stack = new ArrayDeque<>();

        // 초기값
        Stock first = new Stock(0, prices[0]);
        stack.push(first);


        for (int i=1; i<len; i++){
            Stock stock = new Stock(i, prices[i]);
            while (!stack.isEmpty() && stack.peek().price > stock.price){
                Stock removed = stack.pop();
                result[removed.day] = stock.day - removed.day;
            }
            stack.push(stock);
        }

        int last = len-1;
        while(!stack.isEmpty()){
            Stock stock = stack.pop();
            result[stock.day] = last - stock.day;
        }


        return result;
    }
}

class Stock{
    int day;
    int price;
    Stock(int day, int price){
        this.day = day;
        this.price = price;
    }
}