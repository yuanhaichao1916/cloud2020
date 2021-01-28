package designModel.service.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 创建执行线程的方式三：callable 接口
 * 创建Callable 方式： 需要FutureTask 实现类的支持，用于接收运算结果
 */
public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadDemo1 td = new ThreadDemo1();

        FutureTask<Integer> result = new FutureTask<>(td);

        new Thread(result).start();

        System.out.println(result.get());
    }
}

class ThreadDemo1 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum+=i;
        }

        return sum;
    }
}
