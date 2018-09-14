class Solution3 {
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

}
