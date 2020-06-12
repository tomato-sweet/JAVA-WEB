import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreateFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // 创建的只是对象，没有创建文件
        File file = new File("陈沛鑫.txt");
        System.out.println("File 对象以及创建成功，输入回车创建文件");
        scanner.nextLine();

        // 创建文件
        System.out.println(file.createNewFile());
        System.out.println("文件也创建成功");
    }
}
