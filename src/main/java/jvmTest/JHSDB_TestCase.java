package jvmTest;

/** staticObj、instanceObj、localObj存放在哪里？
 *
 * staticObj随着Test的类型信息存放在方法区，instanceObj随着Test的对象实例存放在Java堆，localObject则是存放在foo()方法栈帧的局部变量表中。

 **/
public class JHSDB_TestCase {
    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");//这里设一个断点}}
        }
    }

    private static class ObjectHolder{}

    public static void main (String[]args) {
        Test test = new JHSDB_TestCase.Test();
        test.foo();
    }
}

