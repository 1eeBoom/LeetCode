package medium;

import java.util.*;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class Merge {
    public List<Interval> merge(List<Interval> intervals) {

        /**
         * Comparator 取决于sort函数是根据1还是-1来决定交换元素。
         * 如果是根据1来交换元素的话，则如果你想要升序，则需要O1>O2,这样o2才会到前面
         */
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return ((Interval)o1).start - ((Interval)o2).start;
            }
        });
        List<Interval> intervals1 = new LinkedList<>();
        if (intervals.isEmpty()){
            return intervals1;
        }
        //
        Interval last = intervals.get(0);
        Iterator iterator = intervals.iterator();
        while (iterator.hasNext()){
            Interval cur = (Interval)iterator.next();
            if(cur.start <= last.end){
                last.end = Math.max(cur.end,last.end);
            }else {
                intervals1.add(last);
                last = cur;
            }
        }
        intervals1.add(last);
        return intervals1;
    }
}

