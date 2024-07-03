package stackproblems;

import java.util.Stack;

public class BracketReversal {
	int countRev (String s)
    {
        int length = s.length();
        if(length%2!=0)
            return -1;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<length;i++)
        {
            char ch = s.charAt(i);
            if(ch=='}')
            {
                if(st.isEmpty() || st.peek()=='}')
                    st.push(ch);
                else
                {
                    if(st.peek()=='{')
                        st.pop();
                }
            }
            else 
            {
                st.push(ch);
            }
        }
        int open =0, close =0,count=0;
        // System.out.println(st);
        while(!st.isEmpty())
        {
            if(st.peek()=='{')
                open++;
            else 
                close++;
            st.pop();
        }
        // System.out.println(open+""+close);
        if((open+close)%2==0){
            count += open%2==0 ? open/2 : open/2 + 1;
            count+= close%2==0 ? close/2 : close/2 + 1;
            
            return count;
        }
        return -1;
    }
}
