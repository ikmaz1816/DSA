package stringmedium;


public class CountNumberOfSubstringWithKUniqueOptimized {
	long countSubstr(String s,int k)
    {
        long ans = 0;
        long distinct =0;
        int[] count=new int[26];
        int i=0,length = s.length(),j=0;
        while(j<length)
        {
            char ch1 = s.charAt(j);
            count[ch1-'a']++;
            if(count[ch1-'a']==1)
            {
                distinct++;
            }
            while(distinct>k)
            {
                char ch2 = s.charAt(i);
                count[ch2-'a']--;
                if(count[ch2-'a']==0)
                    distinct--;
                i++;
            }
            j++;
            ans+=(j-i+1);
        }
        return ans;
    }
    long substrCount (String s, int k) {
        return countSubstr(s,k) - countSubstr(s,k-1);
    }
}
