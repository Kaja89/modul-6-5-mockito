package com.kodilla.testing.forum.statistics;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class StatisticsCounterTestSuite {

    public ArrayList<String> generateUsers(int n) {
        ArrayList<String> users = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            users.add("User");
        }
        return users;
    }

    @Test
    public void testUsersAmount0() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCounter statisticsCounter = new StatisticsCounter(statisticsMock);
        List<String> users = new ArrayList<>();
        when(statisticsMock.userNames()).thenReturn(users);
        //When
        int usersAmount = statisticsCounter.usersAmount();
        //Then
        Assert.assertEquals(0, usersAmount);
    }

    @Test
    public void testUsersAmount100() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCounter statisticsCounter = new StatisticsCounter(statisticsMock);
        List<String> users = generateUsers(100);
        when(statisticsMock.userNames()).thenReturn(users);
        //When
        int usersAmount = statisticsCounter.usersAmount();
        //Then
        Assert.assertEquals(100, usersAmount);

    }

    @Test
    public void testPostsAmount0(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCounter counter = new StatisticsCounter(statisticsMock);
        when(statisticsMock.postsCount()).thenReturn(0);

        //When
        int postsAmount = counter.postsAmount();

        //Then
        Assert.assertEquals(0, postsAmount);
    }

    @Test
    public void testPostsAmount1000(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCounter counter = new StatisticsCounter(statisticsMock);
        when(statisticsMock.postsCount()).thenReturn(1000);

        //When
        int postsAmount = counter.postsAmount();

        //Then
        Assert.assertEquals(1000, postsAmount);
    }

    @Test
    public void testCommentsAmount0(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCounter counter = new StatisticsCounter(statisticsMock);
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        int commentsAmount = counter.commentsAmount();

        //Then
        Assert.assertEquals(0, commentsAmount);
    }

    @Test
    public void testAveragePosts1000PerUser100(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCounter counter = new StatisticsCounter(statisticsMock);
        List<String> users = generateUsers(100);
        when(statisticsMock.userNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(1000);

        //When
        double averagePostsPerUser = counter.averagePostsPerUser();

        //Then
        Assert.assertEquals(10.0, averagePostsPerUser, 0);
    }

    @Test
    public void testAverageComments0PerUser0(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCounter counter = new StatisticsCounter(statisticsMock);
        List<String> users = new ArrayList<>();
        when(statisticsMock.userNames()).thenReturn(users);
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        double averageCommentsPerUser = counter.averageCommentsPerUser();

        //Then
        Assert.assertEquals(0, averageCommentsPerUser, 0);
    }

    @Test
    public void testAverageCommentsPerPostMoreComments(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCounter counter = new StatisticsCounter(statisticsMock);
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(100);

        //When
        double averageCommentsPerPost = counter.averageCommentsPerPost();

        //Then
        Assert.assertEquals(2.0, averageCommentsPerPost, 0);
    }

    @Test
    public void testAverageCommentsPerPostMorePosts(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCounter counter = new StatisticsCounter(statisticsMock);
        when(statisticsMock.postsCount()).thenReturn(500);
        when(statisticsMock.commentsCount()).thenReturn(100);

        //When
        double averageCommentsPerPost = counter.averageCommentsPerPost();

        //Then
        Assert.assertEquals(0.2, averageCommentsPerPost, 0);
    }
}
