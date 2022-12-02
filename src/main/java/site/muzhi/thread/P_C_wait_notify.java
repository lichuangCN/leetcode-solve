package site.muzhi.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lichuang
 * @date 2022/12/01
 * @description 多线程 生产者和消费者
 */
public class P_C_wait_notify {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);
        Thread p1 = new Thread(new Producer(buffer), "producer-1");
        Thread p2 = new Thread(new Producer(buffer), "producer-2");

        Thread c1 = new Thread(new Consumer(buffer), "consumer-1");

        p1.start();
        p2.start();
        c1.start();
    }
}


/**
 * 公共缓冲区
 */
class Buffer {
    Queue<Integer> queue;
    int size;
    AtomicInteger num;

    public Buffer(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
        this.num = new AtomicInteger(0);
    }

    public synchronized Integer get() throws InterruptedException {
        Integer val = null;
        while (queue.size() == 0) {
            // 缓冲区为空，释放锁并进入等待状态
            this.wait();
        }
        val = queue.poll();

        // 唤醒等待的线程:
        // 会将所有等待的线程唤醒，包括消费者线程和生产者线程
        // 多个消费者、生产者时，如果使用notify()方法，存在死锁的风险，set()方法通同理
        // 比如：两个消费者，一个生产者，并且生产者因为缓冲区已满而处于等待状态
        // 消费者1通过notify()可能会唤醒消费者2，此时三个线程都处于等待状态，导致死锁
        this.notifyAll();
        return val;
    }

    public synchronized Integer set() throws InterruptedException {
        Integer val = null;
        while (queue.size() == size) {
            // 缓冲区已满，释放锁并进入等待状态
            this.wait();
        }
        val = num.getAndIncrement();
        queue.add(val);

        // 唤醒等待的线程:
        // 会将所有等待的线程唤醒，包括消费者线程和生产者线程
        this.notifyAll();
        return val;
    }
}

/**
 * 生产者
 */
class Producer implements Runnable {

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
class Consumer implements Runnable {

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






