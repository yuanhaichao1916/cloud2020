import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class reflectTest {
    public static void main(String[] args) throws Exception {
        // 加载并初始化指定的类A
        Class classInfo = Class.forName("A");

        //获得类的构造函数
        System.out.println("类A构造函数如下所示：");
        Constructor[] cons = classInfo.getConstructors();
        for (int i = 0; i < cons.length; i++)
            System.out.println(cons[i].toString());

        // 获得类的所有变量
        System.out.println();
        System.out.println("类A变量如下所示：");
        Field[] fields = classInfo.getDeclaredFields();
        for (int i = 0; i < fields.length; i++)
            System.out.println(fields[i].toString());

        //  获取类的所有方法
        System.out.println();
        System.out.println("类A方法如下所示：");
        Method[] methods = classInfo.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++)
            System.out.println(methods[i].toString());
    }
}
