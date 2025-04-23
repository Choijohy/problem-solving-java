package 구현;

class 지폐_접기 {
    int[] wallet;
    int[] bill;

     public int solution(int[] wallet, int[] bill) {
         this.wallet = wallet;
         this.bill = bill;

         int answer = 0;
         while(!isPossible()){
             int width = bill[0];
             int height = bill[1];

             if (width >= height) bill[0] = width / 2;
             else bill[1] = height/2;
             answer++;
         }
        return answer;
    }

    public boolean isPossible(){
        boolean result = false;

        if (wallet[0] >= bill[0] && wallet[1] >= bill[1]) result = true;
        if (wallet[0] >= bill[1] && wallet[1] >= bill[0]) result = true;
        return result;
    }
}