package recursionquestions;

public class SkipACharacter {
	public static void main(String[] args) {
		System.out.println(skip("abcccdce",'c',""));
	}

	private static String skip(String string, char c, String string2) {
		if(string.isEmpty())
		{
			return string2;
		}
		char ch = string.charAt(0);
		if(ch==c)
			return skip(string.substring(1),c,string2);
		return skip(string.substring(1),c,string2+ch);
	}
}
