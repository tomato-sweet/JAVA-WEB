//JAVA反射机制中获取类的三种方法

//
//public class Getclass {
//    /**
//     * 法1：通过对象---对象.getClass()来获取c(一个Class对象)
//     */
//    @Test
//    public void get1(){
//        Person p = new Person("Jack", 23);
//        Class c = p.getClass();//来自Object方法
//    }
//
//    /**
//     * 法2：通过类(类型)---任何数据类型包括(基本数据类型)都有一个静态的属性class ，他就是c 一个Class对象
//     */
//    @Test
//    public void get2(){
//        Class c = Person.class;
//        Class c2 = int.class;
//    }
//
//    /**
//     * 法3：通过字符串(类全名 )---能够实现解耦：Class.forName(str)
//     */
//    @Test
//    public void get3(){
//        try {
//            Class c = Class.forName("cn.hncu.reflect.test.Person");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//}
