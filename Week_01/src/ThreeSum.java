import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhouyp
 * @program Week_01
 * @description
 * @create 2020-06-28
 */
public class ThreeSum {

	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 3, -4, 5, 0, -6, 7, 8, 9, 10, 0};
		final List<List<Integer>> lists = threeSum(arr);
		System.out.println(lists);
	}

	static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int lo = i + 1, hi = nums.length - 1, sum = -nums[i];
				while (lo < hi) {
					if (nums[lo] + nums[hi] == sum) {
						res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
						while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
						while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
						lo++;
						hi--;
					} else if (nums[lo] + nums[hi] < sum) lo++;
					else hi--;
				}
			}
		}
		return res;
	}
}
