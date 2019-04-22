package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LeeBoom
 * @className subsetsWithDup
 * @description 90. 子集 II
 * @date 2019-04-22 23:42
 **/
public class subsetsWithDup {
    public  List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        if(len == 0)
        {
            return res;
        }
        //max 为代表长度为n的数组的所有元素都选择的相应的二进制数2^n-1
        int max = 1;
        for(int i = 0; i < len; i++) {
            max *= 2;
        }
        for (int i = 0; i < max; i++) {
            List<Integer> list = new LinkedList<>();
            int temp = i;
            for (int j = 0; j < len; j++) {
                if((temp & 1) == 1)
                {
                    list.add(nums[j]);
                }
                temp = temp>>1;
            }
            if(!res.contains(list)) {
                res.add(list);
            }
        }
        return res;
    }
}
