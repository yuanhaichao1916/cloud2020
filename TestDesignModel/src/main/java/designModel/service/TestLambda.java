package designModel.service;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *  Java 8 内置的四大核心函数式接口
 *
 *  Consumer<T> : 消费型接口
 *      void accept(T t)
 *  Supplier<T> : 供给型接口
 *      T get()
 *  Function<T, R> : 函数式接口
 *      R apple(T t)
 *  Predicate<T> : 断言型接口
 *      boolean test(T t)
 */
public class TestLambda {

    // Predicate<T> 断言型接口
    @Test
    public void test4(){
        List<String> list = Arrays.asList("Herrr","dasda","kdoakda","a","s");
        List<String> list1 = filterStr(list, (s) -> s.length() > 3);
        for (String s : list1) {
            System.out.println(s);
        }

    }

    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> stringList = new ArrayList<>();
        for (String s : list) {
            if(pre.test(s)){
                stringList.add(s);
            }
        }
        return stringList;
    }

    // Function<T, R> 函数式接口
    @Test
    public void test3(){
        String s1 = strHandler("  123321", (s -> s.trim()));
        System.out.println(s1);

        String s2 = strHandler("123131", s -> s.substring(2, 4));
        System.out.println(s2);

        Long s3 = strHandler1("12313", s -> (long) s.length());
        System.out.println(s3);
    }

    public String strHandler(String str, Function<String,String> fun){
        return fun.apply(str);
    }

    public Long strHandler1(String str, Function<String,Long> fun){
        return fun.apply(str);
    }
    // Supplier
    @Test
    public void test2(){
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer integer : numList) {
            System.out.println(integer);
        }
    }

    public List<Integer> getNumList(int num , Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            Integer integer = sup.get();
            list.add(integer);
        }
        return list;
    }

    @Test
    public void test1(){
        happy(10000,(m) -> System.out.println("xf"));
    }
    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }
}
