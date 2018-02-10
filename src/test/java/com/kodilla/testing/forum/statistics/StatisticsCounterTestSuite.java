package com.kodilla.testing.forum.statistics;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class StatisticsCounterTestSuite {

    @Test
    public void testCalculateAdvStatisticsCommentsMoreThanPosts(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCounter counter = new StatisticsCounter(statisticsMock);

        List<String> userNames = new ArrayList<>();
        userNames.add("Gosia");
        userNames.add("Kasia");
        userNames.add("Zosia");
        userNames.add("Marysia");

        when(statisticsMock.userNames()).thenReturn(userNames);
        when(statisticsMock.postsCount()).thenReturn(4);
        when(statisticsMock.commentsCount()).thenReturn(8);

        //When
        counter.calculateAdvStatistics();

        //Then
        int result1 = counter.usersAmount;
        int result2 = counter.postsAmount;
        int result3 = counter.commentsAmount;
        double result4 = counter.averagePostsPerUser;
        double result5 = counter.averageCommentsPerUser;
        double result6 = counter.averageCommentsPerPost;

        Assert.assertEquals(4, result1);
        Assert.assertEquals(4, result2);
        Assert.assertEquals(8, result3);
        Assert.assertEquals(1.0, result4, 0);
        Assert.assertEquals(2.0,result5, 0);
        Assert.assertEquals(2.0, result6, 0);

    }

    @Test
    public void testCalculateAdvStatisticsPostsAndCommentsZero(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCounter counter = new StatisticsCounter(statisticsMock);
        List<String> userNames = new ArrayList<>();
        userNames.add("Gosia");
        userNames.add("Kasia");
        userNames.add("Zosia");
        userNames.add("Marysia");

        when(statisticsMock.userNames()).thenReturn(userNames);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);


        //When
        counter.calculateAdvStatistics();

        //Then
        int result1 = counter.usersAmount;
        int result2 = counter.postsAmount;
        int result3 = counter.commentsAmount;
        double result4 = counter.averagePostsPerUser;
        double result5 = counter.averageCommentsPerUser;
        double result6 = counter.averageCommentsPerPost;

        Assert.assertEquals(4, result1);
        Assert.assertEquals(0, result2);
        Assert.assertEquals(0, result3);
        Assert.assertEquals(0.0, result4, 0);
        Assert.assertEquals(0.0, result5, 0);
        Assert.assertEquals(0.0, result6, 0);
    }

    @Test
    public void testZeroUsers(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCounter counter = new StatisticsCounter(statisticsMock);
        List<String> userNames = new ArrayList<>();

        when(statisticsMock.userNames()).thenReturn(userNames);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        counter.calculateAdvStatistics();

        //Then
        int result1 = counter.usersAmount;
        int result2 = counter.postsAmount;
        int result3 = counter.commentsAmount;
        double result4 = counter.averagePostsPerUser;
        double result5 = counter.averageCommentsPerUser;
        double result6 = counter.averageCommentsPerPost;

        Assert.assertEquals(0, result1);
        Assert.assertEquals(0, result2);
        Assert.assertEquals(0, result3);
        Assert.assertEquals(0.0, result4, 0);
        Assert.assertEquals(0.0, result5, 0);
        Assert.assertEquals(0.0, result6, 0);
    }

    @Test
    public void testPostsMoreThanCommentsAnd100Users(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCounter counter = new StatisticsCounter(statisticsMock);
        List<String> userNames = new ArrayList<>();
        for(int i = 0; i<100; i++){
            userNames.add("user" + i);
        }

        when(statisticsMock.userNames()).thenReturn(userNames);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(200);

        //When
        counter.calculateAdvStatistics();

        //Then
        int result1 = counter.usersAmount;
        int result2 = counter.postsAmount;
        int result3 = counter.commentsAmount;
        double result4 = counter.averagePostsPerUser;
        double result5 = counter.averageCommentsPerUser;
        double result6 = counter.averageCommentsPerPost;

        Assert.assertEquals(100, result1);
        Assert.assertEquals(1000, result2);
        Assert.assertEquals(200, result3);
        Assert.assertEquals(10.0, result4, 0);
        Assert.assertEquals(2.0, result5, 0);
        Assert.assertEquals(0.2, result6, 0.0);
    }
}
