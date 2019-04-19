package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author LeeBoom
 * @className Combine
 * @description 77. 组合
 * @date 2019-04-19 20:28
 **/
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        if(k == 0) {
            return res;
        }
        backTrace(res, n, k, 1, new LinkedList<Integer>());
        return res;
    }
    public void backTrace(List<List<Integer>> res, int n, int k, int start, List<Integer> list) {
        if(list.size() == k) {
            res.add(new LinkedList<Integer>(list));
            return;
        }else {
            for (int i = start; i <= n; i++) {
                list.add(i);
                backTrace(res, n, k, i+1, list);
                list.remove(list.size()-1);
            }
        }
    }
}
