import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//输入n个整数，输出出现次数大于等于数组长度一半的数

public class Main0808 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (scan.hasNext()){
            list.add(scan.nextInt());
        }
        Collections.sort(list);
        System.out.println(list.get(list.size()/2-1));
    }
}
