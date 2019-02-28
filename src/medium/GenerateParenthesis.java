package medium;

/**
 * Created By LeeBoom On 2019/2/28 15:00
 */

import java.util.LinkedList;
import java.util.List;

/**
 * 题目：
 * 生成括号
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * 思路：
 * 生成括号的规则
 * 1.左括号永远大于等于右括号的数目
 * 2.首个括号不能是右括号
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        int leftNum = n-1;
        int rightNum = n;
        List<String>list = new LinkedList<>();
        if(n == 0)
        {
            return list;
        }
        String curStr = "(";
        backTrack(leftNum,rightNum,list,curStr);
        return list;
    }
    public void backTrack(int leftNum, int rightNum, List<String> list, String curStr)
    {
        //递归结束条件：leftNum == 0 && rightNum == 0
        if(leftNum == 0 && rightNum == 0)
        {
            list.add(curStr);
            //回退到上一步,这一步很重要
            return;
        }
        //添加左括号的条件很简单，只要有就可以添加
        if(leftNum > 0)
        {
            backTrack(leftNum-1,rightNum,list,curStr+"(");
        }
        //添加右括号需要满足左括号的剩余数量大于右括号，否则不能添加
        if(rightNum > 0 && leftNum < rightNum)
        {
            backTrack(leftNum,rightNum-1,list,curStr+")");
        }
    }
}
