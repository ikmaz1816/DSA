package stringbasic;

public class RemoveOutermostParanthesis {
	public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int countOpen = 0;
        int prevCountClosed=0;
        int countClosed = 0;
        for(int i=0;i<length;i++)
        {
            char ch = s.charAt(i);
            if(ch=='(')
                countOpen++;
            else if(ch==')')
                countClosed++;
            if(countOpen == countClosed)
            {
                sb.append(s.substring(prevCountClosed+1,i));
                prevCountClosed = i+1;
            }
        }
        return sb.toString();
    }
}
