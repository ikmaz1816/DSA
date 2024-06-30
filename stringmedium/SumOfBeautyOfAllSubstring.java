package stringmedium;

import java.util.Arrays;

public class SumOfBeautyOfAllSubstring {
	public int beautySum(String s) {
        int length = s.length();
        if(length==0)
            return 0;
        int ans = 0;
        int[] count=new int[26];
        for(int i=0;i<length;i++)
        {
            Arrays.fill(count,0);
            for(int j=i;j<length;j++)
            {
                char ch = s.charAt(j);
                count[ch-'a']++;
                // we are doing this calculation here because a is also considered as a substring
                // aab -> min =1 max =2 
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for(int k:count)
                {
                    if(k!=0)
                    {
                        max=Math.max(max,k);
                        min=Math.min(min,k);
                    }
                }
                 ans+=(max-min);
            }
           
        }
        return ans;
    }
}
