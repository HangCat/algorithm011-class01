/**
 * @author zhouyp
 * @program Week_01
 * @description
 * @create 2020-06-28
 */
public class MaxArea {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		final int area = maxArea(arr);
		System.out.println("area = " + area);
	}

	public static int maxArea(int[] height) {
		int wide = height.length - 1;
		int p = 0, q = wide;
		int minHeight, area = 0;

		for (; wide > 0; wide--) {
			if (height[p] > height[q]) {
				minHeight = height[p];
				q--;
			} else {
				minHeight = height[q];
				p++;
			}
			area = Math.max(minHeight * wide, area);
		}
		return area;
	}

}
