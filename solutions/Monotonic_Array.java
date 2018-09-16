public class Monotonic_Array {
    public boolean isMonotonic(int[] A) {

            if(A.length<3){
                return true;
            }else{
                int i=0;
                while(i<A.length-1){
                    if((A[i+1]-A[i])!=0){
                        break;
                    }
                    i++;
                }
                if(i>=A.length-1){
                    return true;
                }
                int tem=A[i+1]-A[i];
                for( i=0;i<A.length-1;i++){
                    if((tem*(A[i+1]-A[i]))<0){
                        return false;
                    }
                }


            }
            return true;
    }

}
