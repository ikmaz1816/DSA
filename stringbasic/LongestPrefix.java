package stringbasic;

public class LongestPrefix {
	public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if(length==0)
            return "";
        String prefix = strs[0];
        for(int i=1;i<length;i++)
        {
            while(strs[i].indexOf(prefix)!=0)
            {
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.length()==0)
                    return "";
            }
        }
        return prefix;
    }
}
