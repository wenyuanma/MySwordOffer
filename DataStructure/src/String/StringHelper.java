package String;

import java.util.HashSet;
import java.util.Set;


public class StringHelper {
	//寻找字母序列的全排列
	//思想：就是把字符串拆除一个个字母，每一个新的字母都向已排列的字符串插入
	//比如： 对于 BC来说，有两种排列 BC,CB，此时分别向这两个排列插入字母A，并且依据BC的长度有三种插入的位置ABC,BAC,BCA
	public static Set<String> permutationFinder(String str) {
		Set<String> perm = new HashSet<String>();
		// Handling error scenarios
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			perm.add("");
			return perm;
		}
		char initial = str.charAt(0); // first character
		String rem = str.substring(1); // Full string without first character
		Set<String> words = permutationFinder(rem);
		for (String strNew : words) {
			for (int i = 0; i <= strNew.length(); i++) {
				perm.add(charInsert(strNew, initial, i));
				System.out.println(words+" : "+ i + perm );
			}
		}
		return perm;
	}

	private static boolean isPalindrome(String str) {
		if (str == null)
		return false;
		StringBuilder strBuilder = new StringBuilder(str);
		strBuilder.reverse();
		return strBuilder.toString().equals(str);
	}
	
	private static boolean isPalindrome2(String str) {
		if (str == null)
			return false;
		int length = str.length();
		System.out.println(length / 2);
		for (int i = 0; i < length / 2; i++) {
			if (str.charAt(i) != str.charAt(length - i - 1))
				return false;
		}
		return true;
	}

	private static String removeChar(String str, char c) {
		if (str == null)
		return null;
		return str.replaceAll(Character.toString(c),"");
	}
	public static String charInsert(String str, char c, int j) {
		String begin = str.substring(0, j);
		String end = str.substring(j);
		return begin + c + end;
	}

	public static void main(String[] args) {
		String s = "AAC";
		String s1 = "ABC";   
		String s2 = "ABCD";
		//System.out.println( s +  permutationFinder(s));
		System.out.println( s1 +  permutationFinder(s1));
		//System.out.println(s2 +  permutationFinder(s2));
		String ss = "abcba";
		System.out.println(isPalindrome(ss));
		
	}
}
