
class Twitter {
    // 需要一个map存userid和他们关注的人，注意要默认关注自己，把自己存进去
    // 用优先队列存user关注的人的tweets 按照时间顺序从小到大
    // 需要一个tweets类 里面存userid，发布时间
    // 大顶堆放所有人的tweet 按时间排序
    // 找的时候从tweet里面取这个人关注的
    Map<Integer, Set<Integer>> map = new HashMap<>();
    Map<Integer, List<Tweet>> userTweet = new HashMap<>();
    private long seq = 0;

    class Tweet {
        int userId;
        int tweetId;
        long order;

        public Tweet(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.order = ++seq;
        }
    }

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        map.putIfAbsent(userId, new HashSet<>());
        map.get(userId).add(userId);

        Tweet tweet = new Tweet(userId, tweetId);
        userTweet.putIfAbsent(userId, new ArrayList<>());
        userTweet.get(userId).add(tweet);

    }
    
    public List<Integer> getNewsFeed(int userId) {
        map.putIfAbsent(userId, new HashSet<>());
        map.get(userId).add(userId);
        
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Tweet> news = new PriorityQueue<>((a, b) -> Long.compare(b.order, a.order));
        
        for(int fol: map.get(userId)) {
            // 拿到每一个用户自己的文章列表
            List<Tweet> uts = userTweet.get(fol);
            if (uts == null) continue;
            for (int i = uts.size() - 1, cnt = 0; i >= 0 && cnt < 10; i--, cnt++) {
                news.offer(uts.get(i));
            }
        }
        while(res.size() < 10 && !news.isEmpty()) {
            res.add(news.poll().tweetId);
        }
        return res;
        
    }
    
    public void follow(int followerId, int followeeId) {
        map.putIfAbsent(followerId, new HashSet<>());
        map.get(followerId).add(followerId);
        map.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!map.containsKey(followerId) || followerId == followeeId) return;
        map.get(followerId).remove(followeeId);
    }
}
