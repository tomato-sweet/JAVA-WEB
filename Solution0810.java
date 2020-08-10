/*
给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
以数组形式返回答案。

输入：nums = [6,5,4,8]
输出：[2,1,0,3]

 */
class Solution0810 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] nums_result = new int[nums.length]; //输入一个数组
        for (int i = 0; i < nums.length; i++) {
            int flag = 0; //比nums[0]小的数字的初始值为0
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) //如果nums[0]比nums[1]大，flag就加1
                    flag++;
            }
            nums_result[i] = flag;
        }
        return nums_result;
    }
}

