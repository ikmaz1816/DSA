package stackproblems;

import java.util.Stack;

public class MaxRectangles {
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
    public int maximalRectangle(char[][] matrix) {
        int rlength=matrix.length,clength=matrix[0].length;
        int[] temp=new int[clength];
        for(int i=0;i<clength;i++)
        {
            temp[i] = matrix[0][i] - '0'; 
        }
        int maxArea = largestRectangleArea(temp);
        for(int i=1;i<rlength;i++)
        {
            for(int j=0;j<clength;j++)
            {
                if(matrix[i][j]=='1')
                    temp[j]++;
                else
                    temp[j]=0;
            }
            maxArea = Math.max(maxArea,largestRectangleArea(temp));
        }
        return maxArea;
    }
}
