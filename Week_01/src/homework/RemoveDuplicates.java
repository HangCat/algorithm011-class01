package homework;

import java.util.Arrays;

/**
 * @author zhouyp
 * @program Week_01
 * @description
 * @create 2020-06-28
 */
public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 1, 2, 3, 4, 5, 6, 6, 6, 6};
		final int rr = removeDuplicates(arr);
		System.out.println(Arrays.toString(arr));
	}

	static int removeDuplicates(int[] nums) {
		int pos = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != nums[pos]) {
				pos++;
				nums[pos] = nums[i];
			}
		}
		return pos + 1;
	}

}
