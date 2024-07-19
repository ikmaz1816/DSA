package recursionquestions;

public class CountZeroes {
	public static void main(String[] args) {
		System.out.println(countZeroes(200,0));//if leading zeroes then remove them
	}

	private static int countZeroes(int i,int c) {
		if(i==0)
			return c;
		if(i%10==0)
			return countZeroes(i/10,c+1);
		return countZeroes(i/10,c);
	}
}
