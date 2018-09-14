import java.util.ArrayList;
import java.util.List;

class Solution4 {
    public List<String> generateParenthesis(int n) {
        List<String> list=does(n,0,0,"");

        return list;
    }
    public ArrayList<String>  does(int n,int left,int right,String tem){
        if(left<n){
            ArrayList<String> tem0=does(n,left+1,right,tem+"(");
            ArrayList<String> tem1=new ArrayList<>();
            if(left>0&&left>right){
                tem1=does(n,left,right+1,tem+")");
            }
            for(int i=0;i<tem1.size();i++){
                tem0.add(tem1.get(i));
            }
            return tem0;

        }else {
            if(right==n){
                ArrayList<String> tem0=new ArrayList<>();
                tem0.add(tem);
                return tem0;
            }else{
                ArrayList<String> tem1=does(n,left,right+1,tem+")");
                return tem1;

            }

        }

    }
    public static  void main(String []args){
        Solution4 s=new Solution4();
        System.out.println(s.generateParenthesis(3));

    }
}
