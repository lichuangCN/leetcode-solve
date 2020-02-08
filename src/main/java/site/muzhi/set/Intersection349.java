package site.muzhi.set;

import java.util.HashSet;

/**
 * 349.给定两个数组，编写一个函数来计算它们的交集。 输入: nums1 = [1,2,2,1], nums2 = [2,2] 输出: [2]
 *
 * @author lichuang
 * @date 2020/02/06
 */
public class Intersection349 {

	public static void main(String[] args) {
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};
		int[] result = intersection(nums1, nums2);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> tempSet = new HashSet<Integer>();
		HashSet<Integer> resultSet = new HashSet<Integer>();
		for (int i : nums1) {
			tempSet.add(i);
		}
		for (int j : nums2) {
			if (tempSet.contains(j)) {
				resultSet.add(j);
			}
		}
		int[] result = new int[resultSet.size()];
		int index = 0;
		for (int ele : resultSet) {
			result[index] = ele;
			index++;
		}
		return result;
	}

}
