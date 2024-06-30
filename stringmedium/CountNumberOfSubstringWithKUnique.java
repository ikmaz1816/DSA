package stringmedium;

import java.util.Arrays;

public class CountNumberOfSubstringWithKUnique {
	long substrCount (String s, int k) {
        long ans = 0;
        int[] count=new int[26];
        int length = s.length();
        for(int i=0;i<length;i++)
        {
            Arrays.fill(count,0);
            long c=0;
            for(int j=i;j<length;j++)
            {
                char ch = s.charAt(j);
                if(count[ch-'a']==0)
                    c++;
                count[ch-'a']++;
                if(c==k)
                    ans++;
            }
        }
        return ans;
    }
}
