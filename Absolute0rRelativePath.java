import java.io.File;

public class AbsoluteOrRelativePath {
    public static void main(String[] args) {
        File file = new File(pathname:"一个相对路径文件.txt");
        System.out.println(file.getAbsoluteFile());
    }
}
