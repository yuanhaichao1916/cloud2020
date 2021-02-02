package designModel.service;

import designModel.entities.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestOptional {
    /**
     * Optional 容器类
     * Optional.of(T t): 创建一个Optional实例
     * Optional.empty(): 创建一个空的Optional实例
     * Optional.ofNullable(T t): 若t不为null，创建Optional实例，否则创建空实例
     * isPresent(): 判断是否是空值
     * orElse(T t): 如果调用对象包含值，则返回这个值，否则返回t
     * OrElseGet(Supplier s): 如果调用对象包含值，则返回这个值，否则返回s获取de值
     * map(Function f): 如果有值对其进行处理，并返回处理后的Optional，否则返回Optional.empty()
     * flatMap(Function map): 与map蕾丝，要求返回值必须是Optional
     */
    @Test
    public void test(){
        Optional<Student> student = Optional.of(new Student());
        Optional<Object> empty = Optional.empty();

        Optional<Student> op = Optional.ofNullable(new Student("1q",11, Student.Status.VOCATION));

        if(op.isPresent()){
            System.out.println(op.get());
        }

        op.orElse(new Student("11",11, Student.Status.VOCATION));

        op.orElseGet(()->new Student());

        Optional<Student.Status> status = op.map((e) -> e.getStatus());
        System.out.println(status);

        Optional<String> s = op.flatMap((e) -> Optional.ofNullable(e.getName()));
        System.out.println(s.get());

    }

    @Test
    public void test11(){
        List long1  = new ArrayList<>();
        List iter  = new ArrayList<>();
        List booleana  = new ArrayList<>();
        long1.add((long)10);
        long1.add((long)20);
        iter.add(10);
        iter.add(20);
        booleana.add(true);
        booleana.add(false);

        System.out.println(long1.getClass() == iter.getClass());
        System.out.println(long1.getClass() == booleana.getClass());
    }

    @Test
    public void numTest(){
        int[] nums = new int[]{1,2,3,4,5,1,2,3};
        // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
        int len = removeDuplicates(nums);

        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
        for (int i = 0; i < len; i++) {
        System.out.println(nums[i]);
        }

    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


}
