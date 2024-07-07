package bsonproblems;

public class NthRootOfANumberDecimal {
	public static void main(String[] args) {
		int num = 5;
		int pow = 2;
		System.out.println(nthRoot(num,pow));
	}

	private static double nthRoot(int num, int pow) {
		double start = 1;
		double end = num;
		double epsilon = 1e-6;//0.000001
		while(end-start>epsilon)
		{
			double mid = (start+end)/2;
			double ans = Math.pow(mid, pow);
			if(ans<num)
			{
				start=mid;
			}
			else
				end=mid;
		}
		return start;
	}
}
