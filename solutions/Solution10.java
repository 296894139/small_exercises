public class Solution10 {
    public int strStr(String haystack, String needle) {
            if(needle.equals("")){
                return 0;
            }
            else if(!haystack.matches("(.*)"+needle+"(.*)")){
                return -1;
            }else{
                for(int i=0;i<haystack.length();i++){
                    boolean has=true;
                    if((haystack.charAt(i)==needle.charAt(0))&&((haystack.length()-i)>=needle.length())){
                        int j=0;
                        while(j<needle.length()){
                            if(haystack.charAt(i+j)!=needle.charAt(j)){
                              //  System.out.println(i+" "+j);
                                has=false;
                                break;
                            }
                            j++;
                        }
                    }else{
                        has=false;
                    }
                    if(has){
                        return i;
                    }

                }
            }
            return -1;
    }
    public static void main(String []args){
        Solution10 s=new Solution10();
        System.out.println(s.strStr("mississippi","issi"));
    }
}


