/**
 * @author zhouyp
 * @program leecodetraing
 * @description
 * @create 2020-06-22
 */
public class ClimbStairs {

	static int[] memo;

	//传统递归
	public static int r1(int n) {
		if (n <= 1) return 1;
		return r1(n - 1) + r1(n - 2);
	}

	//记忆化递归
	public static int r2(int n) {
		if (memo[n] > 0) return memo[n];
		if (n <= 1) memo[n] = 1;
		else
			memo[n] = r2(n - 1) + r2(n - 2);
		return memo[n];
	}

	//传统动态规划
	public static int dp1(int n) {
		if (n <= 1) return 1;
		final int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	// 优化后的动态规划
	public static int dp2(int n) {
		int p, q = 0, r = 1;
		for (int i = 0; i < n; i++) {
			p = q;
			q = r;
			r = p + q;
		}
		return r;
	}

	public static void main(String[] args) {
		System.out.println("r1(10) = " + r1(10));
		System.out.println("r2(10) = " + r2(10));
		System.out.println("dp1(10) = " + dp1(10));
		System.out.println("dp2(10) = " + dp2(10));
	}
}
