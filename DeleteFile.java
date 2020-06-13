import java.io.File;
import java.util.Scanner;

public class DeleteFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        File file = new File("陈沛鑫.txt");
        System.out.println("创建 File 对象成功");
        scanner.nextLine();
        // file.delete(); 立即删除
        file.deleteOnExit();    // JVM 退出时才删除
        System.out.println("文件删除成功");
        scanner.nextLine();
    }
}
