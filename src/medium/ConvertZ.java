package medium;


/**
 * Created By LeeBoom On 2019/3/21 17:52
 */

/**
 * 题目
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 思路：
 * 搞清楚数组元素中下标和每行的对应关系就行、
 * 特别是当元素处于Z中间那一道斜杠时，需要特殊处理。
 */
public class ConvertZ {
    public static String convert(String s, int numRows) {
        if (numRows == 1 || numRows == 0 || s.length() == 0) {
            return s;
        }
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        //用于记录原字符串的第几个元素
        int i = 0;
        //用于记录Z字数组中的第几行
        int count = 0;
        while (i < len) {
            if (count < numRows) {
                builders[count].append(chars[i]);
                count++;
                i++;
            } else {
                for (int j = numRows - 2; j > 0 && i < len; j--, i++) {
                    builders[j].append(chars[i]);
                }
                count = 0;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int k = 0; k < numRows; k++) {
            res.append(builders[k].toString());
        }
        return res.toString();
    }
    public static void main(String[] args){
        String s = "PAYPALISHIRING";
        convert(s,3);
    }
}
