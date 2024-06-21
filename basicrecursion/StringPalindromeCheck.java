package basicrecursion;

public class StringPalindromeCheck {
	public static void main(String[] args) {
		String str="abc";
		String str1 = reverse(str,"");
		System.out.println(str.equals(str1) ? "Palindrome" : "Not Palindrome");
	}

	private static String reverse(String str,String p) {
		if(str.isEmpty())
		{
			return p;
		}
		return reverse(str.substring(1),str.charAt(0)+p);
		
	}
}
