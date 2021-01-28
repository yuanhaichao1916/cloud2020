package designModel.service.juc;

import ch.qos.logback.core.pattern.FormatInfo;
import org.apache.poi.ss.formula.functions.T;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch : 闭锁，在完成某些运算时，只有其他所有线程运算完成，当前运算才继续执行
 */
public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(5);
        LatchDemo latchDemo = new LatchDemo(latch);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 5; i++) {
            new Thread(latchDemo).start();
        }
        latch.await();
        long end = System.currentTimeMillis();
        System.out.println("耗费的时间：" + (end - start));
    }

}
class LatchDemo implements Runnable{

    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 50000; i++) {
                    if (i % 2 == 0) {
                        System.out.println(i);
                    }
                }
            } finally {
                latch.countDown();
            }
        }
    }
}
