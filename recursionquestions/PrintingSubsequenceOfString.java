package recursionquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintingSubsequenceOfString {
	public static void main(String[] args) {
		String str="abc";
		subsequence(str,"");
		System.out.println(subsequence(str,"",new ArrayList<>()));
		System.out.println(subsequenceArrayList(str,""));
	}

	private static void subsequence(String str, String string) {
		if(str.isEmpty())
		{
			System.out.println(string);
			return;
		}
		char ch = str.charAt(0);
		subsequence(str.substring(1),string+ch);
		subsequence(str.substring(1),string);
	}
	
	private static List<String> subsequence(String str, String string,List<String> ans) {
		if(str.isEmpty())
		{
			ans.add(string);
			return ans;
		}
		char ch = str.charAt(0);
		subsequence(str.substring(1),string+ch,ans);
		subsequence(str.substring(1),string,ans);
		return ans;
	}
	
	private static List<String> subsequenceArrayList(String str, String string) {
		if(str.isEmpty())
		{
			List<String> ans=new ArrayList<>(Arrays.asList(string));
			return ans;
		}
		char ch = str.charAt(0);
		List<String> fromLeft=subsequenceArrayList(str.substring(1),string+ch);
		fromLeft.addAll(subsequenceArrayList(str.substring(1),string));
		return fromLeft;
	}
}
