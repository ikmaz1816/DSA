package stringmedium;

public class LongestPalindromicSubString {
	public String longestPalindrome(String s) {
        int length = s.length();
        if(length ==0 || length==1)
            return s;
        int i=0;
        int max = Integer.MIN_VALUE;
        String ans ="";
        while(i<length)
        {
            int j=i;
            while(j<length)
            {
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(j);
                if(ch1==ch2)
                {
                    String possibleLongest = s.substring(i,j+1);
                    String reverse = reverseString(possibleLongest);
                    if(possibleLongest.equals(reverse) && max<reverse.length())
                    {
                        max=reverse.length();
                        ans=possibleLongest;
                    }
                }
                j++;
            }
            i++;
        }
        return ans;
    }
    public String reverseString(String s)
    {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for(int i=length-1;i>=0;i--)
        {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
