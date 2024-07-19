package recursionquestions;

public class CountStep {
	public static void main(String[] args) {
		// You are given a number check how many steps are required to make it zero
		int n = 15;
		System.out.println(countSteps(n));
	}

	private static int countSteps(int n) {
		if(n==0)
			return 1;
		int count = 1;
		if(n%2==0)
			count+=countSteps(n/2);
		else
			count+=countSteps(n-1);
		return count;
	}
}
