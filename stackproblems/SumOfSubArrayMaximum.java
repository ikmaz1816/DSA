package stackproblems;

import java.util.Stack;

public class SumOfSubArrayMaximum {
	class Pair
	{
	    int data;
	    int count;
	    public Pair(int data,int count)
	    {
	        this.data=data;
	        this.count=count;
	    }
	}
	public int sumSubarrayMax(int[] arr) {
        int length = arr.length;
        long[] nsl=new long[length];
        long[] nsr=new long[length];
        Stack<Pair> st=new Stack<>();
        /*
            In this question it is very important to understand the longing of one element on the left and right
            We will find by how much it extends it on right and left and multiply left * right * arr[i]
            To look at the edge case it is important to understand that there can be duplicates and extension of left
            or right must be considered.
        */
        for(int i=0;i<length;i++)
        {
            int count =1;
            //Here we are not considering the duplicate extension and hence both duplicate will be inserted as (x,1) (x,1)
            while(!st.isEmpty() && arr[i]>st.peek().data)
            {
                count+=st.peek().count;
                st.pop();
            }
            nsl[i] = count;
            st.push(new Pair(arr[i],count));
        }
        st=new Stack<>();
        for(int i=length-1;i>=0;i--)
        {
            int count =1;
            //Here we are considering the duplicate extension and hence both duplicate will be inserted as (x,2)
            while(!st.isEmpty() && arr[i]>=st.peek().data)
            {
                count+=st.peek().count;
                st.pop();
            }
            nsr[i] = count;
            st.push(new Pair(arr[i],count));
        }
        int mod = (int)1e9 + 7;
        long sum = 0;
        for(int i=0;i<length;i++)
        {
            sum+= (long)(arr[i]*nsr[i]*nsl[i])%mod;
            sum%=mod;
        }
        return (int)sum;
    }
}
