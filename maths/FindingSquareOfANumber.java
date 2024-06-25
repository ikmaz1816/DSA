package maths;

public class FindingSquareOfANumber {
	public double myPow(double x, int n) {
        double res = 1.0;
        long power = n;
        int sign =0;
        if(n<0)
        {
            power*=-1;
            sign =-1;
        }
        while(power>0)
        {
            if((power&1)!=0)
            {
                res*=x;
            }
            x*=x;
            power>>=1;
        }

        if(sign == -1)
            res = 1.0/res;
        return res;
    }
}
