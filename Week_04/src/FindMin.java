/**
 * @author zhouyp
 * @program leecodetraing
 * @description 153. 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 * @create 2020-07-21
 */
public class FindMin {
	public static void main(String[] args) {
		int[] arr = {6, 0, 1, 2, 3, 4, 5};
		final int min1 = findMinRightAsymptote(arr);
		final int min2 = findMinLeftAsymptote(arr);
		System.out.println(min1);
		System.out.println(min2);
	}

	/**
	 * 最小值：集合不单调的分割点，集合在该点左右两侧分别都是单调的
	 */
	//左边渐近，去寻找最小值
	static int findMinRightAsymptote(int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = right - (right - left) / 2 - 1;
			if (nums[left] > nums[mid]) {
				// 如果集合单调，不会被执行
				right = mid;
			} else if (nums[left] < nums[mid]) {
				// 如果集合单调，一定执行这里
				// 这里将会导致left值错误
				left = mid + 1;
			} else break;
		}
		return nums[(left + 1) % nums.length];
	}

	//左边渐近，去寻找最小值
	static int findMinLeftAsymptote(int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2 + 1;
			if (nums[left] > nums[mid]) {
				right = mid - 1;
			} else {
				left = mid;
			}
		}
		return nums[(right + 1) % nums.length];
	}

}
