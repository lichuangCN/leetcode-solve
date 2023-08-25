package site.muzhi.leetcode.main;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lichuang
 * @date 2021/05/21
 * @description
 */
public class $1114_Foo_2 {
    class Foo {

        ReentrantLock lock;
        Condition condition1;
        Condition condition2;
        Condition condition3;
        int num;

        public Foo() {
            lock = new ReentrantLock();
            condition1 = lock.newCondition();
            condition2 = lock.newCondition();
            condition3 = lock.newCondition();
            num = 1;
        }

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            try {
                while (num != 1) {
                    condition1.await();
                }
                printFirst.run();
                num = 2;
                condition2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            try {
                while (num != 2) {
                    condition2.await();
                }
                printSecond.run();
                num = 3;
                condition3.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            try {
                while (num != 3) {
                    condition3.await();
                }
                printThird.run();
                num = 1;
                condition1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
