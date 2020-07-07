package compile;

public class Answer {
    //通过error来表示当前的错误类型
    //error为0表示没有错误，error为1表示编译错误，error表示运行错误
    private int error;
    //表示具体的出错原因，可能是编译错误/运行错误
    private String reason;
    //执行时标准输出对应的内容
    private String stdout;
    //执行时标准错误对应的内容
    private String stderr;

    public Answer() {
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }


    public void setReason(String compileError) {
    }

    public void setStdout(String readFile) {
    }

    @Override
    public String toString() {
        return "Answer{" +
                "error=" + error +
                ", reason='" + reason + '\'' +
                ", stdout='" + stdout + '\'' +
                ", stderr='" + stderr + '\'' +
                '}';
    }

    public void setStderr(String stdError) {
    }
}
