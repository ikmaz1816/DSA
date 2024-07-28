package twopointerslidingwindowhard;

public class MinimumWindowSubsequence {
	static String minWindow(String str1, String str2) {
        int right = 0;
        int length = str1.length(),length2 = str2.length();
        int minstart=0,minlen=Integer.MAX_VALUE;
        while(right < length)
        {
            int i=0;
            while(right < length)
            {
                if(str1.charAt(right)==str2.charAt(i))
                    i++;
                if(i==length2)
                    break;
                right++;
            }
            if(right>=str1.length())
                break;
            int left = right;
            int strBack = length2-1;
            while(left>=0)
            {
                if(str1.charAt(left)==str2.charAt(strBack))
                {
                    strBack--;
                }
                if(strBack==-1)
                    break;
                left--;
            }
            if(minlen>right-left+1)
            {
                minlen=right-left+1;
                minstart=left;
            }
            right=left+1;
        }
        return minlen==Integer.MAX_VALUE ? "" : str1.substring(minstart,minstart+minlen);
    }
}
