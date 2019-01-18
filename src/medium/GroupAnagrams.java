package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *   字谜分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        //使用O(N)的额外空间
        String[] strClone = new String[strs.length];
        //将字符串数组内的每一个元素分解成字符数组并排序,
        // 将排序好的字符数组重新组合并放入到新数组的对应标内
        for (int i = 0;i<strs.length;i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            strClone[i] = String.valueOf(chars);
        }
        //用HashMap判断是否是字母异位词,
        // 如果是,则将对应下标的strs数组元素加入到list中,
        // 不是则新增kv到map中,其中key为字符串
        HashMap<String,List<String>> hashMap  = new HashMap<String, List<String>>();
        for (int i = 0;i<strs.length;i++) {
            if(!hashMap.containsKey(strClone[i])){
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                hashMap.put(strClone[i],list);
            }else{
                List<String> list = hashMap.get(strClone[i]);
                list.add(strs[i]);
                hashMap.put(strClone[i],list);
            }
        }
        //将HashMap的values作为 List 返回
        return new ArrayList<List<String>>(hashMap.values());
    }
}
