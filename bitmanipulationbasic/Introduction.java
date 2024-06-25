package bitmanipulationbasic;

public class Introduction {
	 static void bitManipulation(int num, int i) {
	        //get the ith bit
		 	//as the value of i was not zero based indexing
	        i = (1<<(i-1));
	        System.out.print(((num&i)>0?1:0)+" ");
	        
	        //set the ith bit
	        System.out.print((num|i)+" ");
	        
	        //clear the ith bit
	        i = ~i;
	        System.out.print((num&i));
	    }
}
