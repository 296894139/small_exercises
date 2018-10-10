import java.util.*;

/**
 * @创建人 徐介晖
 * @创建时间 2018/10/10
 * @描述  There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.

Now given all the cities and fights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 */
public class leetcode787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
              int cost[]=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src]=0;
        Queue<Integer> q=new LinkedList<Integer>();

        q.add(src);
        int s=0;
        while(!q.isEmpty()){

            int size=q.size();
            for(int i=0;i<size;i++){
                int now=q.poll();
                for(int a[]:flights){
                    if(s==K&& a[1]!=dst){
                        continue;
                    }
                    if(a[0]==now && cost[a[1]]>cost[a[0]]+a[2]){
                        cost[a[1]]=cost[a[0]]+a[2];
                        q.add(a[1]);
                    }
                }
            }

            s++;
        }
           return cost[dst]==Integer.MAX_VALUE ? -1 :cost[dst];

    }
}
