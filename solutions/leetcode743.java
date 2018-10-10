import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @创建人 徐介晖
 * @创建时间 2018/10/10
 * @描述   There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.
 */
public class leetcode743 {
    public int networkDelayTime(int[][] time, int N, int K) {
        int times[][]=new int[N][N];
        for(int i=0;i<N;i++){
            for(int u=0;u<N;u++){
                times[i][u]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<time.length;i++){
            int u=time[i][0];
            int v=time[i][1];
            int val=time[i][2];
            times[u-1][v-1]=val;
            times[v-1][u-1]=val;
        }
        /*for(int i=0;i<N;i++){
            for(int u=0;u<N;u++){
                System.out.println(times[i][u]+"  "+i+"  "+u+"    ");
            }
        }*/
           int d[]=new int[N];
           int marks[]=new int[N];
        Arrays.fill(marks,0);
        Arrays.fill(d,0);
        marks[K-1]=1;
        for(int u=1;u<N;u++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < N; i++) {
                if (K-1!=i&& marks[i] == 0 && times[K-1][i]!=Integer.MAX_VALUE && times[K-1][i] < min) {
                    min = times[K-1][i];
                    index = i;
                }
            }

            if(index!=-1){
                d[index] = min;
                marks[index] = 1;
                for (int i = 0; i < N; i++) {
                    if (K-1!=i&&times[i][index]!=Integer.MAX_VALUE && marks[i] == 1 && d[index] > d[i] + times[i][index]) {
                        d[index] = d[i] + times[i][index];
                    }
                }
            }else{
                for(int i=0;i<N;i++){
                    if(K-1!=i && marks[i] != 1 &&times[K-1][i]==Integer.MAX_VALUE){
                        index=i;
                        break;
                    }
                }
                for(int i=0;i<N;i++){
                    if (K-1!=i&&times[i][index]!=Integer.MAX_VALUE && marks[i] == 1 && times[i][index]!=Integer.MAX_VALUE) {
                        d[index] = d[i] + times[i][index];
                        marks[index]=1;
                    }

                }

            }





        }
          int result=0;
        for(int i=0;i<N;i++){
           System.out.println(d[i]+"  "+i);
            if(i!=K-1){
                if(d[i]==0) return -1;
                if(d[i]>result){
                    result=d[i];
                }
            }
        }
        return result;
    }
    public static void main(String []args){
        leetcode743 s=new leetcode743();
        int[][]a={{1,2,1}};
        System.out.println(s.networkDelayTime(a,2,2));
    }
}
