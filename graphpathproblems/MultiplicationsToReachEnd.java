package graphpathproblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Multiple
{
    int data;
    int step;
    public Multiple(int data,int step)
    {
        this.data=data;
        this.step=step;
    }
}
public class MultiplicationsToReachEnd {
	int minimumMultiplications(int[] arr, int start, int end) {
        if(start==end)
            return 0;
        Queue<Multiple> q=new LinkedList<>();
        q.add(new Multiple(start,0));
        int[] distance = new int[100000];
        Arrays.fill(distance,(int)(1e5+1));
        distance[start]=0;
        int mod = (int)1e5;
        while(!q.isEmpty())
        {
            int data = q.peek().data;
            int step = q.peek().step;
            q.poll();
            for(int i=0;i<arr.length;i++)
            {
                int product = (data * arr[i])%mod;
                if(product==end)
                    return step+1;
                if(step+1<distance[product])
                {
                    distance[product] = step+1;
                    q.add(new Multiple(product,step+1));
                }
            }
        }
        return -1;
    }
}
