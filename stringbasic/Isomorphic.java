package stringbasic;

import java.util.HashMap;

public class Isomorphic {
	public boolean isIsomorphic(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        if(length1!=length2)
            return false;
        HashMap<Character,Character> mapFirst=new HashMap<>();
        HashMap<Character,Character> mapSecond = new HashMap<>();
        int i=0;
        while(i<length1)
        {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(!mapFirst.containsKey(ch1))
            {
                if(mapSecond.containsKey(ch2))
                    return false;
                mapFirst.put(ch1,ch2);
                mapSecond.put(ch2,ch1);
            }
            else
            {
                if(mapFirst.get(ch1)!=ch2)
                {
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}
