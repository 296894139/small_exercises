import java.util.Scanner;

/**
 * @创建人 徐介晖
 * @创建时间 2018/10/6
 * @描述  编写程序，读入一行英文(只包含字母和空格，单词间以单个空格分隔)，将所有单词的顺序倒排并输出，依然以单个空格分隔。
 */
public class Main14 {
    public static void main(String[]args){
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        String[] ss=s.split(" ");
        for(int i=ss.length-1;i>=0;i--){
            System.out.print(ss[i]+" ");
        }
    }
}
