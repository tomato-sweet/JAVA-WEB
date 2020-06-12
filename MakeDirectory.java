import java.io.File;
import java.util.Scanner;

public class MakeDirectory {
    /*
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        File file = new File("陈沛鑫");
        System.out.println("对象创建成功");
        scanner.nextLine();
        file.mkdir();
        System.out.println("文件夹创建成功");
        scanner.nextLine();
        delete();
        System.out.println("文件夹删除成功");
        scanner.nextLine();
    }

    public static void delete() {
        File file = new File("陈沛鑫");
        file.delete();
    }
    */

    public static void main(String[] args) {
        //File file = new File("陈沛鑫/小李飞刀");
        // System.out.println(file.mkdir()); mkdir 不会生效，因为 陈沛鑫还不存在
        //file.mkdirs();  // 连同中间不存在的文件夹一并创建

        File f2 = new File("陈沛鑫");
        System.out.println(f2.delete());
    }
}
