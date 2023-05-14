# Kafka in spring boot
## 1. Get Started
### 1.0 Run kafka
- Kafka with ZooKeeper
  + Run the following commands in order to start all services in the correct order:
```java
         # Start the ZooKeeper service
         $ bin/zookeeper-server-start.sh config/zookeeper.properties
```
  + Run the following commands in order to start all services in the correct order:
```java
        # Start the Kafka broker service
        $ bin/kafka-server-start.sh config/server.properties
```
