package medium;

/**
 * Created By LeeBoom On 2019/3/25 15:29
 */
public class RemoveDuplicates {
    // 常规思路
    /**
     * 判断当前元素是否与下一个元素相等，并计数。
     * 当计数大于等于2时，就进行移动操作，并减少数组长度。
     */
    public int removeDuplicates1(int[] nums) {
        int len = nums.length;
        if(len <= 2){
            return len;
        }
        int count = 1;
        for(int i = 0; i < len - 1; i++) {
            if(nums[i] != nums[i+1]) {
                count = 1;
            } else if(count >= 2){
                while(nums[i] == nums[i+1] && i  < len - 1){
                    moveNums(nums, i + 1);
                    len --;
                }
                count = 1;
            } else {
                count ++;
            }
        }
        return len;
    }
    public void moveNums(int[] nums, int index){
        for(int i = index; i < nums.length - 1; i++){
            nums[i] = nums[i + 1];
        }
    }


    /**
     * 数组常用办法：双指针法
     * 左指针指向相同数字数组的左端，右指针指向数组右边，当左右指针之差大于1时，代表重复数字超过2个。
     * 需要进行移动操作。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 0;
        int len = nums.length;
        if(len <= 2){
            return len;
        }
        for( right = 0; right < nums.length; right++){
            if(nums[right] != nums[left]){
                left = right;
            } else if( right - left >= 2){
                //为了预防出现[1,1,1,1]类似的特殊情况，需要对移动后的数组再次进行判断。
                while(right < len && nums[left] == nums[right]) {
                    moveNums(nums, right);
                    len --;
                }
                left = right;
            }
        }
        return len;
    }
}
