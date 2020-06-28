/**
 * @author zhouyp
 * @program Week_01
 * @description
 * @create 2020-06-28
 */
public class BinarySort {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int low = 0;
		int high = arr.length - 1;
		System.out.println(bs(arr, low, high, 5));
	}

	static int bs(int[] a, int low, int high, int key) {
		if (low > high) return -1;
		int mid = (low + high) >>> 1;
		if (a[mid] == key) return mid;
		if (a[mid] > key) {
			return bs(a, low, mid - 1, key);
		} else {
			return bs(a, mid + 1, high, key);
		}
	}
}
