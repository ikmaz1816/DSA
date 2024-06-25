package bitmanipulationbasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SwapTwoNumbers {
	static List<Integer> get(int a,int b)
    {
        a = a^b;
        b=a^b;
        a=a^b;
        return new ArrayList<>(Arrays.asList(a,b));
    }
}
