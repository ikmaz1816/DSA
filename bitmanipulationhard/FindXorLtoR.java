package bitmanipulationhard;

public class FindXorLtoR {
	static int findX(int x)
    {
        switch(x%4)
        {
            case 0:
              return x;
            case 1:
                return 1;
            case 2:
                return x+1;
            default:
                return 0; 
        }
    }
    public static int findXOR(int l, int r) {
        /* brute force solution
        int res =0;
        for(int i=l;i<=r;i++)
        {
            res^=i;
        }
        return res;
        */
        /*
         4^5^6^7^8
         l=4 means 1^2^3
         r=8 means  1^2^3^4^5^6^7^8
         now if we see 1^2^3 =0
         so x%4==0 
         return x
         
         x%4==1
         	return 1;
         4^5(as remainder for 5 is 1 which divided by 4) = 1
         
         x%4==2
         	6%4==2 return x+1;
         	
         	4^7 = 3
         for seven we will have zero 
         so now 
         0^8 = 8     
         */
        return findX(l-1)^findX(r);
    }
}
