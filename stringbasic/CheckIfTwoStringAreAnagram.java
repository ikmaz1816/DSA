package stringbasic;

public class CheckIfTwoStringAreAnagram {
	public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int[] count = new int[128];
        int i=0,length1=s.length(),length2=t.length();
        int j=0;
        while(i<length1 && j<length2)
        {
            count[s.charAt(i++)]++;
            count[t.charAt(j++)]--;
        }

        for(int k:count)
        {
            if(k!=0)
                return false;
        }
        return true;
    }
}
