package recursionquestions;

public class SumOfDice {
	public static void main(String[] args) {
		int target = 5;
		printAllCombination(target,"");
	}
	

	private static void printAllCombination(int target,String ans) {
		if(target==0)
		{
			System.out.println(ans);
			return;
		}
		for(int i=1;i<=6 && i<=target ;i++)
		{
			printAllCombination(target-i,ans+i);
		}
	}
}
