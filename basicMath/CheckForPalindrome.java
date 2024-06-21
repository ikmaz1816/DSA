package basicmath;

public class CheckForPalindrome {
	public static void main(String[] args) {
		int num = 121;
		int temp = num;
		int rev = 0;
		while(num > 0)
		{
			rev = rev * 10 + (num%10);
			num/=10;
		}
		System.out.println(rev==temp ? "Palindrome" : "Not Palindrome");
	}
}
