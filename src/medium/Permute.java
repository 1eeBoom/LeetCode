package medium;


import java.util.LinkedList;
import java.util.List;

/**
 * Created By LeeBoom On 2019/3/1 19:33
 */

/**
 * 题目：
 * 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * 思路：
 * 利用递归实现回溯法
 * 递归作用：将剩下的数字数组中选择一个组合成新的数组，然后将组成的新的数组和剩下的数组作为参数传入
 * 递归结束条件：长度为n或者list中有重复的元素
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        //起始条件
        Permutation(nums,0,lists);
        return lists;
    }
    public static void Permutation(int[] nums,int start,List<List<Integer>> lists){
        //终止条件start = length-1,当前已到数组最后一个元素
        if(start == nums.length-1){
            List<Integer> list = new LinkedList<>();
            for(int x: nums){
                list.add(x);
            }
            lists.add(list);
            return;
        }
        //从start开始,向后每次和start交换
        for(int i = start ;i<nums.length; i++){
            //去除重复的序列,如果nums[i]==nums[start]就不进行交换
            if(i==start||nums[i]!=nums[start]){
                swap(nums,start,i);
                //对于后面的数组采取同样的方式,更新start后,从start开始,向后每次和start交换;
                Permutation(nums,start+1,lists);
                //交换回来,恢复成原来的顺序.
                swap(nums,start,i);
            }
        }
    }
    public static void swap(int[] nums ,int i ,int j){
        int save = nums[i];
        nums[i] = nums[j];
        nums[j] = save;
    }
}
