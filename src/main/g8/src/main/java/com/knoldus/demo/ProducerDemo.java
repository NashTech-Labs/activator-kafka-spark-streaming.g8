package com.knoldus.demo;

import com.knoldus.twitter.TwitterFeed;
import twitter4j.TwitterException;

import java.io.IOException;

public class ProducerDemo {

    public static void main(String[] args) throws TwitterException, IOException {
        new TwitterFeed().sendTweetsToKafka();
    }

}
