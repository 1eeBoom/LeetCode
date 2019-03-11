package medium;

/**
 * Created By LeeBoom On 2019/3/7 20:30
 */
public class Search {
    /**
     * 复杂解法
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        //二分法
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        if(nums.length == 0)
        {
            return -1;
        }
        while(left <= right)
        {
            mid = (left + right)/2;
            if(nums[mid] == target)
            {
                return mid;
            }
            if(nums[mid] > nums[left] )
            {
                if(nums[mid] > target)
                {
                    if(target > nums[left]){
                        right = mid -1;
                    }else if(target < nums[left])
                    {
                        left = mid + 1;
                    }else {
                        return left;
                    }
                }else {
                    left = mid + 1;
                }
            }else if(nums[mid] < nums[left] ) {
                if(target > nums[mid] && target < nums[left] )
                {
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else{
                if(nums[left] == target)
                {
                    return left;
                }
                if(nums[right] == target)
                {
                    return right;
                }
                return -1;
            }
        }
        return left;
    }


}
