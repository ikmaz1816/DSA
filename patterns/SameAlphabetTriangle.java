package patterns;

public class SameAlphabetTriangle {
	public static void main(String[] args) {
		int n=4;
		for(int i=0;i<n;i++)
		{
			char p = (char)('A'+i);
			for(int j=0;j<=i;j++)
			{
				System.out.print(p+" ");
			}
			System.out.println();
		}
	}
}
