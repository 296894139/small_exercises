class Solution1 {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        String s=x+"";
        int length=s.length();
        int half_length=s.length()/2-1;
        int index=0;
        while(index<=half_length){
            if(s.charAt(index)!=s.charAt(length-1-index)){
                return false;
            }
            index++;
        }

       return true;
    }
    public static void main(String []args){
        Solution1 s=new Solution1();
        System.out.println(s.isPalindrome(12322));
    }
}