package site.muzhi.thread;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lichuang
 * @date 2021/06/04
 * @description 生产者-消费者
 */
public class C_P {

    public static void main(String[] args) {
        Buffer buffer = new Buffer(10);
        Thread producer1 = new Thread(new Producer(buffer));
        producer1.setName("生产者1");
        Thread producer2 = new Thread(new Producer(buffer));
        producer2.setName("生产者2");

        Thread consumer = new Thread(new Consumer(buffer));
        consumer.setName("消费者1");

        producer1.start();
        producer2.start();
        consumer.start();
    }
}

/**
 * 内容缓存区域
 */
class Buffer {

    private Queue<Integer> buffer;
    private Integer size;
    private AtomicInteger num;

    Buffer(Integer size) {
        this.size = size;
        // 初始化缓存区
        buffer = new ArrayDeque<>();
        num = new AtomicInteger(0);
    }

    public synchronized Integer get() {
        Integer val = null;
        if (buffer.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            val = buffer.poll();
        }
        this.notifyAll();
        return val;
    }

    public synchronized Integer set() {
        Integer val = 0;
        if (buffer.size() == size) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            val = num.getAndIncrement();
            buffer.offer(val);
        }
        this.notifyAll();
        return val;
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
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer val = buffer.get();
            System.out.println(Thread.currentThread().getName() + "消费的商品的序列号：" + val);
        }
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
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer val = buffer.set();
            System.out.println(Thread.currentThread().getName() + "生产的商品的序列号：" + val);
        }
    }
}
