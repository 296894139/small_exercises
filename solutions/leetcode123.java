import java.util.ArrayList;

/**
 * @创建人 徐介晖
 * @创建时间 2018/10/31
 * @描述  Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.
 */
public class leetcode123 {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int result=0;
    int small=0;
    int big=0;
    int max=0;
    for(int i=0;i<prices.length-1;i++){
        for(int u=i+1;u<prices.length;u++){
            if(prices[u]-prices[i]>max){
                max=prices[u]-prices[i];
                small=i;
                big=u;
            }
        }
    }
    result=max;

    int small2=0;
    int big2=0;
    max=0;
    for(int i=0;i<prices.length;i++){

    }




    /*    int length=prices.length;
        if(length==0){
            return 0;
        }
        ArrayList<Integer> list=new ArrayList<>();
        int small=0;
        int big=0;
        for(int i=1;i<length;i++){
            if(prices[i]>prices[big]){
                big=i;
            }else if(prices[i]<prices[big]){
              //  System.out.println("small:"+small+"  big:"+big+"   i:"+i);
                list.add(prices[big]-prices[small]);
                small=i;
                big=i;
            }
        }
        list.add(prices[big]-prices[small]);
        if(list.size()==0){
            return 0;
        }else if(list.size()==1){
            return list.get(0);
        }else if(list.size()==2){
            return list.get(0)+list.get(1);
        }else{
            int x=Math.min(list.get(0),list.get(1));
            int y=Math.max(list.get(0),list.get(1));
            for(int i=2;i<list.size();i++){
                if(list.get(i)>x){
                    x=Math.min(y,list.get(i));
                    y=Math.max(y,list.get(i));
                }
            }
           return x+y;
        }
      */
    return 0;
    }
    public static void main(String []args){
        leetcode123 t=new leetcode123();
        int[] a={1,2,4,2,5,7,2,4,9,0};
        t.maxProfit(a);
    }
}
