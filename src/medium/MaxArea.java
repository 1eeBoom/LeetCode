package medium;

/**
 * Created By LeeBoom On 2019/3/18 20:45
 */

/**
 * 题目：
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * 思路：
 * 最简单的，复杂度为O(N^2)的暴力求解
 * 复杂的用双指针，从头和尾分别向中间靠近。每次舍去最小的长度。
 */
public class MaxArea {
    public int maxArea1(int[] height) {
        int max = 0;
        if (height.length == 0 || height.length == 1)
        {
            return 0;
        }
        for(int i = 0; i < height.length - 1; i++)
        {
            for(int j = i+1 ;j < height.length; j++)
            {
                int area = Math.min(height[i],height[j]) * (j - i);
                max = area > max ? area : max;
            }
        }
        return max;
    }
    //     双指针法
    public int maxArea(int[] height) {
        int max = 0;
        int start = 0;
        int end = height.length - 1;
        int area = Math.min(height[start],height[end]) * (end - start);
        while(start < end)
        {
            area = Math.min(height[start],height[end]) * (end - start);
            max = area > max ? area : max;
            if(height[start] > height[end])
            {
                end--;
            }else{
                start++;
            }

        }
        return max;
    }
}
