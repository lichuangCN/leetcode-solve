package site.muzhi.interview;

/**
 * @author lichuang
 * @date 2021/02/18
 * @description 一个数组来记录三个栈
 */
public class $03_01_TripleInOne {
    class TripleInOne {

        int[] stack;
        // 栈大小
        int stackSize;
        // 记录栈的容量
        int[] size;

        public TripleInOne(int stackSize) {
            stack = new int[3 * stackSize];
            this.stackSize = stackSize;
            size = new int[]{0, 0, 0};
        }

        public void push(int stackNum, int value) {
            int len = size[stackNum];
            if (len < stackSize) {
                stack[stackNum * stackSize + len] = value;
                size[stackNum]++;
            }
        }

        public int pop(int stackNum) {
            if (size[stackNum] == 0) {
                return -1;
            }
            int val = peek(stackNum);
            size[stackNum]--;
            return val;
        }

        public int peek(int stackNum) {
            int len = size[stackNum];
            if (len == 0) {
                return -1;
            }
            return stack[stackSize * stackNum + len - 1];
        }

        public boolean isEmpty(int stackNum) {
            return size[stackNum] == 0;
        }
    }

}
