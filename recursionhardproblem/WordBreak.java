package recursionhardproblem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
        return word(s,0,0,new HashSet<>(wordDict));
    }

    public boolean word(String s,int start,int end,Set<String> wordDict)
    {
        // we are checking till length-1 as below we are checking till end+1 hence
        if(end==s.length()-1)
        {
            if(wordDict.contains(s.substring(start,end+1)))
                return true;
            return false;
        }

        String string = s.substring(start,end+1);
        if(wordDict.contains(string))
        {
           if(word(s,end+1,end+1,wordDict))
                return true;
        }

        return word(s,start,end+1,wordDict);
    }
}
