package designModel.service;

import designModel.entities.Student;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 *  方法引用： 若lambda体中的内容有方法已经实现了，我们可以使用"方法引用"
 *
 *  主要有三种语法格式：
 *  对象：：实例方法名
 *
 *  类：：静态方法名
 *
 *  类：：实例方法名
 *
 * 注意：
 *  1.Lambda 体中调用方法的参数列表与返回值类型，要与函数式接口中的抽象方法的函数列表和返回值类型保持一致
 *  2.如Lambda 参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用 ClassName :: method
 *
 *  构造器引用
 *      格式：
 *      ClassName:: new
 *
 *      注意： 需要调用的构造器的参数列表要与函数式接口中的抽象方法的参数列表保持一致！
 *  数组引用
 *      Type[] :: new
 *
 */
public class TestMethodRef {

    @Test
    public void test(){
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("123213");
        PrintStream out = System.out;
        Consumer<String> consumer = out::println;
        consumer.accept("1113");
    }

    @Test
    public void test1(){
        Student student = new Student("test",1);


        Supplier<String> pre = () -> student.getName();
        String s = pre.get();
        System.out.println(s);

        Supplier<Integer> pre2 = student::getGrade;
        Integer s1 = pre2.get();
        System.out.println(s1);
    }

    @Test
    public void test3(){
        Comparator<Integer> comparable = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> reversed = comparable.reversed();
        Comparator<Integer> comparator1 = Integer::compare;
    }

    @Test
    public void test4(){
        BiPredicate<String ,String> bp = (x, y) -> x.equalsIgnoreCase(y);
        boolean test = bp.test("a", "a");
        System.out.println(test);

        BiPredicate<String, String> bp1 = String::equalsIgnoreCase;
        boolean test1 = bp1.test("aa", "aa");
        System.out.println(test1);
    }

    @Test
    public void test5(){
        Supplier<Student> sup = () -> new Student();

        Supplier<Student> sup1 = Student::new;

        Student student = sup1.get();

        System.out.println(student);
    }

    // 构造器引用
    @Test
    public void test6(){
        Function<Integer,Student> function = (x) -> new Student(x);
        Student apply = function.apply(1);
        System.out.println(apply);

        Function<Integer,Student> function1 = Student::new;
        Student apply1 = function1.apply(111);
        System.out.println(apply1);

        BiFunction<String, Integer, Student> biFunction = Student::new;
        Student sss = biFunction.apply("sss", 1);
        System.out.println(sss);
        System.out.println();
    }

    // 数组引用
    @Test
    public void test7(){
        Function<Integer, String[]> f = (x) -> new String[x];
        String[] apply = f.apply(10);
        System.out.println(apply.length);

        Function<Integer, String[]> ff = String[]::new;
        System.out.println(ff.apply(20).length);
    }
}
