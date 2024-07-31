package heapsmedium;

import java.util.Arrays;

public class TaskSchedular {
	public int leastInterval(char[] tasks, int n) {
        //Remember this approach can also be solved using priorityqueue and hashmap
        int[] count=new int[26];
        int length = tasks.length;
        for(int i=0;i<length;i++)
        {
            count[tasks[i]-'A']++;
        }
        Arrays.sort(count);
        int maxValue=count[25];
        //Now if we want to find slots we know that we first place the maximum character
        // A _ _ A _ _ A 
        // The  last A has no significance hence we need to understand the ideal slots for the first two As
        int maxValueActual = maxValue-1;
        int idealSlots = maxValueActual * n;
        // As between two As there would be cooldown period of n
        //Now we will iterate on the remaining character and try to place them in the ideal slots
        for(int i=24;i>=0;i--)
        {
            idealSlots -= Math.min(count[i],maxValueActual);
        }
        // if idealSlots is 0 this means all ideal slots were allocated to some task else this means 
        //that there is an ideal time between tasks
        return idealSlots>0 ? length+idealSlots : length;
    }
}
