package medium;

/**
 * Created By LeeBoom On 2019/3/21 21:19
 */
public class IntToRoman {
    public String intToRoman(int num) {
        int[] nums = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] strs = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int len = nums.length;
        StringBuilder sb = new StringBuilder();
        for(int i = len - 1; i >= 0; i --){
            while(num >= nums[i]){
                num -= nums[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
}
