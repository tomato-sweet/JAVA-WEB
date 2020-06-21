//  构造方法中调用普通方法，调用的父类的方法还是子类的方法 —— 根据引用指向的对象来，对象是哪个类的，调那个方法
//  抛出异常后，会从哪里返回值 —— finally 修改不会影响返回值
public class Test {
    public static void main(String [] args){
        B b = new B();
        int v = b.getValue();
        System.out.println(v);
    }

    static class A{
        protected int value;
        public A(int v) {
            setValue(v);
        }
        public void setValue(int value){
            this.value = value;
        }
        public int getValue(){
            try{
                value++;
                return value;
            } catch(Exception e){
                System.out.println(e.toString());
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
            return value;
        }
    }
    static class B extends A{
        public B() {
            super(5);
            int v = getValue();
            //System.out.println(v);
            setValue(v - 3);
        }
        public void setValue(int value){
            super.setValue(2 * value);
        }
    }
}
