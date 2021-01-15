package designModel.service.juc;

import com.sun.tools.javadoc.Start;

/**
 * volatile 关键字：当多个线程进行操作数据共享时，可以保证内存中的数据可见
 *              相较于synchronized是一种较为轻量级的同步策略
 *
 *  注意：
 *  1。volatile不具备互斥性
 *  2。volatile不能保证变脸的原子性
 *
 */
public class TestVolatile {

    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();

        while (true) {
//            synchronized (td){
                if(td.isFlag()){
                    System.out.println("---------");
                    break;
                }
//            }
        }
    }

}

class ThreadDemo implements Runnable{

    private volatile boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = true;

        System.out.println("flag =" + isFlag());
    }

}