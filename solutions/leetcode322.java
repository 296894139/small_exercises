import java.util.*;

/**
 * @创建人 徐介晖
 * @创建时间 2018/9/26
 * @描述  You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 */
public class leetcode322 {
    Map<Integer,Integer> small_num=new HashMap<>();
    public int coinChange(int[] coins, int amount) {
         if(amount==0) return 0;
        for(int i=0;i<coins.length;i++){
            small_num.put(coins[i],1);
        }
       int result= get(amount,coins);
        return result;
    }
    public int get(int amount,int coins[]){
        int small=1000000;
       if((small_num.containsKey(amount))&&(small_num.get(amount)!=-1)){
           return small_num.get(amount);
       }



        for(int i=0;i<coins.length;i++){
            int tem=amount-coins[i];
            if(tem>0) {
                if (small_num.containsKey(tem)) {
                    int tem_small = small_num.get(tem) + 1;
                    if ((tem_small != 0) && (tem_small < small)) {
                        small = tem_small;
                    }
                } else {
                    int tem_small = get(tem, coins) + 1;
                    if (tem_small != 0) {
                        small_num.put(tem, tem_small - 1);
                        if (tem_small < small) {
                            small = tem_small;
                        }
                    }

                }
            }
        }
        if(small==1000000){
            small_num.put(amount,-1);
            return -1;
        }
        small_num.put(amount,small);
        return small;
    }
   public static void main(String []args){
        leetcode322 s=new leetcode322();
        int []coins={1,2,5};
        System.out.println(s.coinChange(coins,11));
   }

}
