package arrayhard;

public class RepeatingAndMissingNumber {
	int[] findTwoElement(int arr[], int n) {
        int res=0;
        for(int i:arr)
            res^=i;
        for(int i=1;i<=n;i++)
        {
            res^=i;
        }
        res&=-res;
        int x=0,y=0;
        for(int i:arr)
        {
            if((res&i)!=0)
            {
                x^=i;
            }
            else 
                y^=i;
        }
        for(int i=1;i<=n;i++)
        {
            if((res&i)!=0)
            {
                x^=i;
            }
            else 
                y^=i;
        }
        int count=0;
        for(int i:arr)
        {
            if(i==y)
            {
                count++;
            }
        }
        if(count>=1) return new int[]{y,x};
        
        return new int[]{x,y};
    }
}
