package medium;

/**
 * Created By LeeBoom On 2019/3/20 11:41
 */

/**
 * 题目：
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 思路：
 * 对数组从最后一个元素向前遍历，对于递减数组不存在比其更大的排列。
 * 同理，对于数组中的子数组亦是如此。
 * 找到第一个nums[i-1]<nums[i]的数，并将其与后面的逆序数组中最小的比nums[i-1]大的数进行交换。
 * 交换过后的数组从i到最后一个元素位置，都是逆序数组。再将该逆序数组反转，就得到新的比他大的排列。
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        boolean exchange = false;
        int index = 0;
        for(int i = nums.length -1 ; i > 0 ;i--)
        {
            if(nums[i] <= nums[i - 1])
            {
                continue;
            }else{
                index = i - 1;
                exchange = true;
                break;
            }
        }
        if(!exchange)
        {
            reverse(nums,0,nums.length-1);
        }else{
            int min = nums[index + 1];
            int minNum = index + 1;
            for(int i = index + 1; i < nums.length ; i++ )
            {
                if(nums[i] <= min && nums[i] > nums[index])
                {
                    min = nums[i];
                    minNum = i;
                }
            }
            swap(nums,index,minNum);
            reverse(nums,index+1,nums.length-1);
        }

    }
    public void swap(int[] nums, int i, int j)
    {
        int k = nums[i];
        nums[i] = nums[j];
        nums[j] = k;
    }

    public void reverse(int[] nums, int start, int end)
    {
        for(int i = start; i < (start + end + 1 ) / 2; i++)
        {
            int temp = nums[i];
            nums[i] = nums[start + end - i];
            nums[start + end -i] = temp;
        }
    }
}
