package patterns;

public class HolloNumberReverse {
	public static void main(String[] args) {
		int n = 5;
		int x = n -1 ;
		for(int i=1;i<=n;i++)
		{
			int k;
			for(k=1;k<=i;k++)
			{
				System.out.print(k);
			}
			for(int j=1;j<=2*x;j++)
			{
				System.out.print(" ");
			}
			k-=1;
			for(;k>0;k--)
			{
				System.out.print(k);
			}
			x--;
			System.out.println();
		}
	}
}
