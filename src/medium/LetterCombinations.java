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

}
