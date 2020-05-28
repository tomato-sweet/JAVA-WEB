import java.io.File;

public class 列出所有文件 {
    public static void main(String[] args) {
        File file = new File(".");
        File[] files = file.listFiles();
        if (files == null) {
            System.out.println("BUG 了，对不是文件夹调用 listFiles()");
            return;
        }

        if (files.length == 0) {
            System.out.println("文件夹下没有任何文件");
            return;
        }

        for (File f : files) {
            System.out.println(f.getAbsolutePath());
        }
    }
}
