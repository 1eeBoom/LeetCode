package medium;

import java.util.Arrays;

public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int[] a = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            a[s1.charAt(i)-'a']++;
        }
        int count = s2.length()-s1.length()+1;

        int len = s1.length();
        //起始位置
        for (int i = 0; i < count; i++) {
            int[] b = new int[26];
            //滑动窗口
            for (int j = i; j < i+len ; j++) {
                b[s2.charAt(j)-'a']++;
            }
            if(Arrays.equals(a,b)){
                return true;
            }
        }
        return false;
    }
}
