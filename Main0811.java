
import java.util.*;


public class Main0811 {
    /**
     * 在句子中找到前缀是str的首个单词位置
     * @param s string字符串 英文句子
     * @param x string字符串 字符串
     * @return int整型
     */
    public int match_str_in_sentence (String s, String x) {
        int index = ("" + s).indexOf("" + x);
        if (index == -1) {
            return index;
        }
        int idx = 1;
        for (int i = 0; i < index; i++) {
            if (s.charAt(i) == ' ') {
                idx++;
            }
        }
        return idx;
    }
}