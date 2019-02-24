import java.util.ArrayList;
import java.util.List;

/**
 * @创建人 徐介晖
 * @创建时间 2019/2/24
 * @描述
 */
public class leetcode539 {
    public int findMinDifference(List<String> timePoints) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(String s:timePoints){
            list.add(getTime(s));
        }
        int min=10000000;
        for(int i=0;i<list.size()-1;i++){

            for(int u=i+1;u<list.size();u++){
                int tem_min=Math.abs(list.get(i)-list.get(u));
                tem_min=Math.min(tem_min,24*60-tem_min);
                min=Math.min(tem_min,min);

            }
        }
        return min;
    }
    public int getTime(String s){
        int hour=Integer.parseInt(s.split(":")[0]);
        int mimute=Integer.parseInt(s.split(":")[1]);
        return hour*60+mimute;
    }
}
