package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LeeBoom
 * @className GetPermutation
 * @description 60. 第k个排列
 * @date 2019-04-16 14:37
 **/
public class GetPermutation {
    public String getPermutation(int n, int k) {
        List<Integer> list = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }
        Integer[] nums = new Integer[list.size()];
        list.toArray(nums);
        int count = 1;
        //计算多少种情况就循环多少次
        while(count < k) {
            int a = 0;
            int b = 0;
            // 从右往左，找出第一个左边小于右边的数，设左边的数的下标为a
            for(int i = n-1; i > 0; i--) {
                if (nums[i-1] < nums[i]) {
                    a = i-1;
                    break;
                }
            }
            // 从右往左，找出第一个大于nums[a]的数， 记下标为b
            for(int i = n-1; i > a ;i--) {
                if(nums[i] > nums[a]) {
                    b = i;
                    break;
                }
            }
            // 将下标a,b上的数字交换
            swap(nums,a,b);
            //从a+1开始到最后一个数，从小到大排序
            //需要注意的是sort函数的参数区间是[i,j)，即左包含，右不包含。
            Arrays.sort(nums,a+1,n);
            count++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i :
                nums) {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }
    public  void swap(Integer[] nums ,int i ,int j){
        int save = nums[i];
        nums[i] = nums[j];
        nums[j] = save;
    }
}
