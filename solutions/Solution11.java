import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String, Pair> map;

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        int N = queries.length;
        double[] res = new double[N];
        map = new HashMap<>(); // var => equal form of its representitive, e.g. ("a", "2b")

        for(int i=0; i<equations.length; i++) {
            String s1 = equations[i][0], s2 = equations[i][1];
            double v = values[i];
            Pair p1 = find(map, s1), p2 = find(map, s2);
            if(!p1.word.equals(p2.word)) {
                map.put(p1.word, new Pair(s2, v/p1.val));  // union
            }
        }

        for(int i=0; i<N; i++) {
            String q1 = queries[i][0], q2 = queries[i][1];
            if(!map.containsKey(q1) || !map.containsKey(q2)) {
                res[i] = -1.0;
                continue;
            }
            Pair p1 = find(map, q1), p2 = find(map, q2);  // get the final root
            if(!p1.word.equals(p2.word)) res[i] = -1.0;  // different unions, not comparable
            else res[i] = p1.val/p2.val;
        }
        return res;
    }

    public Pair find(Map<String, Pair> map, String s) {
        if(!map.containsKey(s))
            map.put(s, new Pair(s, 1.0));

        String tmp = s;
        Pair p = map.get(s);
        double v = 1.0;
        while(!map.get(s).word.equals(s)) {
            v *= map.get(s).val;
            s = map.get(s).word;
        }
        p.word = s;  // update Pair for original s, i.e. tmp
        p.val = v;
        map.put(tmp, p);  // path compression
        return p;
    }
}

class Pair {
    String word;
    double val;
    Pair() {}
    Pair(String w, double v) {
        word = w;
        val = v;
    }
}
