package homework;

import java.util.Arrays;

/**
 * @author zhouyp
 * @program Week_01
 * @description
 * @create 2020-06-28
 */
public class PlusOne {

	static int[] plusOne(int[] nums) {
		for (int i = nums.length - 1; i >= 0; i--) {
			nums[i] = (nums[i] + 1) % 10;
			if (nums[i] != 0) return nums;
		}
		final int[] result = new int[nums.length + 1];
		result[0] = 1;
		return result;
	}

	public static void main(String[] args) {
		final int[] ints = {8, 9, 9, 9, 9, 9, 9};
		System.out.println(Arrays.toString(ints));
		System.out.println(Arrays.toString(plusOne(ints)));
	}
}
