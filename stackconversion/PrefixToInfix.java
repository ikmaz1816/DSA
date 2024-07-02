package stackconversion;

import java.util.Stack;

public class PrefixToInfix {
	static String reverse(String s)
    {
        String rev = "";
        int length = s.length();
        for(int i=0;i<length;i++)
        {
            rev = s.charAt(i) + rev;
        }
        return rev;
    }
    static String preToInfix(String pre_exp) {
        String prefix = reverse(pre_exp);
        Stack<String> st = new Stack<>();
        int length = prefix.length();
        for(int i=0;i<length;i++)
        {
            char ch = prefix.charAt(i);
            if(Character.isAlphabetic(ch))
            {
                st.push(ch+"");
            }
            else
            {
                if(st.size()>=2)
                {
                    String first = st.pop();//Now as we are moving in the reverse order the first and second
                    // would be very crucial.
                    //Dry run the application to get an idea
                    String second = st.pop();
                    st.push("("+first+ch+second+")");
                }
            }
        }
        return st.peek();
    }
}
