import java.util.*;


public class Solution {
    /**
     * 蜗牛到达井口所需天数
     * @param len int整型 井深
     * @param m int整型 白天爬m米
     * @param n int整型 晚上滑下去n米
     * @return int整型
     */
    public int daycost (int len, int m, int n) {
        // write code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入井深 len 米");
        len = scanner.nextInt();
        System.out.println("请输入白天爬 m 米");
        m = scanner.nextInt();
        System.out.println("请输入晚上滑下去 n 米");
        n = scanner.nextInt();
        int day = (int)(len - m)/(m - n) + 1;
        return day;
    }
}