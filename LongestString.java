import java.util.ArrayList;
import java.util.List;

/*
在字符串中找出连续最长的数字串
str
 */
public class LongestString {
    public void getLongestNumString(String str){
        char[] arr = str.toCharArray();
        StringBuilder tmp = new StringBuilder();
        String ret = "";
        List<String> list = new ArrayList<>();
        boolean isConsecutive = false;
        for (char ch : arr){
            if (Character.isDigit(ch)){
                if (!isConsecutive){
                    tmp = new StringBuilder();
                }
                tmp.append(ch);
                isConsecutive = true;
                if (ret.length() < tmp.toString().length()){
                    ret = tmp.toString();
                    list.clear();
                    list.add(ret);
                }else if (ret.length() == tmp.toString().length()){
                    list.add(tmp.toString());
                }
            }else {
                isConsecutive = false;
            }
        }
        for (String string : list){
            System.out.println(string);
        }
        System.out.print(","+ret.length());
        System.out.print();
    }
}
