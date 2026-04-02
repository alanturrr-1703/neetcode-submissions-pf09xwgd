class Twitter {
    int time;
    HashMap<Integer, List<int[]>> userToTweets;
    HashMap<Integer, Set<Integer>> userToFollowee;
    public Twitter() {
        time = Integer.MIN_VALUE;
        userToTweets = new HashMap<>();
        userToFollowee = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        userToTweets.putIfAbsent(userId, new ArrayList<>());
        userToTweets.get(userId).add(new int[] {time, tweetId});
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        userToFollowee.putIfAbsent(userId, new HashSet<>());
        userToFollowee.get(userId).add(userId);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        for(int followeeId : userToFollowee.getOrDefault(userId, new HashSet<>())){
            if(!userToTweets.containsKey(followeeId)) continue;
            List<int[]> tweets = userToTweets.get(followeeId);
            int idx = tweets.size() - 1;
            int[] t = tweets.get(idx);
            maxHeap.offer(new int[] {t[0], t[1], followeeId, idx});
        }
        while (!maxHeap.isEmpty() && res.size() < 10) {
            int[] cur = maxHeap.poll();
            res.add(cur[1]);

            int user = cur[2];
            int idx = cur[3] - 1;

            if (idx >= 0) {
                int[] next = userToTweets.get(user).get(idx);
                maxHeap.offer(new int[]{next[0], next[1], user, idx});
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        userToFollowee.putIfAbsent(followerId, new HashSet());
        userToFollowee.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(userToFollowee.containsKey(followerId) && followerId != followeeId) userToFollowee.get(followerId).remove(followeeId);
    }
}
