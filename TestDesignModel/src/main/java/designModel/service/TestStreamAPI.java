package designModel.service;

import cn.afterturn.easypoi.excel.export.styler.ExcelExportStylerColorImpl;
import designModel.entities.Student;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  Stream 的三个操作步骤
 *
 *  1. 创建Stream
 *
 *  2. 中间操作
 *
 *  3. 终止操作(终端操作)
 */
public class TestStreamAPI {

    List<Student> stus = Arrays.asList(new Student("aaa",10, Student.Status.FREE),
                                        new Student("bbb",20, Student.Status.BUSY),
                                        new Student("ccc",30, Student.Status.FREE),
                                        new Student("ddd",40, Student.Status.VOCATION));

    @Test
    public void test(){
        // 1. 可以通过Collection 系列集合提供的stream() 或 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        // 2. 通过Arrays 中的静态方法中stream()获取数组流
        Student[] students = new Student[10];
        Stream<Student> stream1 = Arrays.stream(students);

        // 3. 通过Stream类中的静态方法 of()
        Stream<String> aaa = Stream.of("aaa", "bbb", "cccc");

        // 4. 创建无限流
        // 迭代
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2);
        iterate.limit(10).forEach(System.out::println);

        // 生产
        Stream.generate(()-> Math.random()).limit(10).forEach(System.out::println);
    }

    // 中间操作
    /**
     * 筛选与切片
     * filter -- 接收Lambda，从流中删除某些元素
     * limit -- 截断流，使其元素不超过给定数
     * skip(n) -- 跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n) 互补
     * distinct -- 筛选，通过流所生场元素的hashcode() 和 equals() 去除重复数据
     */
    @Test
    public void test1(){
        // 中间操作：不会执行任何操作
        Stream<Student> studentStream = stus.stream().filter(e -> e.getGrade() > 20);

        // 终止操作：一次性执行全部内容，即 "惰性求值"
        studentStream.forEach(System.out::println);

    }

    /**
     *  映射
     *  map -- 接收lambda ，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新元素
     *  flatmap -- 接收到一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的流连接成一个流
     */

    @Test
    public void test2(){
        List<String> list = Arrays.asList("aaa","bbb","ccc");
        list.stream().map(e -> e.toUpperCase()).forEach(System.out::println);

        stus.stream().map(Student::getGrade).forEach(System.out::println);

        Stream<Stream<Character>> streamStream = list.stream().map(TestStreamAPI::filiterCahracter);

        streamStream.forEach(sm -> sm.forEach(System.out::println));

        list.stream().flatMap(TestStreamAPI::filiterCahracter).forEach(System.out::println);
    }

    public static Stream<Character> filiterCahracter(String str){
        List<Character> list = new ArrayList<>();

        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    /**
     *  排序
     *  sorted() -- 自然排序(Comparable)
     *  sorted(Comparator com)  -- 定制排序(Comparator)
     */
    @Test
    public void test3(){
        List<String> list = Arrays.asList("ddd","aaa","bbb","ccc");

        list.stream().sorted().forEach(System.out::println);

        stus.stream().sorted((e1, e2) -> {
            if(e1.getGrade() == e2.getGrade()){
                return e1.getGrade();
            }else{
                return e1.getName().compareTo(e2.getName());
            }
        }).forEach(System.out::println);
    }

    // 终止操作

    /**
     * 查找与匹配
     * allMatch -- 检查是够匹配所有与元素
     * anyMatch -- 检查是否至少匹配一个元素
     * noneMatch -- 检查是否没有匹配所有元素
     * findFirst -- 返回第一个元素
     * findAny -- 返回当前流中的任意元素
     * count -- 返回流中的总个数
     * max -- 返回流中的最大值
     * min -- 返回流中的最小值
     */
    @Test
    public void test4(){
        Optional<Student> student = stus.stream().findAny().filter(e -> e.getStatus().equals(Student.Status.BUSY));
    }

    /**
     * 归约
     * reduce(T identity, BinaryOperator) / reduce(BinaryOperator)  -- 可以将流中元素反复结合起来，得到一个值
     */
    @Test
    public void test5(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);

        Optional<Integer> reduce1 = stus.stream().map(Student::getGrade).reduce(Integer::sum);
        System.out.println(reduce1.get());
    }

    /**
     * 收集
     * collect -- 将流转换成其他形式。接收一个Collector接口实现，用于给stream中元素做汇总方法
     */
    @Test
    public void test6(){
        List<String> collect = stus.stream().map(Student::getName).collect(Collectors.toList());
        collect.forEach(System.out::println);

        HashSet<String> collect1 = stus.stream().map(Student::getName).collect(Collectors.toCollection(HashSet::new));
        collect1.forEach(System.out::println);
        System.out.println("====================");
        Long s =  stus.stream().collect(Collectors.counting());
        Double collect2 = stus.stream().collect(Collectors.averagingInt(Student::getGrade));
        System.out.println(s);
        System.out.println(collect2);
        IntSummaryStatistics collect3 = stus.stream().collect(Collectors.summarizingInt(Student::getGrade));
        System.out.println(collect3);
    }

}
