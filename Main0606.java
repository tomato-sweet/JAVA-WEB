import java.util.Scanner;

public class Main0606 {
    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int cake1 = 8;
        int cake2 = ((((w / 4) * 2) * ((h / 4 * 2))) * 2);
        int cake3 = cake2 + (((w % 4) * 2 * (h / 4)) +((h % 4) * 2 * ( w / 4)));
        if (w == 4 && h == 4){
           System.out.println(cake1);
        }
        if (w % 4 == 0 && h % 4 == 0){  //没有多余的行和列
           System.out.println(cake2);
        }
        if (w % 4 == 0 || h % 4 == 0){  //行或者列有余数
            System.out.println(cake3);
        }
    }

     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int col = in.nextInt();
        int row = in.nextInt();
        int[][] grid = new int[row][col];
        for(int i = 0; i < row; i++){
            if(i % 4 == 0 || i % 4 == 1){
                for(int j = 0; j < col; j++){
                    if(j % 4 == 0 || j % 4 == 1){
                        grid[i][j] = 1;
                    }
                }
            }else {
                for(int j = 0; j < col; j++){
                    if(j % 4 == 2 || j % 4 == 3){
                        grid[i][j] = 1;
                    }
                }
            }
        }
        int count = 0;
        for(int x = 0; x < row; x++){
            for(int y = 0; y < col; y++){
                if(grid[x][y] == 1){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
