import java.util.ArrayList;

/**
 * @创建人 徐介晖
 * @创建时间 2018/10/2
 * @描述  Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.

You are given several projects. For each project i, it has a pure profit Pi and a minimum capital of Ci is needed to start the corresponding project. Initially, you have W capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.

To sum up, pick a list of at most k distinct projects from given projects to maximize your final capital, and output your final maximized capital.
 */
public class leetcode502 {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
              int max[]=new int[k+1];
              max[0]=0;
              int maxprofit=-1;
              int index=-1;
              for(int i=0;i<Profits.length;i++){
                  if((Capital[i]<=W)&&(Profits[i]>maxprofit)){
                      index=i;
                      maxprofit=Profits[i];
                  }
              }
              if(index==-1){
                  return 0;
              }
              max[1]=maxprofit+W;
              ArrayList<Integer> has=new ArrayList<Integer>();
              has.add(index);
              for(int i=2;i<=k;i++){
                  maxprofit=-1;
                  index=-1;
                  for(int u=0;u<Profits.length;u++){
                      if((!has.contains(u))&&(Capital[u]<=max[i-1])&&(Profits[u]>maxprofit)){
                          index=u;
                          maxprofit=Profits[u];
                      }
                  }
                  if(index==-1){
                      return max[i-1];
                  }else{
                      max[i]=maxprofit+max[i-1];
                      has.add(index);
                  }



              }
              for(int i=0;i<=k;i++){
                  System.out.println(max[i]);
              }
              return max[k];


    }
    public static void main(String[]args){
        leetcode502 s=new leetcode502();
        int a[]={1,2,3};
        int b[]={1,1,2};
        System.out.println(s.findMaximizedCapital(1,2,a,b));

    }
}
