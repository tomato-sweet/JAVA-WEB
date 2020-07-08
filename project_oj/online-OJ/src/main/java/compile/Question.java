package compile;

//要编译的代码
public class Question {
    //要编译和执行的代码内容
    private String code;
    //执行时标准输入要输入的内容
    //后面没有用到stdin
    private String stdin;

    public String getCode() {
        return code;
    }
    public String getStdin() {
        return stdin;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public void setStdin(String stdin) {
        this.stdin = stdin;
    }
}
