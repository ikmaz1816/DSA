package recursionquestions;

public class Palindrome {
	public static void main(String[] args) {
		int n = 121;
		System.out.println(productOfDigits(n) == n);
	}

	private static int productOfDigits(int i) {
		if(i%10==i)
			return i;
		int digits = (int)Math.log10(i)+1;
		return i%10 * (int)Math.pow(10, digits-1) + productOfDigits(i/10);
	}
}
