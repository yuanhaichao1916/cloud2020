package designModel.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class A {
    int m;

    public A() {
    }

    public A(int m) {
        this.m = m;
    }

    private void func1() {
        System.out.println("This is func1: ");
    }

    private void func2(Integer m) {
        System.out.println("This is func2: "+m);
    }

    private void func3(String s, Integer m) {
        System.out.println("This is func3: "+s+m);
    }

/*    public static void main(String[] args) throws Exception {
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
    }*/

    public static void main(String[] args) throws Exception {
        Class classInfo = Class.forName("A");

        // 调用午餐构造函数，生成新的事例对象
        Object obj = classInfo.getConstructor().newInstance();

        // 调用无参成员函数func1
        Method mt1 = classInfo.getMethod("func1");
        mt1.invoke(obj);

        // 调用1个参数成员函数func2
        Method mt2 = classInfo.getMethod("func2", Integer.class);
        mt2.invoke(obj, new Object[]{10});

        // 调用2个参数成员函数 func3
        Method mt3 = classInfo.getMethod("func3", String.class, Integer.class);
        mt3.invoke(obj,new Object[]{"Hello", 10});
    }

    boolean Process(String className, String funcName, Object [] para) throws Exception {
        // 获取类信息对象
        Class classType = Class.forName(className);
        // 形成函数参数序列
        Class c[] = new Class[para.length];
        for (int i = 0; i < c.length; i++) {
            c[i] = para[i].getClass();
        }

        // 调用无参构造函数
        Constructor ct = classType.getConstructor();
        Object obj = ct.newInstance();
        // 获取方法函数方法信息
        Method method = classType.getMethod(funcName, c);
        // 执行该方法
        method.invoke(obj, para);
        return true;
    }
}



