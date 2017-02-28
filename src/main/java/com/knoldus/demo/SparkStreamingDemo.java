package com.knoldus.demo;


import com.knoldus.spark.StreamTweets;

public class SparkStreamingDemo {

    public static void main(String[] args) throws InterruptedException {
        new StreamTweets().startStreaming("demo-consumer-group");
    }

}
