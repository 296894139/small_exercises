/**
 * @创建人 徐介晖
 * @创建时间 2018/10/10
 * @描述  Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 */
public class leetcode239 {
    public int get(int start,int k,int nums[]){
        //距离左边的距离
        int index=0;
        int max=nums[start];
        for(int i=start;i<start+k;i++){

                if(nums[i]>max){
                    max=nums[i];
                    index=i-start;
                }



        }
        return index;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
          int length=nums.length;
          if(length<k|| length==0){
              return new int[0];
          }
          int  n=length-k+1;
          int result[]=new int[n];
          int index=-1;
          int max=-10000;
          for(int i=0;i<k;i++){
              if(nums[i]>max){
                  max=nums[i];
                  index=i;
              }

          }
          result[0]=max;
          index--;

          for(int i=1;i<n;i++){
              if(index>=0){
                  //最大不是在最左边
                  if(nums[i+k-1]>=max){
                      result[i]=nums[i+k-1];
                      max=nums[i+k-1];
                      index=k-2;
                  }else{
                      result[i]=max;
                      index--;
                  }
              }else{
                  int now_max=get(i,k,nums);
                  max=nums[now_max+i];
                  result[i]=max;
                  index=now_max-1;
              }
          }



          return result;
    }
    public static void main(String[]args){
        leetcode239 s=new leetcode239();
        int a[]={1,3,1,2,0,5};
        int r[]=s.maxSlidingWindow(a,3);
        for(int i=0;i<r.length;i++){
            System.out.println(r[i]);
        }


    }
}
