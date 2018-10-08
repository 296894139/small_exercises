import java.util.ArrayList;
import java.util.Scanner;

/**
 * @创建人 徐介晖
 * @创建时间 2018/10/8
 * @描述  在数据压缩中，一个常用的方法是行程长度编码压缩。对于一个待压缩的字符串，我们可以依次记录每个字符及重复的次数。例如，待压缩的字符串为"aaabbbbcbb"，压缩结果为(a,3)(b,4)(c,1)(b,2)。这种压缩对于相邻数据重复较多的情况有效，如果重复状况较少，则压缩的效率较低。

现要求根据输入的字符串，首先将字符串中所有大写字母转化为小写字母，然后将字符串进行压缩。
 */
public class Main16 {
    public static void main(String[]args){
        Scanner in=new Scanner(System.in);
        String str=in.next();
        str=str.toLowerCase();
        int length=str.length();
        ArrayList<Character> list1=new ArrayList<>();
        ArrayList<Integer>  list2=new ArrayList<>();
        char before=' ';
        for(int i=0;i<length;i++){
            char tem_char=str.charAt(i);
            if(tem_char==before){
                list2.set(list2.size()-1,list2.get(list2.size()-1)+1);
            }else{
                list1.add(tem_char);
                list2.add(1);
                before=tem_char;
            }
        }

        for(int i=0;i<list1.size();i++){
            System.out.println(list1.get(i)+" "+list2.get(i));
        }
    }
}
