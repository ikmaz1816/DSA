package toposort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule2 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0)
        {
            int[] ans=new int[numCourses];
            for(int i=0;i<numCourses;i++)
            {
                ans[i]=i;
            }
            return ans;
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());
        int[] indegree=new int[numCourses];
        int rowLength = prerequisites.length;
        for(int i=0;i<rowLength;i++)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
                q.add(i);
        }
        int count=0;
        int[] ans=new int[numCourses];
        while(!q.isEmpty())
        {
            int i = q.poll();
            ans[count++]=i;
            for(int j:adj.get(i))
            {
                indegree[j]--;
                if(indegree[j]==0)
                    q.add(j);
            }
        }
        if(count==numCourses)
            return ans;
        return new int[]{};
    }
}
