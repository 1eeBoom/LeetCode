package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LeeBoom
 * @className PermuteUnique
 * @description 47. 全排列 II
 * @date 2019-04-15 13:45
 **/
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        permute(nums, 0, res);
        return res;

    }
    public void permute(int[] nums ,int start, List<List<Integer>> res ) {
        if (start == nums.length - 1) {
            List<Integer> list = new ArrayList<Integer>();
            for(int i : nums) {
                list.add(i);
            }
            res.add(list);
            return;
        }
        for(int i = start; i < nums.length; i++) {
            if(i == start || nums[i] != nums[start]) {
                swap(nums, i, start);
                permute(nums, start + 1, res);
                swap(nums, i, start);
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        if(i == j) {
            return ;
        }
         nums[i] = nums[i] + nums[j];
         nums[j] = nums[i] - nums[j];
         nums[i] = nums[i] - nums[j];
//        int k = nums[i];
//        nums[i] = nums[j];
//        nums[j] = k;
    }
    public static void main(String[] args){
        PermuteUnique permuteUnique = new PermuteUnique();
        int[] nums = {1,1,2};
//        permuteUnique.swap(nums,1,2);
//        permuteUnique.swap(nums,1,2);if(!res.contains(list)) {
//                res.add(list);
//            }
//        System.out.println(nums[1]);
//        System.out.println(nums[2]);

        System.out.println(permuteUnique.permuteUnique(nums));
    }
}
