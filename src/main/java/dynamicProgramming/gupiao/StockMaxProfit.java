package dynamicProgramming.gupiao;

public class StockMaxProfit {

    public int maxProfit(int[] prices) {
        int profit = 0 ;

        for(int i = 1 ;i<prices.length ;i++){
            if(prices[i]>prices[i-1]){
                profit +=prices[i] - prices[i-1] ;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int a [] = {7,6,4,3,1};
       int value =  new StockMaxProfit().maxProfit(a);
        System.out.println(value);
    }
}
