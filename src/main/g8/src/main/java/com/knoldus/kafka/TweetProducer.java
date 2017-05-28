package com.knoldus.kafka;


import com.knoldus.utils.ConfigReader;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class TweetProducer {

    private ConfigReader configReader = new ConfigReader();

    public void send(String tweet) {
        String kafkaServers = configReader.getKafkaServers();
        String kafkaTopic = configReader.getKafkaTopic();
        Properties props = new Properties();
        props.put("bootstrap.servers", kafkaServers);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        try (Producer<String, String> producer = new KafkaProducer<>(props)) {
            producer.send(new ProducerRecord<>(kafkaTopic, tweet));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
