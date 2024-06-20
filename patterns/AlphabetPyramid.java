package patterns;

public class AlphabetPyramid {
	public static void main(String[] args) {
		int n = 5;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-i-1;j++)
			{
				System.out.print(" ");
			}
			int count=0;
			for(int j=0;j<=i;j++)
			{
				System.out.print((char)('A'+j));
				count++;
			}
			count--;
			for(int j=i;j>0;j--)
			{
				System.out.print((char)('A'+ --count));
			}
			System.out.println();
		}
	}
}
