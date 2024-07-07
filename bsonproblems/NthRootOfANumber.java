package bsonproblems;

public class NthRootOfANumber {
	public int NthRoot(int n, int m)
    {
        if(n==0) return 1;
        if(m==0 || m==1) return m;
        int start = 1;
        int end = m/2;
        while(start<=end)
        {
            int mid = (start+end)/2;
            int ans = (int)Math.pow(mid,n);
            if(ans==m)
            {
                return mid;
            }
            else if(ans<m)
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }
}
