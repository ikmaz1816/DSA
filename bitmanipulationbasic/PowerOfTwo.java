package bitmanipulationbasic;

public class PowerOfTwo {
	 public boolean isPowerOfTwo(int n) {
	        /*int count=0;
	        if(n<=0)
	            return false;
	        while(n>0)
	        {
	            count++;
	            if(count==2)
	                return false;
	            n = n & (n-1);
	        }
	        return true;*/
	        if(n<=0)
	            return false;
	        return (n & (n-1)) == 0;
	    }
}
