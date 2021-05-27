package easy;

public class BinSearch {
    //给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。
//
//
//示例 1:
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
//
//
// 示例 2:
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
//
//
//
//
// 提示：
//
//
// 你可以假设 nums 中的所有元素是不重复的。
// n 将在 [1, 10000]之间。
// nums 的每个元素都将在 [-9999, 9999]之间。
//
// Related Topics 二分查找
// 👍 241 👎 0
//
// leetcode submit region begin(Prohibit modification and deletion)

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while (l <= r){
            int mid = (l+r) / 2;
            if(target == nums[mid]) {
                return mid;
            }else if(target > nums[mid]) {
                //需要+1,否则对于不存在的数字，会出现 l+r/2 = l 或者 r 的情况，导致一直出不了循环
                //比如 l = 1 r =2 l+r/2 = mid = 1  下一步 [mid,r]就一直死循环了
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(new BinSearch().search(nums,3));
    }


//leetcode submit region end(Prohibit modification and deletion)

}
