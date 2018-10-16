import java.util.*;

/**
 * @创建人 徐介晖
 * @创建时间 2018/10/16
 * @描述  There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.

An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.
 */
public class leetcode452 {
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] start = points[0];
        int count = 1;

        for (int i=1; i<points.length; i++) {
            if (points[i][0] <= start[1]) {
                start[1] = Math.min(start[1], points[i][1]);
                continue;
            }
            else {
                count++;
                start = points[i];
            }
        }

        return count;
    }
    public static void main(String[]args){
        leetcode452 s=new leetcode452();
        int a[][]={{0,9},{1,8},{7,8},{1,6},{9,16},{7,13},{7,10},{6,11},{6,9},{9,13}};
        System.out.println(s.findMinArrowShots(a));
    }
}
