package recursionquestions;

public class CellPhone {
	public static String getString(char ch)
	{
		switch(ch)
		{
			case '2':
				return "abc";
			case '3':
				return "def";
			case '4':
				return "ghi";
			case '5':
				return "jkl";
			case '6':
				return "mno";
			case '7':
				return "pqrs";
			case '8':
				return "tuv";
			case '9':
				return "wxyz";
		}
		return "";
	}
	
	public static void main(String[] args) {
		String digits="23";
		printAllCombination(digits,"");
	}

	private static void printAllCombination(String digits, String string) {
		if(digits.isEmpty())
		{
			System.out.println(string);
			return;
		}
		char ch = digits.charAt(0);
		String str = getString(ch);
		for(int i=0;i<str.length();i++)
		{
			printAllCombination(digits.substring(1),string+str.charAt(i));
		}
	}
}
