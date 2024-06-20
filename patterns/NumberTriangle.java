package patterns;

public class NumberTriangle {
	public static void main(String[] args) {
		int n=4;
		int x=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print(++x+" ");
			}
			System.out.println();
		}
	}
}
