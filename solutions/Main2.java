import java.util.ArrayList;
import java.util.Scanner;
/*输入任意4个字符(如：abcd)， 并按反序输出(如：dcba)
        输入
        Upin
        cvYj
        WJpw
        cXOA

        输出
        nipU
        jYvc
        wpJW
        AOXc*/
public class Main2 {
      public static void main(String [] args){
          Scanner in=new Scanner(System.in);
          while(in.hasNext()){
              String s=in.next();
              String result="";
              for(int i=s.length()-1;i>=0;i--){
                  result=result+s.charAt(i);

              }
              System.out.println(result);
          }
      }

}
