# Open Source Kafka Startup Guide

This guide will walk you through the steps to set up and run Apache Kafka, an open-source distributed event streaming platform, on your local machine. Follow the steps below to get started with Kafka.

## Steps to Setup

**1. Download and Install Kafka**

Visit the Apache [Kafka download page](https://kafka.apache.org/downloads) to download the latest version of Kafka and extract it

**2. Start the Kafka Environment**

#### Start the ZooKeeper service

Open a terminal and navigate to the Kafka directory.
```bash
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```
#### Start the Kafka broker service

In a new terminal window, start the Kafka server:
```bash
.\bin\windows\kafka-server-start.bat .\config\server.properties
```
**3. Create a Topic to Store Your Events**

To create a topic, open a new command prompt and navigate to the Kafka directory and run the following command:
```bash
.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --create --topic <topic-name> --partitions 5 --replication-factor 1

```

**4. List All Topics**

To list all topics, run the following command:
```bash
.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list
```

**5. Describe a Topic**

To describe a specific topic, run the following command:
```bash
.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --describe --topic <topic-name>
```

**6. Write Events into the Topic**

To write events into the topic, use the Kafka console producer. Open a new command prompt and run the following command:
```bash
.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic <topic-name>
```

**7. Read the Events**

To read the events from the topic, use the Kafka console consumer. Open a new command prompt and run the following command:
```bash
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic <topic-name> --from-beginning
```

