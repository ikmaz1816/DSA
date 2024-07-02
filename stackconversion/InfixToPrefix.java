package stackconversion;

import java.util.Stack;

public class InfixToPrefix {
	public static String infixToPretfix(String s) {
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
	
	public static void main(String[] args) {
		String infix = "(A-B/C)*(A/K-L)";
		String reverse=reverse(infix);
		System.out.println(reverse);
		System.out.println(reverse(infixToPretfix(reverse)));
	}

	private static String reverse(String infix) {
		String rev="";
		int length = infix.length();
		for(int i=0;i<length;i++)
		{
			char ch = infix.charAt(i);
			if(ch==' ')
				continue;
			else if(ch==')')
				rev='('+rev;
			else if(ch=='(')
				rev=')'+rev;
			else
				rev=ch+rev;
		}
		return rev;
	}
}
