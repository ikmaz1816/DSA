package stackconversion;

import java.util.Stack;

public class InfixToPostfix {
	public static String infixToPostfix(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int length = s.length();
        String minusPlus = "-+";
        String multiplicationDivision="*/";
        String validForMinusPlus="-+*/^(";
        String validForDivMul="*/^(";//sometimes in the peek element we will only have opening paranthesis hence it is 
        //necessary to add the coming operator after the open paranthesis
        String checkForEasyInsertMulDiv ="-+(";
        for(int i=0;i<length;i++)
        {
            char ch = s.charAt(i);
            if(Character.isAlphabetic(ch) || Character.isDigit(ch))
            {
                sb.append(ch);
            }
            else if(st.isEmpty() || ch=='(')
            {
                st.push(ch);
            }
            else
            {
                String chString = ch+"";
                char peek = st.peek();
                String peekString = peek+"";
                if(ch==')')
                {
                    while(!st.isEmpty() && st.peek()!='(')
                    {
                        sb.append(st.pop());
                    }
                    st.pop();
                }
                else if((ch=='^' && peek=='^') || ch=='^')
                {
                    while(peek=='^')
                    {
                        sb.append(st.pop());
                        if(st.isEmpty())
                            break;
                        peek = st.peek();
                    }
                    st.push(ch);
                }
                else if(multiplicationDivision.contains(chString) && checkForEasyInsertMulDiv.contains(peekString))
                {
                    st.push(ch);
                }
                else if(multiplicationDivision.contains(chString) && validForDivMul.contains(peekString))
                {
                    while(validForDivMul.contains(peekString) && st.peek()!='(')
                    {
                        sb.append(st.pop());
                        if(st.isEmpty())
                            break;
                        peekString = st.peek()+"";
                    }
                    st.push(ch);
                }
                else if(minusPlus.contains(chString) && validForMinusPlus.contains(peekString))
                {
                    while(validForMinusPlus.contains(peekString) && st.peek()!='(')
                    {
                        sb.append(st.pop());
                        if(st.isEmpty())
                            break;
                        peekString = st.peek()+"";
                    }
                    st.push(ch);
                }
            }
        }
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        return sb.toString();
    }
}
