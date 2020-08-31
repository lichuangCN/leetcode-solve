package site.muzhi.array;

/**
 * @author: LiChuang
 * @date: 2020/02/14
 * @description: 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。
 * 假设只有一个重复的整数，找出这个重复的数。
 */
public class $287_FindDuplicate {

    /**
     * 数组只是可读
     * 采用快慢指针的思想：将数组中的元素作为每个链表节点的地址，重复元素的值即是链表中环的入口节点的地址
     * 快指针的步伐为2，慢指针的步伐为1
     *
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        int fast = 0, slow = 0;

        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            // 快慢指针相遇
            if (nums[fast] == nums[slow]) {
                fast = 0;
                // 当再次相遇时，则到达链表的环的入口节点
                while (nums[fast] != nums[slow]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[fast];
            }
        }
    }


    /**
     * 可以修改数组
     * 因为其中的整数只有一个整数是重复的，因此可以将其中的数字放置到相应的位置
     * 如： i 放置到 nums[i]中
     * 如果 k == nums[k] 则表明重复元素为k
     * 遍历一次数组进行一次交换即可找出重复元素
     *
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        while (true) {
            // nums[0] 作为交换的哨兵, 交换的nums[i]元素存在nums[0]中
            int num = nums[0];
            // 出现重复元素
            if (nums[num] == num) {
                return nums[num];
            }
            // 将元素放置到相应位置, 顺序不可错
            nums[0] = nums[num];
            nums[num] = num;
        }
    }
}
