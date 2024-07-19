package recursionquestions;

public class PrintAllPaths {
	public static void main(String[] args) {
		//Here we are considering a grid of 3 * 3
		printPaths(2,2,"");
	}

	private static void printPaths(int r, int c,String ans) {
		if(r==0 && c==0)
		{
			System.out.println(ans);
			return;
		}
		if(r>0 && c>0)
			printPaths(r-1,c-1,ans+'V');
		if(r>0)
			printPaths(r-1,c,ans+'D');
		if(c>0)
			printPaths(r,c-1,ans+'R');
	}
}
