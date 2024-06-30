package stringmedium;

public class ImplementAtoi {
	 public int myAtoi(String s) {
	        s=s.trim();
	        int length = s.length();
	        if(length == 0)
	            return 0;
	        long ans = 0;
	        char firstchar = s.charAt(0);
	        int sign = firstchar == '-' ? -1 : 1;
	        int i = firstchar == '+' || firstchar == '-' ? 1 : 0;
	        for(;i<length;i++)
	        {
	            char ch = s.charAt(i);
	            
	            if(!Character.isDigit(ch))
	                break;
	            ans = ans * 10 +  (ch-'0');
	            if(ans>Integer.MAX_VALUE)
	            {
	                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	            }
	        }

	        return (int)ans * sign;
	    }
}
