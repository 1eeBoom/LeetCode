package medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created By LeeBoom On 2019/3/15 10:20
 */
public class DeckRevealedIncreasing {
    public int[] deckRevealedIncreasing(int[] deck) {
        int len = deck.length;
        //Deque双向列表，可以从队列开始或者末尾进行插入和删除。
        //通过模拟卡牌的排序电视获取输出顺序，根据输出顺序排列数组。
        Deque<Integer> integerDeque = new LinkedList<>();
        //存储下标位置，用于对ans数组正确排序。
        for(int i = 0; i < len; i++)
        {
            ((LinkedList<Integer>) integerDeque).add(i);
        }
        //将数组排序后，用于和interDeque配合放入相应的数字
        Arrays.sort(deck);
        int[] ans = new int[len];
        //用于存储deck中的下标位置，来放入到ans数组中相应的元素
        int num = 0;
        while(!integerDeque.isEmpty()){
            ans[integerDeque.pollFirst()] = deck[num++];
            if(!integerDeque.isEmpty())
            {
                //用于模拟每一次将卡牌翻面后，将下一张卡牌放置到末尾（即通过将对应下标放到队列末尾来实现）
                ((LinkedList<Integer>) integerDeque).add(integerDeque.pollFirst());
            }
        }
        return ans;
    }
}
