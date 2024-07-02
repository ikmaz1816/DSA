package stackconversion;

import java.util.Stack;

public class PrefixToPostFix {
	static String preToPost(String exp) {
        Stack<String> st = new Stack<>();
        int length = exp.length();
        for(int i=length-1;i>=0;i--)
        {
            char ch = exp.charAt(i);
            if(Character.isAlphabetic(ch))
            {
                st.push(ch+"");
            }
            else
            {
                if(st.size()>=2)
                {
                    String first = st.pop();
                    //as we are moving forward the first character must one first.
                    String second = st.pop();
                    st.push(first+second+ch);
                }
            }
        }
        return st.peek();
    }
}
