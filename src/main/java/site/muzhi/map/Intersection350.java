package site.muzhi.map;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 350.给定两个数组，编写一个函数来计算它们的交集。 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。 输入: nums1 =
 * [1,2,2,1], nums2 = [2,2] 输出: [2,2]
 *
 * @author lichuang
 * @date 2020/02/06
 */
public class Intersection350 {

	public static void main(String[] args) {
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};
		int[] result = intersect(nums1, nums2);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

	public static int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> tempMap = new HashMap<>();
		ArrayList<Integer> resultList = new ArrayList<>();
		for (int i : nums1) {
			if (!tempMap.containsKey(i)) {
				tempMap.put(i, 1);
			} else {
				// 元素出现的次数+1
				tempMap.put(i, tempMap.get(i) + 1);
			}
		}
		for (int j : nums2) {
			if (tempMap.containsKey(j) && tempMap.get(j) > 0) {
				resultList.add(j);
				// 元素出现的次数-1
				tempMap.put(j, tempMap.get(j) - 1);
			}
		}

		// 取出list中的数据
		int[] result = new int[resultList.size()];
		for (int k = 0; k < result.length; k++) {
			result[k] = resultList.get(k);
		}
		return result;
	}

}
