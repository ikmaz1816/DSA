package twopointerslidingwindowhard;

import java.util.HashMap;

public class LongestKUniqueCharactersSubstring {
	public int longestUniqueCount(String s, int k)
    {
        int window = k;
        int length = s.length(),i=0,j=0,max=-1;
        HashMap<Character,Integer> map=new HashMap<>();
        while(j<length)
        {
            char ch = s.charAt(j);
            if(!map.containsKey(ch))
                k--;
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(k<0)
            {
                char ch1 = s.charAt(i);
                int count = map.get(ch1);
                if(count!=1)
                    map.put(ch1,count-1);
                else
                {
                    map.remove(ch1);
                    k++;
                }       
                i++;
            }
            
            if(map.keySet().size()==window)
                max=Math.max(max,j-i+1);
            
            j++;
            
        }
        return max;
    }
    public int longestkSubstr(String s, int k) {
        return longestUniqueCount(s,k);
    }
}
