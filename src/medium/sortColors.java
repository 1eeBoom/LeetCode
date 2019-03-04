package medium;

/**
 * Created By LeeBoom On 2019/3/4 12:28
 */

/**
 * 题目：
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * 思路：
 * 快排。
 *
 */
public class sortColors {
    public void sortColors(int[] nums) {
        oneSort(nums,0,nums.length-1);
    }

    private void oneSort(int[] nums, int left, int right) {
        //递归结束条件
        if(left >= right)
        {
            return;
        }
        int flag = nums[left];
        int i = left;
        int j = right;
        while(i < j)
        {
            while(i < j && nums[j] >= flag)
            {
                j--;
            }
            if(i < j)
            {
                nums[i] = nums[j];
            }
            while(i < j && nums[i] <= flag)
            {
                i++;
            }
            if(i < j)
            {
                nums[j] = nums[i];
            }
        }
        //需要将中枢放到中间位置上
        nums[i] = flag;
        oneSort(nums,left,i-1);
        oneSort(nums,i+1,right);
    }
}
