package patterns;

public class ReversePyramid {
	public static void main(String[] args) {
		int n = 4;
		for(int i=n-1;i>=0;i--)
		{
			for(int j=0;j<n-i-1;j++)
			{
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++)
			{
				System.out.print("*");
			}
			for(int j=i;j>0;j--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
