package designModel.service.juc;

import ch.qos.logback.core.pattern.FormatInfo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 模拟cas算法
 */
public class TestCompareAndSwap {

    public static void main(String[] args) {
        final CompareAndSwap cas = new CompareAndSwap();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int expectedValue = cas.get();
                    boolean b = cas.compareAndSet(expectedValue, (int) Math.random() * 101);
                    System.out.println(b);
                }
            }).start();
        }
    }
}

class CompareAndSwap{

    private int value;

    // 获取内存值
    public synchronized int get(){
        return value;
    }

    // 比较
    public synchronized int compareAndSwap(int expecteValue, int newValue){
        int oldValue = value;

        if(oldValue == expecteValue){
            this.value = newValue;
        }
        return oldValue;
    }

    // 设置
    public synchronized boolean compareAndSet(int expecteValue, int newValue){
        return expecteValue == compareAndSwap(expecteValue,newValue);
    }
}
