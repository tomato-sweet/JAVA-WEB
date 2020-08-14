
//给你一个整数数组 nums，请你将该数组采用快速排序方式进行升序排列。

public class Solution0814 {
    public int[] quicklysort( int[] nums) {
        sort(nums,0,nums.length-1);
        return nums;
    }
    public static void sort(int[] nums,int left,int right){
        if(left >= right)
            return;
        int start = left;
        int end = right;
        int flag = nums[left];
        while(left < right){
            while(left < right && nums[left] <= flag){
                left++;
            }
            while(left < right && nums[right] > flag){
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        int temp1 = nums[left - 1];
        nums[left - 1] = nums[start];
        nums[start] = temp1;
        sort(nums,start,left-1);
        sort(nums,left,end);
    }
}