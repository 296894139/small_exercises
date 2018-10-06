import java.util.*;

/**
 * @创建人 徐介晖
 * @创建时间 2018/10/6
 * @描述  Design a data structure that supports all following operations in average O(1) time.
 */
class RandomizedCollection {

    private final Map<Integer, Deque<Integer>> map = new HashMap<>();
    private final List<Integer> list = new ArrayList<>();
    private final Random random = new Random();
    private int size = 0;
    /** Initialize your data structure here. */
    public RandomizedCollection() {

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean first = false;
        Deque<Integer> dq = map.get(val);
        if(dq == null || dq.isEmpty()) {
            dq = new ArrayDeque<>();
            map.put(val, dq);
            first = true;
        }
        list.add(val);
        dq.push(size);
        size++;
        return first;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Deque<Integer> dq = map.get(val);
        if(dq == null || dq.isEmpty()) {
            return false;
        }
        list.set(dq.pop(), null);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        Integer result = null;
        do {
            result = list.get(random.nextInt(size));
        } while(result == null);
        return result;
    }
}
