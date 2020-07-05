package homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouyp
 * @program Week_02
 * @description
 * @create 2020-07-05
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		System.out.println("twoSum(nums, 9) = " + Arrays.toString(twoSum(nums, 9)));
	}

	static int[] twoSum(int[] nums, int target) {
		final Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(target - nums[i]) != null)
				return new int[]{map.get(target - nums[i]), i};
			map.put(nums[i], i);
		}
		return new int[]{0, 0};
	}

}
