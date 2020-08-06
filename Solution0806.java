//给你一个整数数组 nums，请你将该数组采用希尔排序方式进行升序排列。

public class Solution0810 {
        public int[] sort( int[] nums) {
            int i,j,k;
            int gap = nums.length;
            do{
                gap = gap / 3 + 1;
                for(i = 0;gap > i;i++){
                    for(j = i + gap;j < nums.length;j += gap){
                        if(nums[j] < nums[j - gap]){
                            int tmp = nums[j];
                            for(k = j -gap;k >= 0 && tmp < nums[k];k -= gap){
                                nums[k + gap] = nums[k];
                            }
                            nums[k + gap] = tmp;

                        }
                    }
                }
            }
            while(gap > 1);
            return nums;
        }
}
