package basicmath;

public class PrintAllDivisors {
	public static void main(String[] args) {
		int num = 24;
		for(int i=1;i<=num/2;i++)
		{
			if(num%i==0)
			{
				System.out.print(i+" ");
			}
		}
	}
}
