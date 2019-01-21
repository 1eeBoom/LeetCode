package medium;

/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        char[] str = s.toCharArray();
        int max = 0;
        int left = 0;
        int right = s.length()-1;
        //窗口法,从第一个元素作为窗口的起始位置,最后一个元素作为窗口结束位置
        for (int i = 0; i < str.length; i++) {
            //不断缩小窗口,看窗口内的字符串是否是回文
            for (int j = str.length-1; j >= i ; j--) {
                //如果是回文,则记录大小和位置
                if(helper(str,i,j)){
                    if((j-i+1) > max){
                        max = j-i+1;
                        left = i ;
                        right = j;
                    }
                    //因为长度是从大到小找,所以找到后可以直接跳出循环
                    break;
                }
            }
        }
        return s.substring(left,right+1);
    }
    //对每个窗口内字符串进行回文判断
    public static boolean helper(char[] str, int left, int right){
        while(left<=right){
            if(str[left] != str[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
