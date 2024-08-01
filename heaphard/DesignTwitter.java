package heaphard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class User
{
    int userId;
    Set<Integer> followers;
    public User(int userId)
    {
        this.userId=userId;
        followers=new HashSet<>();
        addFollower(userId);
    }
    public void addFollower(int userId)
    {
        followers.add(userId);
    }
    public void removeFollower(int userId)
    {
        followers.remove(userId);
    }
    public Set<Integer> getFollowers()
    {
        return this.followers;
    }
}
class Tweet
{
    int userId;
    int tweetId;
    int occurence;
    public Tweet(int userId,int tweetId,int occurence)
    {
        this.userId=userId;
        this.tweetId=tweetId;
        this.occurence=occurence;
    }
}
public class DesignTwitter {
    Map<Integer,User> userDetails;
    List<Tweet> tweets;
    int count;
    public DesignTwitter() {
        userDetails = new HashMap<>();
        count=0;
        tweets = new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.add(new Tweet(userId,tweetId,count++));
        Collections.sort(tweets,(a,b)->b.occurence-a.occurence);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        int localCount = 0;
        // As there is a need to only give ten most recent tweets
        List<Integer> ans = new ArrayList<>();
        User user = getUser(userId);
        Set<Integer> followers = user.getFollowers();
        for(Tweet tweet:tweets)
        {
            if(followers.contains(tweet.userId))
            {
                ans.add(tweet.tweetId);
                localCount++;
            }
            if(localCount==10)
                break;
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        User followee = getUser(followeeId);
        follower.addFollower(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        User followee = getUser(followeeId);
        follower.removeFollower(followeeId);
    }

    public User getUser(int userId)
    {
        User user=null;
        if(userDetails.containsKey(userId))
        {
            user = userDetails.get(userId);
        }
        else
        {
            user = new User(userId);
            userDetails.put(userId,user);
        }
        return user;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
