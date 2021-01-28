package designModel.service.juc;


/**
 *  解决多线程安全问题的方式：
 *      Synchroized ：隐式锁
 *       1. 同步代码块
 *       2. 同步方法
 *      jdk 1.5 后：
 *       3. 同步锁Lock
 *       注意：是一个显示锁，需要通过lock()方法上锁，必须通过unlock()方法进行释放锁
 */
public class TestLock {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket,"一号窗口").start();
        new Thread(ticket,"二号窗口").start();
        new Thread(ticket,"三号窗口").start();
    }
}

class Ticket implements Runnable{
    private int tick = 100;

    @Override
    public void run() {
        while (tick > 0){
            System.out.println(Thread.currentThread().getName() + "完成售票，余票为："+ --tick);
        }
    }
}
