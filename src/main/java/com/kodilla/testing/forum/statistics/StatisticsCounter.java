package com.kodilla.testing.forum.statistics;

public class StatisticsCounter {
    Statistics statistics;
    int usersAmount;
    int postsAmount;
    int commentsAmount;
    double averagePostsPerUser;
    double averageCommentsPerUser;
    double averageCommentsPerPost;

    public StatisticsCounter(Statistics statistics) {
        this.statistics = statistics;
    }

    public int usersAmount() {
        return statistics.userNames().size();
    }

    public int postsAmount() {
        return statistics.postsCount();
    }

    public int commentsAmount() {
        return statistics.commentsCount();
    }

    public double averagePostsPerUser() {
        double usersNum = statistics.userNames().size();
        double postsNum = statistics.postsCount();
        if(usersNum == 0){
            return 0;
        } else {
            return postsNum/usersNum;
        }
    }

    public double averageCommentsPerUser() {
        double usersNum = statistics.userNames().size();
        double commentsNum = statistics.commentsCount();
        if(usersNum == 0 ){
            return 0;
        } else {
            return commentsNum/usersNum;
        }

    }

    public double averageCommentsPerPost() {
        double postsNum = statistics.postsCount();
        double commentsNum = statistics.commentsCount();
        if(postsNum == 0){
            return 0;
        } else {
            return commentsNum/postsNum;
        }

    }

    public void calculateAdvStatistics() {
        usersAmount = usersAmount();
        postsAmount = postsAmount();
        commentsAmount = commentsAmount();
        averagePostsPerUser = averagePostsPerUser();
        averageCommentsPerUser = averageCommentsPerUser();
        averageCommentsPerPost = averageCommentsPerPost();

    }

    public String showStatistics() {
        return "Statistics: \nusersAmount: " + usersAmount + " postsAmount: " + postsAmount + " commentsAmount " + commentsAmount + " averagePostsPerUser " + averagePostsPerUser + " averageCommentsPerUser " + averageCommentsPerUser + " averageCommentsPerPost " + averageCommentsPerPost;
    }


}
