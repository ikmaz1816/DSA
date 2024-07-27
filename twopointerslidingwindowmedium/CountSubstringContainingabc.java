package twopointerslidingwindowmedium;

import java.util.HashMap;

public class CountSubstringContainingabc {
	public int countSubstring(String s,int k)
    {
        int i=0,j=0,length=s.length();
        int ans=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while(j<length)
        {
            char ch=s.charAt(j);
            if(!map.containsKey(ch))
            {
                k--;
            }
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(k<0)
            {
                ch = s.charAt(i);
                int count = map.get(ch);
                if(count==1)
                {
                    map.remove(ch);
                    k++;
                }
                else
                    map.put(ch,count-1);
                i++;
            }
            j++;
            ans+=(j-i+1);
        }
        return ans;
    }
    public int numberOfSubstrings(String s) {
        return countSubstring(s,3) - countSubstring(s,2);
    }
}
