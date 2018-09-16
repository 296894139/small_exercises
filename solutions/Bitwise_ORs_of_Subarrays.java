import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Bitwise_ORs_of_Subarrays {

    public int subarrayBitwiseORs(int[] A) {
      Set<Integer> res=new HashSet<>(),cur=new HashSet<>(),cur2;
      for(Integer i:A){
          cur2=new HashSet<>();
          cur2.add(i);
          for(Integer u:cur){
              cur2.add(u|i);
          }
          cur=cur2;
          res.addAll(cur);

      }



       return res.size();
    }
  /*  public void get(ArrayList<Integer> l){
        if(l.size()==1){
            if(!result.contains(l.get(0))){
                result.add(l.get(0));
            }
            return;
        }
        int tem=l.get(0);
        for(int i=1;i<l.size();i++){
            tem=tem|l.get(i);
        }
        if(!result.contains(tem)){
            result.add(tem);
        }

        for(int i=0;i<l.size();i++){
            ArrayList<Integer> tem0=new ArrayList<>();
            for(int u=0;u<l.size();u++){
                tem0.add(l.get(u));
            }
            tem0.remove(i);
            System.out.print(tem0);
            get(tem0);
        }
    }*/
    public static  void main(String []args){
        Bitwise_ORs_of_Subarrays s=new Bitwise_ORs_of_Subarrays();
                int A[]={1,2,4};
                System.out.println(s.subarrayBitwiseORs(A));
    }
}
