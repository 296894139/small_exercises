import java.util.ArrayList;
import java.util.List;

/**
 * @创建人 徐介晖
 * @创建时间 2018/9/23
 * @描述
 */
public class leetcode126 {
    List<List<String>> result=new ArrayList<List<String>>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
                    if(!wordList.contains(endWord)) return  result;
                    List<String> ways=new ArrayList<String>() ;
                    ways.add(beginWord);
                    wordList.remove(beginWord);

                    reverse(beginWord,endWord,wordList,ways);
                    return result;

    }
    public void reverse(String tem,String goal,List<String> temwordList,List<String> ways){
        if(result.size()!=0){
            if(ways.size()>=result.get(0).size()){
                return ;
            }
        }
        if((isOneCharDiff(goal,tem))){
            ways.add(goal);

            if((result.size()!=0)&&(ways.size()<result.get(0).size())){
                result=new ArrayList<List<String>>();
                result.add(ways);
            }else{
                result.add(ways);
            }

            return;
        }
               for(int i=0;i<temwordList.size();i++){
                   String word=temwordList.get(i);
                   if(isOneCharDiff(word,tem)){
                       List<String> tem_way=new ArrayList<>();
                       List<String> tem_wordlist=new ArrayList<>();
                       for(int u=0;u<ways.size();u++){
                           tem_way.add(ways.get(u));
                       }
                       for(int u=0;u<temwordList.size();u++){
                           tem_wordlist.add(temwordList.get(u));
                       }
                           tem_way.add(word);
                           tem_wordlist.remove(word);
                           reverse(word,goal,tem_wordlist,tem_way);
                   }

               }

    }
    public boolean isOneCharDiff(String a,String b){
        int diff=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                diff++;
            }
        }
        if(diff==1){
            return true;
        }
        return false;
    }
    public static void main(String[]a){
        leetcode126 s=new leetcode126();
       List<String> wordList =new ArrayList<>();
       wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println(s.findLadders("hit","cog",wordList));
    }
}
