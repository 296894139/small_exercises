import java.util.ArrayList;
import java.util.List;

/**
 * @创建人 徐介晖
 * @创建时间 2019/2/24
 * @描述
 */
public class leetcode728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result=new ArrayList<Integer>();
        int i=left;
        while(i<=right){
             if(tem(i)){
                 result.add(i);
             }
             i++;
        }
        return result;
    }

    public boolean tem(int e){
        String str=e+"";
        for(int i=0;i<str.length();i++){
            int a=-1;
            
            int index=Integer.parseInt(str.charAt(i)+"");
            if(index==0){
                return false;
            }else{
                if((e%index)!=0){
                    return false;
                }
            }
        }
        return true;
    }
}
