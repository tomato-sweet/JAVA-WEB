import java.util.HashSet;
import java.util.Set;

public class Solution0605 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        //遍历整个数组，添加不进去说明有重复项，输出该项的值
        for (int num : nums){
            if (set.add(num)){
            }else{
                repeat = num;
            }
        }
        return repeat;
    }
}