package toposort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule1 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());
        int[] indegree=new int[numCourses];
        int rowLength = prerequisites.length;
        for(int i=0;i<rowLength;i++)
        {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
                q.add(i);
        }
        int count=0;
        while(!q.isEmpty())
        {
            int i = q.poll();
            count++;
            for(int j:adj.get(i))
            {
                indegree[j]--;
                if(indegree[j]==0)
                    q.add(j);
            }
        }
        if(count==numCourses)
            return true;
        return false;
    }
}
