package recursionhardproblem;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartioning {
	public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        partition(s,0,new ArrayList<>(),ans);
        return ans;
    }

    public void partition(String s,int index,List<String> partAnswer,List<List<String>> ans)
    {
        if(index>=s.length())
        {
            ans.add(new ArrayList<>(partAnswer));
            return;
        }
        for(int i=index;i<s.length();i++)
        {
            if(isPalindrome(s,index,i))
            {
                partAnswer.add(s.substring(index,i+1));
                partition(s,i+1,partAnswer,ans);
                partAnswer.remove(partAnswer.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s,int start,int end)
    {
        while(start<=end)
        {
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
