package site.muzhi.itbook.bk_1.chapter_1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lichuang
 * @date 2022/10/30
 * @description
 */
public class Q4 {
    class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    class Dog extends Pet {

        public Dog() {
            super("dog");
        }
    }

    class Cat extends Pet {

        public Cat() {
            super("cat");
        }
    }

    class PetQueue {

        // 封装对象
        class PetInner {
            private Pet pet;

            // 时间戳表明入队的先后顺序
            private long timestamp;

            public PetInner(Pet pet, long timestamp) {
                this.pet = pet;
                this.timestamp = timestamp;
            }

            public Pet getPet() {
                return pet;
            }

            public long getTimestamp() {
                return timestamp;
            }
        }

        private Queue<PetInner> dogQueue;
        private Queue<PetInner> catQueue;

        public PetQueue() {
            this.dogQueue = new LinkedList<>();
            this.catQueue = new LinkedList<>();
        }

        private void add(Pet pet) {
            if ("cat".equals(pet.getType())) {
                catQueue.add(new PetInner(pet, System.currentTimeMillis()));
            } else {
                dogQueue.add(new PetInner(pet, System.currentTimeMillis()));
            }
        }

        private Pet pollAll() {
            if (!catQueue.isEmpty() && !dogQueue.isEmpty()) {
                // 先进来的先出去
                if (catQueue.peek().getTimestamp() < dogQueue.peek().getTimestamp()) {
                    return catQueue.poll().getPet();
                } else {
                    return dogQueue.poll().getPet();
                }
            }
            if (!catQueue.isEmpty()) {
                return catQueue.poll().getPet();
            }
            if (!dogQueue.isEmpty()) {
                return dogQueue.poll().getPet();
            }
            return null;
        }

        private Pet pollDog() {
            if (!dogQueue.isEmpty()) {
                return dogQueue.poll().getPet();
            }
            return null;
        }

        private Pet pollCat() {
            if (!catQueue.isEmpty()) {
                return catQueue.poll().getPet();
            }
            return null;
        }

        private boolean isEmpty() {
            return catQueue.isEmpty() && dogQueue.isEmpty();
        }

        private boolean isDogEmpty() {
            return dogQueue.isEmpty();
        }

        private boolean isCatEmpty() {
            return catQueue.isEmpty();
        }

    }

}
