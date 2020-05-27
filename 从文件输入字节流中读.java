import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class 从文件输入字节流中读 {
    public static void main(String[] args) throws IOException {
        /*
        InputStream is = new FileInputStream("板书.png");
        System.out.println(is);
        is.close();
        */

        try (InputStream is = new FileInputStream("板书.png")) {
            /*
            long count = 0;
            // b 的意思有两个: 1. 下一个字节   2. 标志把文件读完了(End Of Stream) \r\n 换行符不是 EOS
            long len = 0;
            while (true) {
                count++;
                int b = is.read();
                if (b == -1) {
                    break;
                }

                len++;
            }
            */

            byte[] buffer = new byte[1024];
            long len = 0;
            long count = 0;

            while (true) {
                count++;
                int read = is.read(buffer);     // 一次最多读 1024 字节上，把读到的数据，放到 buffer 数组
                                                // 返回的 read，代表真正读到多少字节
                if (read == -1) {
                    break;
                }

                len += read;
            }

            System.out.printf("循环 %d 次%n", count);
            System.out.printf("板书.png 的文件长度为 %d 字节%n", len);
        }
    }
}
