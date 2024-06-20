package patterns;

public class DifferentAlphabetTriangle {
	public static void main(String[] args) {
		int n=4;
		for(int i=0;i<n;i++)
		{
			char p = 'A';
			for(int j=0;j<=i;j++)
			{
				System.out.print(p+" ");
				p+=1;
			}
			System.out.println();
		}
	}
}
