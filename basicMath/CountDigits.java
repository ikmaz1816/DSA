package basicmath;

public class CountDigits {
	public static void main(String[] args) {
		int num = 123;
		int temp = num;
		int count = 0;
		while(temp > 0)
		{
			temp/=10;
			count++;
		}
		
		System.out.println(count+" "+((int)Math.log10(num)+1));
		//Math.log10(num)+1 gives the number of digits
	}
}
