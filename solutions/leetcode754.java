//You are standing at position 0 on an infinite number line. There is a goal at position target.
//
//On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.
//
//Return the minimum number of steps required to reach the destination.
public class leetcode754 {
    public int reachNumber(int target) {
        int step = 0, dis = 0;
        target = Math.abs(target);
        while (dis < target || (dis - target) % 2 != 0) {
            step++;
            dis += step;
        }
        return step;
    }
    public static void main(String[]args){
        leetcode754 s=new leetcode754();
        System.out.println(s.reachNumber(2));
    }
}
