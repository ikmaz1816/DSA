package graphbfsdfsproblems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Ladder
{
    String word;
    int count;
    public Ladder(String word,int count)
    {
        this.word=word;
        this.count=count;
    }
}
public class WordLadder1 {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Ladder> q=new LinkedList<>();
        q.add(new Ladder(beginWord,1));
        Set<String> set=new HashSet<>(wordList);
        set.remove(beginWord);
        while(!q.isEmpty())
        {
            Ladder ladder = q.poll();
            String word = ladder.word;
            int count = ladder.count;
            if(word.equals(endWord))
                return count;
            for(int i=0;i<word.length();i++)
            {
                for(char ch ='a';ch<='z';ch++)
                {
                    char[] wordArray = word.toCharArray();
                    wordArray[i]=ch;
                    String newWord = new String(wordArray);
                    if(set.contains(newWord))
                    {
                        set.remove(newWord);
                        q.add(new Ladder(newWord,count+1));
                    }
                }
            }
        }
        return 0;
    }
}
