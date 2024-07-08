package bitmanipulationhard;

public class TwoNumberAppearingOnce {
	 public int[] twoOddNum(int arr[], int n)
	    {
	        int res = 0;
	        for(int i:arr)
	        {
	            res^=i;
	        }
	        
	        res &= -res;
	        int x=0,y=0;
	        for(int i:arr)
	        {
	            if((res&i)!=0)
	                x^=i;
	            else 
	                y^=i;
	        }
	        
	        if(x>y)
	            return new int[]{x,y};
	        return new int[]{y,x};
	    }
}
