import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @创建人 徐介晖
 * @创建时间 2018/10/1
 * @描述 Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.
 */
public class leetcode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Map<Integer,ArrayList<ArrayList<Integer>>> map=new HashMap<>();
        ArrayList<ArrayList<Integer>> tem2=new ArrayList<ArrayList<Integer>>();
        map.put(0,tem2);
        for(int i:candidates){
            ArrayList<Integer> tem=new ArrayList<>();
            tem.add(i);
            ArrayList<ArrayList<Integer>> tem3=new ArrayList<>();
            tem3.add(tem);
            map.put(i,tem3);
        }
       // System.out.println(map);
        for(int i=1;i<=target;i++){
            for(int u:candidates){
                int now_num=i-u;
                if((now_num>0)&&(map.containsKey(now_num))){
                    ArrayList<ArrayList<Integer>> list0=map.getOrDefault(i,new ArrayList<ArrayList<Integer>>());
                    ArrayList<ArrayList<Integer>> list=new ArrayList<>();//map.get(now_num);
                    for(ArrayList<Integer> tem0:map.get(now_num)){
                        ArrayList<Integer> tem22=new ArrayList<>();
                        for(int tem1:tem0){
                            tem22.add(tem1);
                        }
                        list.add(tem22);
                    }
                    ArrayList<ArrayList<Integer>> list2=new ArrayList<ArrayList<Integer>>();
                    for(ArrayList<Integer> tem:list){
                        tem.add(u);
                        list2.add(tem);
                    }


                    for(ArrayList<Integer> tem:list2){
                        if(! has(list0,tem)){
                            list0.add(tem);
                        }
                    }
                 /*   if(i==16){
                        System.out.println(i);
                        System.out.println(list0);
                        System.out.println(list2);

                    }*/

                    map.put(i,list0);
                }

            }
        }


        ArrayList<ArrayList<Integer>> result0=map.get(target);
        if(result0==null){
            List<List<Integer>> re=new ArrayList<>();
            return re;
        }
       // System.out.println(map);
        List<List<Integer>> result=new ArrayList<>();
        for(int u=0;u<result0.size();u++){
            ArrayList<Integer> list12=result0.get(u);
            List<Integer> li=new ArrayList<>();
            for(int i:list12){
                li.add(i);
            }
            result.add(li);
        }
        return result;

    }
    public static boolean has(ArrayList<ArrayList<Integer>> list,ArrayList<Integer> list2){
        for(ArrayList<Integer> tem:list){
            if(tem.size()==list2.size()){
                boolean has=true;
                Map<Integer,Integer> m=new HashMap<>();
                for(int tem00:list2){
                    int n=m.getOrDefault(tem00,0);
                    m.put(tem00,n+1);
                }
                for(int i=0;i<tem.size();i++){
                    int a=tem.get(i);
                  int n=m.getOrDefault(a,-1);
                  if(n<=0){
                      has=false;
                  }else{
                      m.put(a,n-1);
                  }
                }
                if(has){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[]args){
        leetcode39 l=new leetcode39();
        int a[]={4,5,2};
        System.out.println(l.combinationSum(a,16));
    }
}
