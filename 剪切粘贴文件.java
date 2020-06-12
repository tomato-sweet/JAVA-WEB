import java.io.File;

public class 剪切粘贴文件 {
    public static void main(String[] args) {
        File file = new File("你好.txt");
        File dest = new File("out/你好.txt");
        file.renameTo(dest);
    }
}
