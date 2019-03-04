package medium;

import java.util.*;

/**
 * Created By LeeBoom On 2019/3/4 12:57
 */
public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new LinkedList<>();
        if(k == 0 || nums.length == 0)
        {
            return list;
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            /**
             *  对于小根堆，当父元素大于子元素时，需要进行交换。
             *  对于大根堆，当父元素小于子元素时，需要进行交换。
              * @param parent parent为父元素
             * @param son son为子元素
             * @return
             */
            @Override
            public int compare(Map.Entry<Integer, Integer> parent, Map.Entry<Integer, Integer> son) {
                return son.getValue() - parent.getValue();
            }
        });
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for (Integer i :
                nums) {
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else {
                map.put(i,1);
            }
        }
        pq.addAll(map.entrySet());
        for (int i = 0; i < k; i++) {
            list.add(pq.poll().getKey());
        }
        return list;
    }
}
