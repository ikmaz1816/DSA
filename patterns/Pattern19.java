package patterns;

public class Pattern19 {
	public static void main(String[] args) {
		int n = 5;
		int x = n-1 ;
		for(int i=n;i>0;i--)
		{
			int k=1;
			for(;k<=i;k++)
			{
				System.out.print("*");
			}
			k-=1;
			int spaces =  2*(n-k);
			for(int j=1;j<=spaces;j++)
			{
				System.out.print(" ");
			}
			
			for(;k>0;k--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=1;i<=n;i++)
		{
			int k;
			for(k=1;k<=i;k++)
			{
				System.out.print("*");
			}
			for(int j=1;j<=2*x;j++)
			{
				System.out.print(" ");
			}
			k-=1;
			for(;k>0;k--)
			{
				System.out.print("*");
			}
			x--;
			System.out.println();
		}
	}
}
