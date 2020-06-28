package homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouyp
 * @program Week_01
 * @description
 * @create 2020-06-28
 */
public class TwoSum {

	static int[] twoSum(int[] arr, int target) {
		final Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.get(target - arr[i]) != null) {
				return new int[]{map.get(target - arr[i]), i};
			}
			map.put(arr[i], i);
		}
		return new int[]{0, 0};
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6};
		final int[] ints = twoSum(arr, 7);
		System.out.println(Arrays.toString(ints));
	}

}
