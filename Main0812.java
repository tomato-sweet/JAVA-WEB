import java.util.*;


public class Main0812 {

    /**
     * 数组排序
     * @param a int整型一维数组 数组a升序
     * @param b int整型一维数组 数组b降序
     * @return int整型一维数组
     */
    public int[] sort (int[] a, int[] b){
        int[] c = new  int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length){
            if (a[i] < b[i]){
                c[k++] = a[i++];
            }else {
                c[k++] = b[j++];
            }
        }
        while (i < a.length){
            c[k++] = a[j++];
        }
        while (j < b.length){
            c[k++] = b[j++];
        }
        return c;
    }
    public static void printArray(int[] arr){
        for (int i : arr){
            System.out.println(i+"");
        }
    }
}