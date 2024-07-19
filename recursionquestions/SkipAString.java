package recursionquestions;

public class SkipAString {
	public static void main(String[] args) {
		System.out.println(skip("abccccdccec","cc",""));
	}

	private static String skip(String string, String toBeSkipped,String string2) {
		if(string.isEmpty())
		{
			return string2;
		}
		if(string.startsWith(toBeSkipped))
		{
			return skip(string.substring(toBeSkipped.length()),toBeSkipped,string2);
		}
		return skip(string.substring(1),toBeSkipped,string2+string.charAt(0));
	}
}
