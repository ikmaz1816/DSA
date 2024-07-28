package greedydifficult;

import java.util.LinkedList;
import java.util.Queue;

public class PageFaultsLRU {
	static int pageFaults(int N, int C, int pages[]){
        Queue<Integer> q=new LinkedList<>();
        int count=0;
        for(int i=0;i<N;i++)
        {
            if(q.contains(pages[i]))
            {
                q.remove(pages[i]);
                q.add(pages[i]);
            }
            else if(q.size()<C)
            {
                q.add(pages[i]);
                count++;
            }
            else
            {
                count++;
                q.poll();
                q.add(pages[i]);
            }
        }
        return count;
    }
}
