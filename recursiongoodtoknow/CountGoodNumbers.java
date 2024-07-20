package recursiongoodtoknow;

public class CountGoodNumbers {
	private final int mod = (int)1e9+7;
    public long pow(long x,long y)
    {
        if(y==0)
            return 1;
        long res = 1;
        while(y>0)
        {
            if((y&1)!=0)
            {
                res=(res*x)%mod;
            }
            x = (x*x)%mod;
            y>>=1;
        }
        return res;
    }
    public int countGoodNumbers(long n) {
        long evenplaces = (n+1)>>1;
        long oddplaces = n>>1;
        return (int)((pow(5,evenplaces)*pow(4,oddplaces))%mod);
    }
}
