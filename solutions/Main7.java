import java.util.ArrayList;
import java.util.Scanner;
//玛雅人有一种密码，如果字符串中出现连续的2012四个数字就能解开密码。给一个长度为N的字符串，（2=<N<=13）该字符串中只含有0,1,2三种数字，问这个字符串要移位几次才能解开密码，每次只能移动相邻的两个数字。例如02120经过一次移位，可以得到20120,01220,02210,02102，其中20120符合要求，因此输出为1.如果无论移位多少次都解不开密码，输出-1。
public class Main7 {
    public static void main(String []args){
       /* String a="asddfdfas";
        String t="asd";
        System.out.println(a.matches("(.*)"+t+"(.*)"));
*/

      Scanner in=new Scanner(System.in);
        while(in.hasNext()) {

            int n = in.nextInt();
            String s = in.next();
            if (s.matches("(.*)2012(.*)")) {
                System.out.println(0);
            } else {
            ArrayList<String> list = new ArrayList<String>();
            ArrayList<String> eliminates = new ArrayList<>();
            s="0,"+s;
            list.add(s);
            boolean has = false;
            while (list.size() != 0) {
                String tem_str = list.get(0);
                int time=Integer.parseInt(tem_str.substring(0,1));
                tem_str=tem_str.substring(2);
                eliminates.add(tem_str);
                list.remove(0);
                time++;
                for (int i = 0; i < n - 1; i++) {
                    String new_str = tem_str.substring(0, i);
                    new_str = new_str + tem_str.charAt(i + 1) + tem_str.charAt(i) + tem_str.substring(i + 2);
                    if (new_str.matches("(.*)2012(.*)")) {
                        System.out.println(time);
                        list = new ArrayList<>();
                        has = true;
                        break;
                    } else {
                        if (!eliminates.contains(new_str)) {
                            new_str=time+","+new_str;
                            list.add(new_str);
                        }

                    }
                }
            }
            if (!has) {
                System.out.println(-1);
            }


        }
        }


    }
}
