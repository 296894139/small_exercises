import java.util.Scanner;

/**
 * @创建人 徐介晖
 * @创建时间 2018/10/14
 * @描述  输入一个字符串，以回车结束（字符串长度<=100）。该字符串由若干个单词组成，单词之间用一个空格隔开，所有单词区分大小写。现需要将其中的某个单词替换成另一个单词，并输出替换之后的字符串。
 */
public class Main21 {
    public static void main(String[]args){
        Scanner in =new Scanner(System.in);

        while(in.hasNext()){
            String str=in.nextLine();
            String first=in.next();
            String second=in.next();
            String []strs=str.split(" ");
            int length=strs.length;
            for(int i=0;i<length;i++){
                if(strs[i].equals(first)){
                    strs[i]=second;
                }
            }
            for(int i=0;i<length-1;i++){
                System.out.print(strs[i]+" ");
            }
            System.out.print(strs[length-1]);
            System.out.println();

        }



    }
}
