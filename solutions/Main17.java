import java.util.*;

/**
 * @创建人 徐介晖
 * @创建时间 2018/10/8
 * @描述  假设城市中一共有N幢建筑排成一条线，每幢建筑的高度各不相同。初始时，怪盗基德可以在任何一幢建筑的顶端。他可以选择一个方向逃跑，但是不能中途改变方向（因为中森警部会在后面追击）。因为滑翔翼动力装置受损，他只能往下滑行（即：只能从较高的建筑滑翔到较低的建筑）。他希望尽可能多地经过不同建筑的顶部，这样可以减缓下降时的冲击力，减少受伤的可能性。请问，他最多可以经过多少幢不同建筑的顶部（包含初始时的建筑）？
 */
public class Main17 {
    static int max;
   static void test0(ArrayList<Integer> list,int i,int min,int tem_num){
       if(i>=list.size()){
           if(tem_num>max){
               max=tem_num;
           }
           return;
       }
       if(list.get(i)>min){
           return;
       }else{
           test0(list,i+1,min,tem_num);
           test0(list,i+1,list.get(i),tem_num+1);
       }
   }
    static void test1(ArrayList<Integer> list,int i,int min,int tem_num){
        if(i<0){
            if(tem_num>max){
                max=tem_num;
            }
            return ;
        }
        if(list.get(i)>min){
            return;
        }else{
            test1(list,i-1,min,tem_num);
            test1(list,i-1,list.get(i),tem_num+1);
        }
    }
    public static void main(String[]args){
         Scanner in=new Scanner(System.in);
         int k=in.nextInt();
         for(int i=0;i<k;i++){
             max=0;
             int n=in.nextInt();
             ArrayList<Integer> list=new ArrayList<>();
             for(int u=0;u<n;u++){
                 list.add(in.nextInt());
             }
             test0(list,0,10000,0);
             test1(list,list.size()-1,10000,0);
              System.out.println(max);

         }
    }
}
