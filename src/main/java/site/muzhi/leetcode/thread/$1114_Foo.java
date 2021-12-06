package site.muzhi.leetcode.thread;

import java.util.concurrent.Semaphore;

/**
 * @author lichuang
 * @date 2021/05/20
 * @description
 */
public class $1114_Foo {
    class Foo {

        Semaphore semaphore12;
        Semaphore semaphore23;

        public Foo() {
            semaphore12 = new Semaphore(0);
            semaphore23 = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            semaphore12.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            semaphore12.acquire();
            printSecond.run();
            semaphore23.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            semaphore23.acquire();
            printThird.run();
        }
    }
}
