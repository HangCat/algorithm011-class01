package homework;

import java.util.Arrays;

/**
 * @author zhouyp
 * @program Week_01
 * @description
 * @create 2020-06-28
 */
public class MoveZeroes {

	public static void main(String[] args) {
		int[] arr = {0,1, 2, 3, 4, 5, 0, 6, 7, 8, 9, 10, 0};
		moveZeroes(arr);
		System.out.println("arr = " + Arrays.toString(arr));
	}

	static void moveZeroes(int[] nums) {
		if (nums == null) return;
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j++] = temp;
			}
		}
	}

}
