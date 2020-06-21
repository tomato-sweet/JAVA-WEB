public class Main {
    private int v = 10;

    private int get() {
        try {
            return v;   // 10
        } finally {
            v = 10000;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.get()); // 10
        System.out.println(main.v);     // 10000
    }
}
