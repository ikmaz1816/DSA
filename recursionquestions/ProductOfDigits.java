package recursionquestions;

public class ProductOfDigits {
	public static void main(String[] args) {
		System.out.println(productOfDigits(712));
	}

	private static int productOfDigits(int i) {
		if(i%10==i)
			return i;
		return i%10 * productOfDigits(i/10);
	}
}
