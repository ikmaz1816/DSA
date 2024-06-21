package basicrecursion;

public class NumberReverse {
	public static void main(String[] args) {
		System.out.println(numberReverse(123));
	}

	private static int numberReverse(int i) {
		if(i==0)
			return 0;
		return i%10 * helper(i) + numberReverse(i/10);
	}

	private static int helper(int i) {
		int digits = (int)Math.log10(i)+1;
		digits = digits -1 ; //as we have to multiply 3 * 10^digits-1 + 2 * 10^digits-2 + 3 * 10^digits-3;
		return (int)Math.pow(10, digits);
	}
}
