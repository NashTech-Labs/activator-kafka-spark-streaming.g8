#Spark Streaming + Kafka Integration

This is an activator project for showcasing integration of Kafka 0.10 with Spark Streaming in which we are pushing Tweets in Kafka Cluster and consuming tweets using spark streaming. 
Here we are using: 

**Kafka Client** for Kafka API

**Twitter4J Streaming** as a source.

**Jackson ObjectMapper** for byte stream conversion.

**Typesafe Config** to read configuration file.

**Spark Streaming** to read from kafka cluster

---
###Steps to Install and Run Zookeeper and Kafka on your system :

Step 1: Download Kafka

Download Kafka from [here](https://www.apache.org/dyn/closer.cgi?path=/kafka/0.10.1.1/kafka_2.11-0.10.1.1.tgz)

Step 2: Extract downloaded file

```bash
tar -xzvf kafka_2.11-0.10.1.1.tgz
cd kafka_2.11-0.10.1.1
```        
    
Step 3: Start Servers

Start Zookeeper:

```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```
    
Start Kafka server:

```bash
bin/kafka-server-start.sh config/server.properties
```


---
###Clone Project

```bash
git clone git@github.com:knoldus/activator-kafka-spark-streaming.git
cd activator-kafka-spark-streaming
bin/activator clean compile

```
---
###Start Tweet Producer

```bash
bin/activator "run-main com.knoldus.demo.ProducerDemo"
```

    
This will start fetching tweets and push every tweet into the Kafka queue.

---
###Start Streaming

```bash
bin/activator "run-main com.knoldus.demo.SparkStreamingDemo"
```

    
This will start streaming.

---
For any issue please raise a ticket @ [Github Issue](https://github.com/knoldus/activator-kafka-spark-streaming/issues)