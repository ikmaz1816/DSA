package stackproblems;

import java.util.Stack;

public class DuplicateBrackets {
	public static int checkRedundancy(String s) {
        int length = s.length();
        if(length==0)
            return 0;
       // (a+b+((c)+d))
        Stack<Character> st=new Stack<>();
        
        for(int i=0;i<length;i++)
        {
            char ch = s.charAt(i);
            if(ch==')')
            {
                if(!st.isEmpty() && st.peek()=='(')
                    return 1;
                while(!st.isEmpty() && st.peek()!='(')
                {
                    //here we can store for printing
                    st.pop();
                }
                st.pop();
            }
            else
            {
                if(!Character.isAlphabetic(ch))
                    st.push(ch);
            }
        }
        return 0;
    }
}
