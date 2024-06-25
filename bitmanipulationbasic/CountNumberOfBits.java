package bitmanipulationbasic;

public class CountNumberOfBits {
	 public static int countSetBits(int n){
		    
	        int count = 0;
	        int[] countBit = new int[32];
	        for(int i=1;i<=n;i++)
	        {
	           for(int j=0;j<32;j++)
	           {
	               if((i & (1<<j))!=0)
	                   countBit[j]++;
	           }
	        }
	        int length = countBit.length;
	        for(int i=0;i<length;i++)
	        {
	            count+=countBit[i];
	        }
	        return count;
	        /*
	         	int count = 0;
	         	while(n>0)
	         	{
	         		count++;
	         		n = n & (n-1);
	         	}
	         	return count;
	         */
	    }
}
