import java.io.*;
import java.util.Scanner;

public class 从文件输入字符流中读文件内容 {
    /*
    public static void main(String[] args) throws IOException {
        try (InputStream is = new FileInputStream("有中文的文件.txt")) {
            try (Reader reader = new InputStreamReader(is, "UTF-8")) {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int c = reader.read();
                    if (c == -1) {
                        break;
                    }

                    sb.append((char)c);
                }

                System.out.println(sb.toString());

                //StringBuilder sb = new StringBuilder();
                char[] buffer = new char[1024];
                while (true) {
                    int len = reader.read(buffer);
                    if (len == -1) {
                        break;
                    }

                    for (int i = 0; i < len; i++) {
                        System.out.println(buffer[i]);
                    }
                }


                //String s = // 在 buffer 中找 \r\n，找到之后，前面的就是一行的数据
                //System.out.println(s);  // 你好世界
            }
        }
    }
    */
    public static void main(String[] args) throws IOException {
        try (InputStream is = new FileInputStream("有中文的文件.txt")) {
            try (Reader reader = new InputStreamReader(is, "UTF-8")) {
                try (Scanner scanner = new Scanner(reader)) {
                    while (scanner.hasNext()) {
                        System.out.println(scanner.next());
                    }
                }
            }
        }
    }
}
