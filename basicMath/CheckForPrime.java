package basicmath;

public class CheckForPrime {
	public static void main(String[] args) {
		int num = 4;
		boolean isPrime = true;
		for(int i=2;i*i<=num;i++)
		{
			if(num%i==0)
			{
				isPrime = false;
				break;
			}
		}
		System.out.println(isPrime? "Number is Prime" : "Not a prime Number");
	}
}
