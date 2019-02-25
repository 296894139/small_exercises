import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @创建人 徐介晖
 * @创建时间 2019/2/25
 * @描述
 */
public class leetcode967 {
    public int[] numsSameConsecDiff(int N, int K) {
        if(N==1){
            int a[]={0,1,2,3,4,5,6,7,8,9};
            return a;
        }
        Set<Integer> list=new HashSet<>();
        for(int i=1;i<=9;i++){
            ArrayList<String> tem0=get(i,N,K);
            for(int u=0;u<tem0.size();u++){
                list.add(Integer.parseInt(tem0.get(u)));
            }

        }
        int n=list.size();
        int result[]=new int[n];
        Iterator<Integer> iter=list.iterator();
        int i=0;
        while(iter.hasNext()){
            result[i]=iter.next();
            i++;
        }
        return result;
    }
    public ArrayList<String> get(int start,int n,int k){
        ArrayList<String> list=new ArrayList<String>();
        if(n==1){
            list.add(start+"");
            return list;
        }
        if(start+k<10){
            ArrayList<String> tem1=get(start+k,n-1,k);
            for(int i=0;i<tem1.size();i++){
                list.add(start+tem1.get(i));
            }
        }
        if(start-k>=0){
            ArrayList<String> tem2=get(start-k,n-1,k);
            for(int i=0;i<tem2.size();i++){
                list.add(start+tem2.get(i));
            }
        }
        return list;
    }
}
