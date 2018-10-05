import java.util.*;

/**
 * @创建人 徐介晖
 * @创建时间 2018/10/5
 * @描述   There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 */
public class leetcode210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        Arrays.fill(degree, 0); //or necessary?
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair: prerequisites) {
            int parent = pair[1], child = pair[0];
            if (!map.containsKey(parent)) {
                List<Integer> list = new ArrayList<>();
                list.add(child);
                map.put(parent, list);
            } else map.get(parent).add(child);
            degree[child]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) queue.offer(i);
        }

        int[] res = new int[numCourses];
        int k = 0;

        while (!queue.isEmpty()) {
            int parent = queue.poll();
            res[k++] = parent;
            if (map.containsKey(parent)) {
                for (int child: map.get(parent)) {
                    degree[child]--;
                    if (degree[child] == 0) queue.offer(child);
                }
            }
        }

        if (k != numCourses) return new int[0];
        return res;

    }
}
