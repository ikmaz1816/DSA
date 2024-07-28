package greedydifficult;

import java.util.Arrays;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
public class JobSequencingProblem {
	int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr,(Job a,Job b)->b.profit-a.profit);
        int[] deadline = new int[n+1];
        Arrays.fill(deadline,-1);
        int countOfJobs=0,profit=0;
        for(Job job:arr)
        {
            int id = job.id;
            int jobdeadline = job.deadline;
            int jobprofit = job.profit;
            while(jobdeadline>0)
            {
                if(deadline[jobdeadline]==-1)
                {
                    deadline[jobdeadline] = id;
                    countOfJobs++;
                    profit+=jobprofit;
                    break;
                }
                jobdeadline--;
            }
        }
        return new int[]{countOfJobs,profit};
    }
}
