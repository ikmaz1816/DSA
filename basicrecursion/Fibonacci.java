package basicrecursion;

public class Fibonacci {
	public static void main(String[] args) {
		int n = 5;
		System.out.println(fib(n-1));
	}

	private static int fib(int i) {
		if(i<=1)
			return i;
		return fib(i-1)+fib(i-2);
	}
}
