package medium;

import java.util.HashMap;

/**
 *  无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        //从首字母开始
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character,Integer> hashMap = new HashMap<Character, Integer>();
            int j = i;
            //依次向后扩大窗口,直至尾字母或者重复字母
            while(j<s.length()&&!hashMap.containsKey(chars[j])){
                hashMap.put(chars[j],j);
                j++;
            }
            int count = hashMap.size();
            //如果窗口长度大于最大值,则更新
            if(count > max){
                max = count;
            }
        }
        return max;
    }
}
