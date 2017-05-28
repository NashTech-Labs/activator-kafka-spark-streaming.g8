package com.knoldus.twitter;

import com.knoldus.kafka.TweetProducer;
import com.knoldus.utils.ConfigReader;
import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;

public class TwitterFeed {

    private ConfigReader configReader = new ConfigReader();

    private TwitterStream getTwitterConfig() {

        Configuration twitterConf = new ConfigurationBuilder()
                .setOAuthConsumerKey(configReader.getTwitterConsumerKey())
                .setOAuthConsumerSecret(configReader.getTwitterConsumerSecretKey())
                .setOAuthAccessToken(configReader.getTwitterAccessToken())
                .setOAuthAccessTokenSecret(configReader.getTwitterAccessSecretToken())
                .build();
        return new TwitterStreamFactory(twitterConf).getInstance();
    }

    public void sendTweetsToKafka() throws TwitterException, IOException {

        StatusListener listener = new StatusListener() {
            public void onStatus(Status status) {
                String tweet = status.getText();
                new TweetProducer().send(tweet);
                System.out.println("Sent: " + tweet);
            }

            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
                //Do Nothing
            }

            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
                //Do Nothing
            }

            public void onScrubGeo(long l, long l1) {
                //Do Nothing
            }

            public void onStallWarning(StallWarning stallWarning) {
                //Do Nothing
            }

            public void onException(Exception ex) {
                ex.printStackTrace();
            }
        };

        TwitterStream twitterStream = getTwitterConfig();
        twitterStream.addListener(listener);
        twitterStream.sample("en");

    }

}
