package medium;

import java.util.*;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
class Compare implements Comparator
{
    @Override
    public int compare(Object o1, Object o2) {
        return ((Interval)o1).start - ((Interval)o2).start;
    }
}
public class Merge {
    public List<Interval> merge(List<Interval> intervals) {

        Collections.sort(intervals,new Compare());
        List<Interval> intervals1 = new LinkedList<>();
        if (intervals.isEmpty()){
            return intervals1;
        }
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

