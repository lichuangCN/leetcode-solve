package site.muzhi.leetcode.interview;

import java.util.LinkedList;

/**
 * @author lichuang
 * @date 2021/02/18
 * @description
 */
public class $03_06_AnimalShelf {

    class AnimalShelf {

        LinkedList<int[]> cat;
        LinkedList<int[]> dog;

        public AnimalShelf() {
            cat = new LinkedList<>();
            dog = new LinkedList<>();
        }

        // dequeAny则比较两个队首的编号，animal[0]待办动物编号。
        // animal[1]代表动物种类，0代表猫，1代表狗。
        public void enqueue(int[] animal) {
            // 判明种类后入队
            if (animal[1] == 0) {
                cat.addLast(animal);
            } else if (animal[1] == 1) {
                dog.addLast(animal);
            }
        }

        public int[] dequeueAny() {
            int[] headCat;
            if (!cat.isEmpty()) {
                headCat = cat.getFirst();
            } else if (!dog.isEmpty()) {
                return dog.removeFirst();
            } else {
                return new int[]{-1, -1};
            }

            int[] headDog;
            if (!dog.isEmpty()) {
                headDog = dog.getFirst();
            } else {
                return cat.removeFirst();
            }
            // 比较最长时间
            if (headCat[0] <= headDog[0]) {
                return cat.removeFirst();
            } else {
                return dog.removeFirst();
            }

        }

        public int[] dequeueDog() {
            if (!dog.isEmpty()) {
                return dog.removeFirst();
            }
            return new int[]{-1, -1};
        }

        public int[] dequeueCat() {
            if (!cat.isEmpty()) {
                return cat.removeFirst();
            }
            return new int[]{-1, -1};
        }
    }
}
