package homework;

/**
 * @author zhouyp
 * @program leecodetraing
 * @description 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
 * @create 2020-07-05
 */
public class IsAnagram {

	public static void main(String[] args) {
		String s = "a";
		String t = "";
		System.out.println("isAnagram(s, t) = " + isAnagram(s, t));
	}

	static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) return false;
		int[] table = new int[26];
		for (int i = 0; i < s.length(); i++) {
			table[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			table[t.charAt(i) - 'a']--;
			if (table[t.charAt(i) - 'a'] < 0 )
				return false;
		}
		return true;
	}

}
