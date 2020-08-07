import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
给你一个整数数组 nums，请你将该数组升序排列。
做到这两点：
        在额外空间充足的情况下，尽量增大桶的数量
        使用的映射函数能够将输入的 N 个数据均匀的分配到 K 个桶中
 */
public class Solution0807 {
    public int[] bucketSort( int[] arr) {
        int max = arr[0],min = arr[0];
        for(int val:arr){
            max = max>val?max:val;
            min = min<val?min:val;
        }

        int bucketSize = arr.length;
        List<Integer>[] bukcet = new ArrayList[bucketSize+1];
        for(int i = 0; i < bukcet.length;i++){
            bukcet[i] = new ArrayList<Integer>();
        }
        for(int val : arr){
            int i = (val - min)*bucketSize/(max - min);
            bukcet[i].add(val);
        }
        // for(int i = 0; i < bukcet.length;i++){
        //     for(int j = 0; j < bukcet[i].size();j++)
        //         System.out.print(bukcet[i].get(j) + " ");
        //      System.out.println(" ");
        // }

        for(int i = 0; i < bukcet.length;i++){
            Collections.sort(bukcet[i]);
        }
        int k = 0;
        for(int i = 0; i < bukcet.length;i++){
            for(int j = 0; j < bukcet[i].size();j++)
                arr[k++] = bukcet[i].get(j);
        }
        return arr;
    }
}
