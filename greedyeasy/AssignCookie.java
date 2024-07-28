package greedyeasy;

import java.util.Arrays;

public class AssignCookie {
	public int findContentChildren(int[] g, int[] s) {
        int i=0,j=0,count=0;
        int length = g.length,length2=s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        while(i<length && j<length2)
        {
            if(g[i]<=s[j])
            {
                count++;
                i++;
                j++;
            }
            else if(s[j]<g[i])
                j++;
            
        }
        return count;
    }
}
