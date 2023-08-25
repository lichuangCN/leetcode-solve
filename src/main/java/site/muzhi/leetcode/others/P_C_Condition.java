package site.muzhi.leetcode.others;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lichuang
 * @date 2022/12/10
 * @description 基于Condition方法实现生产者/消费者
 */
public class P_C_Condition {

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
        Queue<Integer> queue;
        int size;
        AtomicInteger num;
        Lock lock;
        Condition consumerCon;
        Condition productionCon;

        public Buffer(int size) {
            this.queue = new LinkedList<>();
            this.size = size;
            this.num = new AtomicInteger(1);
            lock = new ReentrantLock();
            consumerCon = lock.newCondition();
            productionCon = lock.newCondition();
        }

        public Integer get() throws InterruptedException {
            lock.lock();
            try {
                Integer val = null;
                while (queue.size() == 0) {
                    // 缓冲区为空，消费者线程等待
                    consumerCon.await();
                }
                val = queue.poll();
                // 通知生产者线程可以存放数据
                productionCon.signalAll();
                return val;
            } finally {
                lock.unlock();
            }
        }

        public Integer set() throws InterruptedException {
            lock.lock();
            try {
                Integer val = null;
                while (queue.size() == size) {
                    // 缓冲区已满，释放锁并进入等待状态
                    productionCon.await();
                }
                val = num.getAndIncrement();
                queue.add(val);

                // 唤醒等待的消费的线程
                consumerCon.signalAll();
                return val;
            } finally {
                lock.unlock();
            }
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


