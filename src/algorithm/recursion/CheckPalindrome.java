package algorithm.recursion;

public class CheckPalindrome {

	public boolean isPalindrome(String s, int low, int high) {
		if(low>=high) return true;
		if(s.charAt(high)!=s.charAt(low)) return false;
		return isPalindrome(s, low+1, high-1);
	}
	public static void main(String[] args) {
		String test1="akash";
		String test2="nayan";
		CheckPalindrome cp=new CheckPalindrome();
		System.out.println(cp.isPalindrome(test1, 0,test1.length()-1));
		System.out.println(cp.isPalindrome(test2, 0,test2.length()-1));
	}

}
