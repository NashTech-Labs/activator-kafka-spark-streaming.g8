package com.knoldus.utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ConfigReader {

    Config conf = ConfigFactory.load();

    public String getTwitterConsumerKey() {
        return conf.getString("twitter.consumerKey");
    }

    public String getTwitterConsumerSecretKey() {
        return conf.getString("twitter.consumerSecret");
    }

    public String getTwitterAccessToken() {
        return conf.getString("twitter.accessToken");
    }

    public String getTwitterAccessSecretToken() {
        return conf.getString("twitter.accessTokenSecret");
    }

    public String getKafkaServers() {
        return conf.getString("kafka.servers");
    }

    public String getKafkaTopic() {
        return conf.getString("kafka.topic");
    }

    public String getAppName() {
        return conf.getString("spark.appName");
    }

    public String getSparkMaster() {
        return conf.getString("spark.master");
    }

}
