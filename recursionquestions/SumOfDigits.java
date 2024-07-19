package recursionquestions;

public class SumOfDigits {
	public static void main(String[] args) {
		System.out.println(sumOfDigits(123));
	}

	private static int sumOfDigits(int i) {
		if(i==0)
			return 0;
		return i%10 + sumOfDigits(i/10);
	}
}
