import java.util.Scanner;

/*
输入：
每个案例第一行两个整数N，M，2<=N,M<=200.有N行，第i(i = 1,2,3,...N)行每一行有一个数，表示读者i-1最喜欢的图书的编号
输出：
每个案例包括N行，每行一个数，第i行的数表示读者i有几个潜在朋友，如果i和任何人都没共同喜欢的书，那就输出"BeiJu"
 */
public class Main0809 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] book = new int[m];
        int[] reader = new int[n];
        for (int i = 0;i < n;i++){
            reader[i] = scan.nextInt();
            book[reader[i]]++;
        }
        for (int i = 0;i < n;i++){
            if (book[reader[i]] == 1){
                System.out.println("BeiJu");
            }else {
                System.out.println(book[reader[i]] - 1);
            }
            scan.close();
        }
    }
}
