package easy;

import java.util.Arrays;

/**
 * Created By LeeBoom On 2019/3/14 8:20
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        int maxCount = 0;
        int curCount = 0;
        int curNum = nums[0];
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != curNum)
            {

                if(curCount > maxCount)
                {
                    maxCount = curCount;
                    max = curNum;
                }
                curNum = nums[i];
                curCount = 1;
            }else{
                curCount ++ ;
            }
        }
        if(curCount > maxCount)
        {
            maxCount = curCount;
            max = curNum;
        }
        return max;
    }

}
