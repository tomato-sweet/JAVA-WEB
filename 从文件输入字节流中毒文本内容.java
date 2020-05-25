import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class 从文件输入字节流中毒文本内容 {
    /*
    public static void main(String[] args) throws IOException {
        try (InputStream is = new FileInputStream("没有中文的文件.txt")) {
            byte[] buffer = new byte[1024];

            int len = is.read(buffer);
            System.out.println(len);
            System.out.println("==============");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                //System.out.println((char)buffer[i]);
                sb.append((char)buffer[i]);
            }

            // 数据放在 byte[] buffer
            // 想要最终通过 String s 获取完整字符串，怎么办？
            String s = sb.toString();
            System.out.println(s);  // Hello World
                                    // Happy Every Day!
        }
    }
    */
    public static void main(String[] args) throws IOException {
        try (InputStream is = new FileInputStream("有中文的文件.txt")) {
            byte[] buffer = new byte[10];

            int len = is.read(buffer);
            System.out.println(len);
            System.out.println("==============");
            /*
            for (int i = 0; i < len; i++) {
                System.out.printf("%02x%n", buffer[i]);
                //sb.append((char)buffer[i]);
            }
            */

            // 数据放在 byte[] buffer
            // 想要最终通过 String s 获取完整字符串，怎么办？
            String s = new String(buffer, 0, len, "UTF-8");
            System.out.println(s);  // 你好世界
                                    // 快乐每一天
        }
    }
}
