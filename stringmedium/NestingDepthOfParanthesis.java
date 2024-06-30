package stringmedium;

public class NestingDepthOfParanthesis {
	public int maxDepth(String s) {
        int countOpen = 0;
        int max = 0;
        int length = s.length();
        for(int i=0;i<length;i++)
        {
            char ch = s.charAt(i);
            if(ch == '(')
            {
                countOpen++;
                max = Math.max(max,countOpen);
            }
            else if(ch==')')
            {
                countOpen--;
            }
        }
        return max;
    }
}
