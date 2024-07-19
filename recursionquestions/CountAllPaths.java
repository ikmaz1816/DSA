package recursionquestions;

public class CountAllPaths {
	public static void main(String[] args) {
		//Here we are considering a grid of 3 * 3
		System.out.println(printCountOfAllPaths(2,2));
	}

	private static int printCountOfAllPaths(int r, int c) {
		if(r==0 || c==0)
			return 1;
		int count=0;
		count+=printCountOfAllPaths(r-1,c);
		count+=printCountOfAllPaths(r,c-1);
		return count;
	}
}
