package twopointerslidingwindowmedium;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        int i=0,j=0,length = s.length();
        if(length==0)
            return 0;
        int[] distinctCount = new int[128];
        int maxLength = 0;
        while(j<length)
        {
            char ch = s.charAt(j);
            distinctCount[ch]++;
            while(distinctCount[ch]!=1)
            {
                char ch1 = s.charAt(i);
                distinctCount[ch1]--;
                i++;
            }
            maxLength = Math.max(maxLength,j-i+1);
            j++;
        }
        return maxLength;
    }
}
