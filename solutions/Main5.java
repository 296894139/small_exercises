import java.util.*;

//用一维数组存储学号和成绩，然后，按成绩排序输出。
/*输入第一行包括一个整数N(1<=N<=100)，代表学生的个数。
        接下来的N行每行包括两个整数p和q，分别代表每个学生的学号和成绩。*/
public class Main5 {

    public static void main(String []args){
          Scanner in=new Scanner(System.in);
          while(in.hasNext()) {
              int n = in.nextInt();
              ArrayList<student> list = new ArrayList<>();
              for (int i = 0; i < n; i++) {
                  int id0 = in.nextInt();
                  int grade0 = in.nextInt();
                  list.add(new student(id0, grade0));

              }
              Collections.sort(list, new Comparator<student>() {
                  @Override
                  public int compare(student o1, student o2) {
                      if(o1.grade!=o2.grade){
                          return o1.grade - o2.grade;
                      }else{
                          return o1.id-o2.id;
                      }

                  }
              });
              for (int i = 0; i < list.size(); i++) {
                  System.out.print(list.get(i).id + " ");
                  System.out.println(list.get(i).grade);
              }

          }

    }

}
class student{
    student(int a,int b){
        id=a;
        grade=b;
    }
    public int id;
    public int grade;
}
