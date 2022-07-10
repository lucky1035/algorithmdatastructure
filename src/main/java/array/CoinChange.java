package array;

import java.util.Arrays;
 

public class CoinChange {

//    public int coinChange(int[] coins, int amount) {
//
//        if(amount==0) return 0;
//        int index = coins.length - 1;
//        Arrays.sort(coins);
//
//        int result = findCoin(coins,index,amount);
//        return result;
//
//
//    }
//
//    private int findCoin(int[] coins, int index, int amount) {
//        if(index<0){
//            return -1;
//        }
//        int sum = 0;
//        count = 0 ;
//        int tmpIndex = index ;
//        while (tmpIndex>=0) {
//            if(sum==amount){
//                return count;
//            }
//            int tmp = coins[tmpIndex];
//            if ((amount - sum) < tmp) {
//                tmpIndex--;
//                continue;
//            }else {
//                sum +=tmp;
//                count++;
//            }
//        }
//        return findCoin(coins,index-1,amount);
//
//    }



    public int coinChange(int[] coins, int amount) {
        int count = 0;
        if(amount==0) return 0;
        int index = coins.length - 1;
//        Arrays.sort(coins);

        int result = coinChange(coins,amount,new int[amount+1]  );
//        int result = calc(coins,new int[amount+1] ,amount );
        return result;
    }


    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

    private int calc(int[] coins, int[] counts, int amount) {
        if (amount<0) return -1;
        if(amount == 0 ) return 0;

        if(counts[amount] !=0 ){
            return counts[amount];
        }
        int min  = Integer.MAX_VALUE;
        for(int coin : coins){
            int res= calc(coins,counts,amount-coin);
            if(res > 0 && res<min ){
                min = res +1 ;
            }
        }

        coins[amount]  = (min == Integer.MAX_VALUE)? -1:min;
        return coins[amount] ;
    }

//    private int calc(int[] coins, int index, int amount,int count) {
//        if(index<0){
//            return -1;
//        }
//        int coin =  coins[index];
//        int amt = amount/coin;
//        for(int i = 0 ;i <=amt ;i++){
//            int remain = amount - i* amt;
//            count +=i;
//            if(remain==0){
//                return count;
//            }else if(remain>0){
//               int countTmp  = calc(coins,index-1,remain,count);
//               if(-1==countTmp) return -1;
//               count +=countTmp;
//            }else {
//                return -1;
//            }
//        }
//        return count;
//    }

    public static void main(String[] args) {
        System.out.println(9/2);

        int[] a = { 186,419,83,408 };
        int amount = 6249 ;
//        int[] a = {1, 2, 5};
//        int amount = 11;
        System.out.println(new CoinChange().coinChange(a,amount));
    }
}
