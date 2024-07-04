package stackimplementationproblem;

import java.util.Stack;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] ans = new int[length-k+1];
        Stack<Integer> st=new Stack<>();
        int[] nge=new int[length];
        for(int i=length-1;i>=0;i--)
        {
            while(!st.isEmpty() && nums[i]>=nums[st.peek()])
                st.pop();
            if(st.isEmpty())
            {
                nge[i] = length;
                // so that we can move out of the window
            }
            else
                nge[i] = st.peek();
            st.push(i);
        }

        for(int i=0;i<length-k+1;i++)
        {
            int j=i;
            //with this it checks whether a particular index goes out of window
            // as we have pushed index rather than values in nge
            while(nge[j]<i+k)
            {
                j=nge[j];
            }
            ans[i] = nums[j];
        }
        return ans;

    }
}
