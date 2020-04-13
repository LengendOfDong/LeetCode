package leetcode.设计推特_355;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dadongge
 * @date 2020/4/13
 */
public class TwitterTest {
    //用户推特列表
    Map<Integer, List<Integer>> userTweetMap;
    //用户关注列表
    Map<Integer, List<Integer>> userAsFollowerMap;
    //关注用户列表
    Map<Integer, List<Integer>> userAsFolloweeMap;
    //用户最近推特列表，包括自己和好友的推特
    Map<Integer, List<Integer>> userLatestTweetMap;
    //用户发布的推特列表
    List<Integer> userTweets;

    /**
     * Initialize your data structure here.
     */
    public TwitterTest() {
        userTweetMap = new ConcurrentHashMap<>();
        userAsFollowerMap = new ConcurrentHashMap<>();
        userAsFolloweeMap = new ConcurrentHashMap<>();
        userLatestTweetMap = new LinkedHashMap<>();
        userTweets = new LinkedList<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        //更新用户推特列表
        updateUserTweetList(userId, tweetId);
        //用户发布的推特列表更新
        userTweets.add(tweetId);
        //更新用户最新的十条推特
        updateLatestTweetList(userId);


        //需要更新关注自己的用户最近十条推特列表,先获取哪些用户关注了自己
        List<Integer> userFolloweeList = userAsFolloweeMap.get(userId);
        if (userFolloweeList == null) {
            return;
        }
        for (Integer userFolloweeId : userFolloweeList) {
            updateLatestTweetList(userFolloweeId);
        }
    }

    private void updateLatestTweetList(int userId) {
        //找到用户关注的人
        List<Integer> asFollowerList = userAsFollowerMap.get(userId);
        //为空则取该用户前十条推特
        if(asFollowerList == null || asFollowerList.size() == 0){
            List<Integer> userTweetList = userTweetMap.get(userId);
            List<Integer> latestTweetList = new LinkedList<>();
            //用户没发过推特就返回空列表
            if(userTweetList == null){
                userLatestTweetMap.put(userId, latestTweetList);
                return;
            }
            for(int i = userTweetList.size() - 1; i >= 0; i--){
                latestTweetList.add(userTweetList.get(i));
                if(latestTweetList.size() == 10){
                    break;
                }
            }
            userLatestTweetMap.put(userId, latestTweetList);
        }else {
            //遍历用户自己和关注者的推特，取前十条推特
            List<Integer> asFollowerCopy = new LinkedList<>(asFollowerList);
            asFollowerCopy.add(userId);
            List<Integer> latestTweetList = new LinkedList<>();
            for (int i = userTweets.size() - 1; i >= 0; i--) {
                int finalI = i;
                if(asFollowerCopy.stream().anyMatch(e -> userTweetMap.getOrDefault(e, new LinkedList<>()).contains(userTweets.get(finalI)))){
                    latestTweetList.add(userTweets.get(finalI));
                    if(latestTweetList.size() == 10){
                        break;
                    }
                }
            }
            userLatestTweetMap.put(userId, latestTweetList);
        }
    }

    private void updateUserTweetList(int userId, int tweetId) {
        //更新用户推特列表
        List<Integer> tweetsList = userTweetMap.get(userId);
        if (tweetsList == null) {
            List<Integer> userList = new LinkedList<>();
            userList.add(tweetId);
            userTweetMap.put(userId, userList);
        } else {
            tweetsList.add(tweetId);
            userTweetMap.put(userId, tweetsList);
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> latestTweetList = userLatestTweetMap.get(userId);
        if (latestTweetList == null) {
            return new LinkedList<>();
        }
        return latestTweetList;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        //用户关注别人，自己的关注列表增加被关注者
        List<Integer> asFollowerList = userAsFollowerMap.get(followerId);
        if (asFollowerList == null) {
            asFollowerList = new LinkedList<>();
        }
        asFollowerList.add(followeeId);
        userAsFollowerMap.put(followerId, asFollowerList);
        //用户被别人关注，自己的关注列表增加关注者，同时增加
        List<Integer> asFolloweeList = userAsFolloweeMap.get(followeeId);
        if (asFolloweeList == null) {
            asFolloweeList = new LinkedList<>();
        }
        asFolloweeList.add(followerId);
        userAsFolloweeMap.put(followeeId, asFolloweeList);
        //增加关注之后，最近十条推特也需要更新
        updateLatestTweetList(followerId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        //用户取消关注别人，自己的关注列表去除被关注者
        List<Integer> asFollowerList = userAsFollowerMap.get(followerId);
        if (asFollowerList == null) {
            return;
        }
        asFollowerList.remove(new Integer(followeeId));
        userAsFollowerMap.put(followerId, asFollowerList);
        //用户被取消关注，自己的被关注列表中移除关注者,同时减少
        List<Integer> asFolloweeList = userAsFolloweeMap.get(followeeId);
        asFolloweeList.remove(new Integer(followerId));
        userAsFolloweeMap.put(followeeId, asFolloweeList);
        //取消关注，还需要移除对方的推特记录
        updateLatestTweetList(followerId);
    }

    public static void main(String[] args) {
        TwitterTest twitter = new TwitterTest();
        twitter.postTweet(1, 1);
        List<Integer> newsFeed1 = twitter.getNewsFeed(1);
        System.out.println(newsFeed1);
        twitter.follow(2, 1);
        List<Integer> newsFeed2 = twitter.getNewsFeed(2);
        System.out.println(newsFeed2);
        twitter.unfollow(2, 1);
        List<Integer> newsFeed = twitter.getNewsFeed(2);
        System.out.println(newsFeed);
    }
}

