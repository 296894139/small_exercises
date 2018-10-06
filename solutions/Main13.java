import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @创建人 徐介晖
 * @创建时间 2018/10/6
 * @描述  给定一个点的坐标(x, y)，在输入的n个点中，依次计算这些点到指定点的距离，并按照距离进行从小到大排序，并且输出点的坐标（如果距离相同，将x轴坐标比较小的点排到前面, 如果距离相等且x轴坐标也相同，则将y轴坐标较小的点排到前面）。坐标为int类型，范围为-1000到1000。n 为1到100之间正整数。
 */
public class Main13 {

        int x;
        int y;
        double distance;

    public static void main(String[]args){
        Scanner in=new Scanner(System.in);
        int x=in.nextInt();
        int y=in.nextInt();
        int n=in.nextInt();
        ArrayList<Main13> list=new ArrayList<>();
        for(int i=0;i<n;i++){
           Main13 tem=new Main13();
           tem.x=in.nextInt();
           tem.y=in.nextInt();
           tem.distance=Math.sqrt((x-tem.x)*(x-tem.x)+(y-tem.y)*(y-tem.y));
           list.add(tem);
        }
        Collections.sort(list,new Comparator<Main13>(){
            @Override
            public int compare(Main13 o1,Main13 o2){
                if(o1.distance!=o2.distance){
                    if(o1.distance-o2.distance<0){
                        return -1;
                    }else{
                        return 1;
                    }

                }else if(o1.x!=o2.x){
                    return o1.x-o2.x;
                }else{
                    return o1.y-o2.y;
                }
            }
        });
        for(Main13 tem:list){
            System.out.print("("+tem.x+","+tem.y+") ");
        }
    }
}
