package medium;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class SearchSortNums {
    public static void main(String[] args){
        int[] nums1 = {3,5,1};
        System.out.println( search(nums1,1));
    }
    public static int search(int[] nums, int target) {
        /**
         * 需要进行判空操作
         */
        if(nums.length == 0){
            return -1;
        }
        int index = findIndex(nums);
        if(target == nums[index]){
            return index;
        }else if (target > nums[index]){
            return findTarget(nums, target, 0,nums.length-1);
        }else {
            if(target < nums[0])
                return findTarget(nums, target, index+1,nums.length-1);
            else {
                return findTarget(nums, target, 0,index-1);
            }
        }
    }
    public static int findIndex(int[] nums ){
        /**
         * i < nums.length-1 ---i最大为nums.length-2
         */
        for (int i = 1; i < nums.length-1; i++) {
            if(nums[i] >= nums[i-1] && nums[i] >= nums[i+1]){
                return i;
            }
        }
        return 0;
    }
    public static int findTarget(int[] nums, int target, int left, int right) {
        int mid = (left+right)/2;
        /**
         * 必须是<=,应为下方改变了right,left的值,需要考虑特殊情况.
         */
        while(left <= right ){
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                /**
                 * 不能将right = mid
                 * 需要改变right的值,以防止进入死循环.
                 */
                right = mid-1;
            }else {
                /**
                 * 同上
                 */
                left = mid+1;
            }
            mid = (left+right)/2;
        }
        return -1;
    }
}
