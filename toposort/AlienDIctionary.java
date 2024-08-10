package toposort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDIctionary {
	public String findOrder(String [] dict, int N, int K)
    {
        StringBuilder sb=new StringBuilder();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<K;i++)
            adj.add(new ArrayList<>());
        int[] indegree=new int[K];
        for(int i=1;i<N;i++)
        {
            String s2=dict[i];
            String s1=dict[i-1];
            int j=0;
            int length = Math.min(s1.length(),s2.length());
            while(j<length)
            {
                if(s1.charAt(j)!=s2.charAt(j))
                {
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    indegree[s2.charAt(j)-'a']++;
                    break;
                }
                j++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<K;i++)
        {
            if(indegree[i]==0)
                q.add(i);
        }
        int count=0;
        while(!q.isEmpty())
        {
            int j=q.poll();
            sb.append((char)('a'+j));
            count++;
            for(int i:adj.get(j))
            {
                indegree[i]--;
                if(indegree[i]==0)
                    q.add(i);
            }
        }
        if(count==K)
            return sb.toString();
        return "";
        
    }
}
