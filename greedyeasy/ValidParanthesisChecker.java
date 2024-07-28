package greedyeasy;

public class ValidParanthesisChecker {
	public boolean checkValidString(String s) {
        int openMax=0,openMin=0;
        int length = s.length();
        for(int i=0;i<length;i++)
        {
            char ch = s.charAt(i);
            if(ch=='(')
            {
                openMax++;
                openMin++;
            }
            else if(ch==')')
            {
                openMax--;
                openMin = Math.max(0,openMin-1);
            }
            else
            {
                openMax++;
                openMin = Math.max(0,openMin-1);
            }
            if(openMax<0)
                return false;
        }
        return openMin==0;
    }
}
