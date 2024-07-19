package recursionquestions;


public class PermutationOfString {
	public static void main(String[] args) {
		String str = "abc";
		printPermutation(str,"");
	}

	private static void printPermutation(String str, String ans) {
		if(str.isEmpty())
		{
			System.out.println(ans);
			return;
		}
		char ch = str.charAt(0);
		for(int i=0;i<=ans.length();i++)
		{
			String first = ans.substring(0,i);
			String second = ans.substring(i);
			printPermutation(str.substring(1),first+ch+second);
		}
	}
}
