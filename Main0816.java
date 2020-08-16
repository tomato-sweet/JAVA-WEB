/*
共发n元奖金，一次发1元，一次发2元....也可以选择一次发n元。共有多少种发放方式
 */

public class Main0816 {
    /**
     *
     * @param num_money int整型 奖金的总数,单位为元
     * @return int整型
     */
    public int CalulateMethodCount (int num_money) {
        // write code here
        /*int num_money[] = new int[m + 1];
        if (m == 0){
            return 1;
        }
        num_money[0] = 1;
        num_money[1] = 1;
        if (m == 1){
            return 1;
        }else {
            for (int i = 2;i <= m;i++){
                num_money[i] = num_money[i - 1] + num_money[i - 2];
            }
                return num_money[m + 1];
        }*/
        if (num_money < 1)
            return 0;
        if (num_money == 1)
            return 1;
        if (num_money == 2)
            return 2;
        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 2;i <= num_money;i++){
            temp = b + a;
            a = b;
            b = temp;
        }
        return temp;
    }
}