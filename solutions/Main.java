import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> names=new ArrayList<>();
    static ArrayList<Integer> grades=new ArrayList<>();
    public static void main(String []args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()) {
            names=new ArrayList<>();
            grades=new ArrayList<>();
            int num = in.nextInt();
            int shunxu = in.nextInt();
            for (int i = 0; i < num; i++) {
                String name = in.next();
                int grade = in.nextInt();
                names.add(name);
                grades.add(grade);
            }
            if (shunxu == 0) {
                zeroSort();
            } else {
                OneSort();
            }
            for (int i = 0; i < num; i++) {
                System.out.print(names.get(i) + " ");
                System.out.println(grades.get(i));
            }
        }
    }
    static void OneSort(){
        for(int i=0;i<grades.size();i++){
            for(int u=0;u<grades.size()-1;u++){
                if(grades.get(u)>grades.get(u+1)){
                    int tem_n=grades.get(u);
                    String tem_name=names.get(u);
                    grades.set(u,grades.get(u+1));
                    names.set(u,names.get(u+1));
                    grades.set(u+1,tem_n);
                    names.set(u+1,tem_name);
                }
            }
        }
    }
    static void zeroSort(){
        for(int i=0;i<grades.size();i++){
            for(int u=0;u<grades.size()-1;u++){
                if(grades.get(u)<grades.get(u+1)){
                    int tem_n=grades.get(u);
                    String tem_name=names.get(u);
                    grades.set(u,grades.get(u+1));
                    names.set(u,names.get(u+1));
                    grades.set(u+1,tem_n);
                    names.set(u+1,tem_name);
                }
            }
        }
    }
    static void nisort(int start,int end){
        if(start>=end){
            return;
        }
        int tem_start=start;
        int tem_end=end;
        int place=start;
        int n=grades.get(start);
        for(int i=start+1;i<=end;i++){
            if(grades.get(i)>n){
                place=i;
                int tem_i=grades.get(i);
                String tem_name=names.get(i);
                for(int u=i;u>start;u--){
                    grades.set(u,grades.get(u-1));
                    names.set(u,names.get(u-1));
                }
                grades.set(start,tem_i);
                names.set(start,tem_name);
            }

        }
        nisort(tem_start,place-1);
        nisort(place+1,tem_end);



    }
    static void shunsort(int start,int end){
        if(start>=end){
            return;
        }
        int tem_start=start;
        int tem_end=end;
        int place=start;
        int n=grades.get(start);
        for(int i=start+1;i<=end;i++){
            if(grades.get(i)<n){
                place=i;
                int tem_i=grades.get(i);
                String tem_name=names.get(i);
                for(int u=i;u>start;u--){
                    grades.set(u,grades.get(u-1));
                    names.set(u,names.get(u-1));
                }
                grades.set(start,tem_i);
                names.set(start,tem_name);
            }

        }
        shunsort(tem_start,place-1);
        shunsort(place+1,tem_end);



    }
}


       /* import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Comparator;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;
        import java.util.Map.Entry;
        import java.util.Scanner;
        import java.util.jar.Attributes.Name;

/*public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext())
        {
            int numPeople=scanner.nextInt();
            int option=scanner.nextInt();

            List<Student> stuList=new ArrayList<Student>();
            for(int i=0;i<numPeople;i++)
            {
                stuList.add(new Student(scanner.next(), scanner.nextInt()));
            }

            //降序
            if(option==0)
            {
                Collections.sort(stuList, new Comparator<Student>()
                {
                    public int compare(Student o1,Student o2)
                    {
                        return o2.score-o1.score;
                    }
                });
            }
            else if(option==1)//升序
            {
                Collections.sort(stuList, new Comparator<Student>()
                {
                    public int compare(Student o1,Student o2)
                    {
                        return o1.score-o2.score;
                    }
                });
            }
            for(int i=0;i<stuList.size();i++)
            {
                System.out.println(stuList.get(i).name+" "+stuList.get(i).score);
            }
        }
    }
}

class Student
{
    public String name;
    public int score;
    public Student(String name,int score)
    {
        this.name=name;
        this.score=score;
    }
}*/