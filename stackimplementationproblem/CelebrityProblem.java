package stackimplementationproblem;

import java.util.Stack;

public class CelebrityProblem {
	int celebrity(int M[][], int n)
    {
    	Stack<Integer> st=new Stack<>();
    	for(int i=0;i<n;i++)
    	{
    	    st.push(i);
    	}
    	while(st.size()>=2)
    	{
    	    int first = st.pop();
    	    int second = st.pop();
    	    
    	    if(M[first][second]==1)
    	    {
    	        st.push(second);
    	    }
    	    else
    	        st.push(first);
    	}
    	
    	int ans = st.pop();
    	for(int i=0;i<n;i++)
    	{
    	    if((M[i][ans]==0 || M[ans][i]==1) && i!=ans)
    	    {
    	        return -1;
    	    }
    	}
    	return ans;
    }
}
