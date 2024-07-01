package stackqueueimplementation;

import java.util.Stack;

public class ValidParanthesisChecker {
	public boolean isValid(String s) {
        if(s.length()==0)
            return true;
        Stack<Character> st = new Stack<>();
        int length = s.length();
        for(int i=0;i<length;i++)
        {
            char ch = s.charAt(i);
            if(ch=='[' || ch=='{' || ch=='(')
            {
                st.push(ch);
            }
            else
            {
                if(st.isEmpty())
                {
                    return false;
                }
                char stackPeek = st.peek() ;
                if((ch==']' && stackPeek=='[') || (ch=='}' && stackPeek=='{') || (ch==')' && stackPeek=='('))
                    st.pop();
                else
                    return false;
            }
        }
        return st.isEmpty();
    }
}
