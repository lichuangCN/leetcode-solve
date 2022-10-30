package site.muzhi.itbook.bk_1.chapter_1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lichuang
 * @date 2022/10/30
 * @description
 */
public class Q4_1 {
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

            // 时间戳
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
        }

        private Pet pollDog() {

        }

        private Pet pollCat() {

        }

        private boolean isEmpty() {

        }

        private boolean isDogEmpty() {

        }

        private boolean isCatEmpty() {

        }

    }

}
