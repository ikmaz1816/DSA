package graphbfsdfsproblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> set=new HashSet<>(wordList);
        List<String> ls = new ArrayList<>();
        ls.add(beginWord);
        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        Queue<List<String>> q=new LinkedList<>();
        q.add(ls);
        int level=0;
        while(!q.isEmpty())
        {
            List<String> onLevel = q.poll();
            String word = onLevel.get(onLevel.size()-1);
            if(word.equals(endWord))
            {
                if(ans.size()==0 || ans.get(0).size()==onLevel.size())
                {
                    ans.add(new ArrayList<>(onLevel));
                }
            }
            if(onLevel.size()>level)
            {
                level++;
                for(String s:onLevel)
                {
                    set.remove(s);
                }
            }
            for(int i=0;i<word.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char[] wordArray = word.toCharArray();
                    wordArray[i] = ch;
                    String newWord = new String(wordArray);
                    if(set.contains(newWord))
                    {
                        usedOnLevel.add(newWord);
                        onLevel.add(newWord);
                        List<String> temp=new ArrayList<>(onLevel);
                        q.add(temp);
                        onLevel.remove(onLevel.size()-1);
                    }
                }
            }
        }
        return ans;
    }
}
