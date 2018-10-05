import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @创建人 徐介晖
 * @创建时间 2018/10/3
 * @描述  N只小白鼠(1 <= N <= 100)，每只鼠头上戴着一顶有颜色的帽子。现在称出每只白鼠的重量，要求按照白鼠重量从大到小的顺序输出它们头上帽子的颜色。帽子的颜色用“red”，“blue”等字符串来表示。不同的小白鼠可以戴相同颜色的帽子。白鼠的重量用整数表示
 */
public class Main12{

        public int weight;
        public String color;

    public static void main(String []args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        ArrayList<Main12> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            Main12 m=new Main12();

            m.weight=in.nextInt();
            m.color=in.next();
            list.add(m);
        }
        Collections.sort(list, new Comparator<Main12>() {
            @Override
            public int compare(Main12 o1, Main12 o2) {
                return o2.weight-o1.weight;
            }
        });


        for(Main12 m:list){
            System.out.println(m.color);
        }
    }

}
