package twopointerslidingwindowhard;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
        int length = s.length();
        int length2 = t.length();
        if(length2 > length) 
            return "";
        int[] count=new int[128];
        for(int i=0;i<length2;i++)
            count[t.charAt(i)]++;
        int i=0,j=0,minlen=Integer.MAX_VALUE,start=-1,counter=0;
        while(j<length)
        {
            char ch = s.charAt(j);
            if(count[ch]>0)
                counter++;
            count[ch]--;
            while(counter==length2)
            {
                if(j-i+1<minlen)
                {
                    minlen = j-i+1;
                    start=i;
                }
                ch=s.charAt(i);
                count[ch]++;
                if(count[ch]>0)
                    counter--;
                i++;
            }
            j++;
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start,start+minlen);
    }
}
