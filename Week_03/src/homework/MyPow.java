package homework;

/**
 * @author zhouyp
 * @program leecodetraing
 * @description
 * @create 2020-07-12
 */
public class MyPow {

	public static void main(String[] args) {
		double v = myPowRecursion(2.0, 3);
		System.out.println(v);
	}

	static double quickMulRecursion(double x, long N) {
		if (N == 0) {
			return 1.0;
		}
		double y = quickMulRecursion(x, N / 2);
		return N % 2 == 0 ? y * y : y * y * x;
	}

	static double myPowRecursion(double x, int n) {
		long N = n;
		return N >= 0 ? quickMulRecursion(x, N) : 1.0 / quickMulRecursion(x, -N);
	}

	static double quickMulIterator(double x, long N) {
		double ans = 1.0;
		// 贡献的初始值为 x
		double x_contribute = x;
		// 在对 N 进行二进制拆分的同时计算答案
		while (N > 0) {
			if (N % 2 == 1) {
				// 如果 N 二进制表示的最低位为 1，那么需要计入贡献
				ans *= x_contribute;
			}
			// 将贡献不断地平方
			x_contribute *= x_contribute;
			// 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
			N /= 2;
		}
		return ans;
	}

	static double myPowIterator(double x, int n) {
		long N = n;
		return N >= 0 ? quickMulIterator(x, N) : 1.0 / quickMulIterator(x, -N);
	}

}
