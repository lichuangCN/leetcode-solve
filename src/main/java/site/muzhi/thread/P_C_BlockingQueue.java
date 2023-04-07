package site.muzhi.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lichuang
 * @date 2022/12/10
 * @description 基于Condition方法实现生产者/消费者
 */
public class P_C_BlockingQueue {

    public static void main(String[] args) {
        Buffer buffer = new Buffer(2);
        Thread p1 = new Thread(new Producer(buffer), "producer-1");
        Thread p2 = new Thread(new Producer(buffer), "producer-2");

        Thread c1 = new Thread(new Consumer(buffer), "consumer-1");

        p1.start();
        p2.start();
        c1.start();
    }

    /**
     * 公共缓冲区
     */
    static class Buffer {

        BlockingQueue<Integer> queue;
        AtomicInteger num;

        public Buffer(int size) {
            this.queue = new ArrayBlockingQueue<>(size);
            this.num = new AtomicInteger(1);
        }

        public Integer get() throws InterruptedException {
            Integer val = queue.take();
            return val;
        }

        public Integer set() throws InterruptedException {
            Integer val = num.getAndIncrement();
            queue.put(val);
            return val;
        }
    }

    /**
     * 生产者
     */
    static class Producer implements Runnable {

        Buffer buffer;

        public Producer(Buffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Integer val = buffer.set();
                    String log = String.format("Producer Thread: %s, set num: %d.", Thread.currentThread().getName(), val);
                    System.out.println(log);
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 消费者
     */
    static class Consumer implements Runnable {

        Buffer buffer;

        public Consumer(Buffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Integer val = buffer.get();
                    String log = String.format("Consumer Thread: %s, get num: %d.", Thread.currentThread().getName(), val);
                    System.out.println(log);
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}


