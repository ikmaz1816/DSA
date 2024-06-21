package basicmath;

public class ArmstrongNumber {
	public static void main(String[] args) {
		int number = 127;
		int temp = number;
		int sum =0;
		while(temp>0)
		{
			sum+=(int)(Math.pow(temp%10, 3));
			temp/=10;
		}
		System.out.println(sum==number ? "Armstrong" : "Not armstrong");
	}
}
