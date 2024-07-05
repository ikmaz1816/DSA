package stackproblems;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int length = heights.length;
        int[] nsr=new int[length];
        int[] nsl=new int[length];

        for(int i=length-1;i>=0;i--)
        {
            while(!st.isEmpty() && heights[i]<=heights[st.peek()])
            {
                st.pop();
            }
            nsr[i] = st.isEmpty() ? length : st.peek();
            st.push(i);
        }
        st=new Stack<>();
        for(int i=0;i<length;i++)
        {
            while(!st.isEmpty() && heights[i]<=heights[st.peek()])
            {
                st.pop();
            }
            nsl[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        int maxarea=0;
        for(int i=0;i<length;i++)
        {
            maxarea=Math.max(maxarea,heights[i]*(nsr[i]-nsl[i]-1));
        }
        return maxarea;
    }
}
