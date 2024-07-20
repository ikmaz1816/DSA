package recursionsubsequenceproblem;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
	public String getString(char ch)
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
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty())
            return ans;
        generateCombinations(digits,"",ans);
        return ans;
    }

    public void generateCombinations(String digits,String p,List<String> ans)
    {
        if(digits.isEmpty())
        {
            ans.add(p);
            return;
        }

        char ch = digits.charAt(0);
        String str = getString(ch);
        for(int i=0;i<str.length();i++)
        {
            generateCombinations(digits.substring(1),p+str.charAt(i),ans);
        }
    }
}
