package twopointerslidingwindowmedium;

public class LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
        int left=0;
        int max=0,length=s.length();
        int[] count = new int[26];
        int ans = 0,right=0;
        while(right<length)
        {
            int index = s.charAt(right)-'A';
            count[index]++;
            max=Math.max(max,count[index]);
            while(right-left+1-max>k)
            {
                index = s.charAt(left)-'A';
                count[index]--;
                left++;
            }
            ans=Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}
