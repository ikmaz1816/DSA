package stringmedium;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	public int romanToInt(String s) {
        int length = s.length();
        if(length == 0)
            return 0;
        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int sum = map.get(s.charAt(length-1));
        for(int i = length -2 ;i>=0;i--)
        {
            char currentNumber = s.charAt(i);
            char previousNumber = s.charAt(i+1);
            if(map.get(previousNumber)<=map.get(currentNumber))
            {
                sum+=map.get(currentNumber);
            }
            else
            {
                sum-=map.get(currentNumber);
            }
        }
        return sum;
    }
}
