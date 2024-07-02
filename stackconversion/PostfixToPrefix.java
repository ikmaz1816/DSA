package stackconversion;

import java.util.Stack;

public class PostfixToPrefix {
	static String postToPre(String exp) {
	       Stack<String> st = new Stack<>();
	        int length = exp.length();
	        for(int i=0;i<length;i++)
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
	                    String second = st.pop();
	                    //as we are moving forward the first character must one first.
	                    String first = st.pop();
	                    st.push(ch+first+second);
	                }
	            }
	        }
	        return st.peek();
	    }
}
