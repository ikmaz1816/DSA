package recursionquestions;

public class FibonacciSeries {
	public static void main(String[] args) {
		int n = 5;
		System.out.println(fib(n-1));
	}

	private static int fib(int n) {
		if(n<=1)
			return n;
		return fib(n-1)+fib(n-2);
	}
}
