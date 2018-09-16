class Solution5 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
            String result="";
            int length=strs.length;
            int i=0;
            while(i<strs[0].length()){
                char tem=strs[0].charAt(i);
                boolean isbreak=false;
                for(int u=0;u<length;u++){
                    if(i>=strs[u].length()){
                        isbreak=true;
                        break;
                    }
                    if(tem!=strs[u].charAt(i)){
                        isbreak=true;
                        break;
                    }
                }
                if(isbreak){
                    break;
                }
                result=result+tem;
                i++;
            }
            return result;
    }
    public static  void main(String []args){
        Solution5 s=new Solution5();
        String []s1={"dog","racecar","car"};
        System.out.println(s.longestCommonPrefix(s1));
    }
}
