package stackproblems;

import java.util.Stack;

public class RemoveKDigit {
	public String removeKdigits(String num, int k) {
        int length = num.length();
        if(k>=length)
            return "0";
        StringBuilder sb=new StringBuilder();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<length;i++)
        {
            char ch = num.charAt(i);
            while(k>0 && !st.isEmpty() && ch<st.peek())
            {
                st.pop();
                k--;
            }
            st.push(ch);
        }
        //Here if k>0 this means that there are some larger number at the end of the string
        //that has to be removed to make the number
        while(k>0)
        {
            st.pop();
            k--;
        }
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        sb.reverse();
        
        while(sb.length()!=1 && sb.charAt(0)=='0')
        {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
