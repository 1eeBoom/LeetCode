package medium;

/**
 * Created By LeeBoom On 2019/2/20 23:58
 */

import java.util.*;

/**
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class LetterCombinations {
    //普通方法
    public List<String> letterCombinations(String digits) {
        char[] nums = digits.toCharArray();
        List<String> list = new LinkedList<>();
        if("".equals(digits))
        {
            return list;
        }
        list.add("");
        Map<Character,String> map = new HashMap<>();
        map.put('0',"");
        map.put('1',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        //第一层循环，对输入的数字数组进行循环，分别取出每个数字，以及对应的映射字符串
        //第二层循环，对队列中的元素进行循环，分别取出待用
        //第三层循环，对映射字符串的元素进行循环，分别将其加入到队列中的元素构成新的字符串并重新加入到队列中
        for (char i : nums) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                String s = ((LinkedList<String>) list).remove();
                for (char c : map.get(i).toCharArray()) {
                    list.add(s+c);
                }
            }
        }
        return list;
    }
    //回溯法求解

    /**
     * 思路：
     * 回溯法利用递归实现
     * @param digits
     * @return
     */
    public List<String> letterCombinations1(String digits) {
        List<String> list = new LinkedList<>();
        String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(digits.length() == 0)
        {
            return list;
        }
        backTrack("",digits,list,map);
        return list;
    }

    /**
     * 递归方法
     * @param s
     * @param num
     * @param list
     * @param map
     */
    private void backTrack(String s, String num, List<String> list,String[] map) {
        //递归结束条件：当前数字长度为0
        if ("".equals(num)) {
            list.add(s);
        } else {
            //取当前数字的第一个数字
            String n = num.substring(0, 1);
            //取得数字的映射字符串
            String str = map[Integer.valueOf(n) - 2];
            char[] chars = str.toCharArray();
            //将映射字符串中的每个字符取出，加入到当前字符串的末尾组成新的字符串
            //将新字符串和剩下的数字作为参数递归调用函数，直至数字长度为0.
            //此时得到一种可能。
            for (char c : chars) {
                backTrack(s + c, num.substring(1), list, map);
            }
        }
    }

}
