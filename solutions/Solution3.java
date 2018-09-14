class Solution {
    public int maxArea(int[] height) {
          int max=0;
          int length=height.length;
          for(int i=0;i<length-1;i++){
             for(int u=i+1;u<length;u++){
                 int min=Math.min(height[u],height[i]);
                 int area=(u-i)*min;
                 if(area>max){
                     max=area;
                 }
             }
          }
          return  max;
    }
    public static void main(String []arg){
        Solution s=new Solution();
        int []height={1,8,6,2,5,4,8,3,7};
        System.out.println(s.maxArea(height));
    }
}
