package designModel.service;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCalculate extends RecursiveTask {
    private static final long serialVersionUID = 12345678L;

    private long start;
    private long end;

    private static final long THERSHOLD = 10000;

    public ForkJoinCalculate() {
    }

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long len = end - start;
        if(len < THERSHOLD){
            long sum = 0;
            for (long i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        } else {
           long middle = (start + end) /2;
            ForkJoinCalculate left = new ForkJoinCalculate(start,middle);
            left.fork();
            ForkJoinCalculate right = new ForkJoinCalculate(middle+1,end);
            right.fork();
            return (long)left.join() + (long)right.join();
        }
    }
}
