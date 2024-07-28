package greedydifficult;

import java.util.Comparator;
import java.util.PriorityQueue;

class Meeting
{
    int start;
    int end;
    public Meeting(int start,int end)
    {
        this.start=start;
        this.end=end;
    }
}
public class NMeetingsInOneRoom {
	public static int maxMeetings(int start[], int end[], int n)
    {
        PriorityQueue<Meeting> pq=new PriorityQueue<>(new Comparator<>()
        {
            public int compare(Meeting x,Meeting y)
            {
                return x.end-y.end;
            }
        });
        
        for(int i=0;i<n;i++)
        {
            pq.add(new Meeting(start[i],end[i]));
        }
        int prevStart=0,prevEnd=0,count=0;
        while(!pq.isEmpty())
        {
            Meeting p=pq.poll();
            if(prevStart==0)
            {
                count++;
                prevStart=p.start;
                prevEnd=p.end;
            }
            else
            {
                if(prevEnd<p.start)
                {
                    count++;
                    prevStart=p.start;
                    prevEnd=p.end;
                }
            }
        }
        return count;
    }
}
