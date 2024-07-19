package recursionquestions;

public class ReverseANumber {
	public static void main(String[] args) {
		System.out.println(productOfDigits(712));
	}

	private static int productOfDigits(int i) {
		if(i%10==i)
			return i;
		int digits = (int)Math.log10(i)+1;
		return i%10 * (int)Math.pow(10, digits-1) + productOfDigits(i/10);
	}
}
