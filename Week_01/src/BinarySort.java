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
		System.out.println(bs1(arr, low, high, 5));
	}

	static int bs(int[] a, int low, int high, int key) {
		if (low > high) return -1;
		int mid = (low + high) >>> 1;
		if (a[mid] == key) return mid;
		else if (a[mid] > key)
			return bs(a, low, mid - 1, key);
		else return bs(a, mid + 1, high, key);
	}

	static int bs1(int[] arr, int low, int high, int key) {
		while (low <= high) {
			int mid = (low + high) >>> 1;
			if (arr[mid] == key) return mid;
			else if (arr[mid] > key)
				high = mid - 1;
			else low = mid + 1;
		}
		return -1;
	}

}
