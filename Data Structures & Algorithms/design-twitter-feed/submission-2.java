class Twitter {
    // 全局计数器记录顺序 从0开始， 越来越小
    private int count;
    // 记录用户，帖子的顺序，帖子的id
    private Map<Integer, List<int[]>> tweetMap;
    // 记录关注的人，默认要关注自己，用set去重
    private Map<Integer, Set<Integer>> followMap;

    public Twitter() {
        this.count = 0;
        this.tweetMap = new HashMap<>();
        this.followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>())
                .add(new int[]{count, tweetId});
        if(tweetMap.get(userId).size() > 10) {
            tweetMap.get(userId).remove(0);
        }
        count--;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        // 检查一下有没有关注自己
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        // 小顶堆
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int followeeId: followMap.get(userId)) {
            // 如果关注的人没发帖子就跳过
            if(!tweetMap.containsKey(followeeId)) continue;
            // 拿到这个人发过的所有帖子
            List<int[]> tweets = tweetMap.get(followeeId);
            // 最后一个帖子是最新的
            int idx = tweets.size() - 1;
            int[] tweet = tweets.get(idx);
            // 把最后这个加入进总的最小堆, 存count，帖子id，用户id，这个用户的下一个帖子的idx
            minHeap.offer(new int[]{tweet[0], tweet[1], followeeId, idx - 1});
        }

        while(!minHeap.isEmpty() && res.size() < 10) {
            int[] top = minHeap.poll();
            res.add(top[1]);
            // 拿到下一个帖子的
            int next = top[3];
            // 如果用户还有下一个帖子
            if(next >= 0) {
                // 找到用户发过的所有帖子
                List<int[]> tweets = tweetMap.get(top[2]);
                // 拿到下一个帖子
                int[] nextTweet = tweets.get(next);
                minHeap.offer(new int[]{nextTweet[0], nextTweet[1], top[2], next - 1});
            }
        }

        return res;
        
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet())
            .add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}




















