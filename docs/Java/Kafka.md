# Kafka
##### Install kafka for mac
    1. install zookeeper
        1.1 download zookeeper from apache.org
        1.2 tar -zxvf zookeeper-3.4.12.tar.gz
        1.3 mv zookeeper-3.4.12 /usr/local/zookeeper
        1.4 mkdir -p /var/lib/zookeeper
        1.5 cat > /usr/local/zookeeper/conf/zoo.cfg <<EOF
            tickTime=2000
            dataDir=/var/lib/zookeeper
            clientPort=2181
            EOF
        1.6 zkServer.sh start


    2. install kafka
        2.1 download kafka from apache.org
        2.2 tar -zxvf kafka_2.12-1.1.0.tar.gz
        2.3 mv kafka_2.12-1.1.0 /usr/local/kafka
        2.4 mkdir /tmp/kafka-logs
        2.5 /usr/local/kafka/bin/kafka-server-start.sh -daemon /usr/local/kafka/config/server.properties

        -- see all topics
        kafka-topics.sh --list --zookeeper localhost:2181

    3 create topic
        /usr/local/kafka/bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
        --verify topic
        /usr/local/kafka/bin/kafka-topics.sh --zookeeper localhost:2181 --describe --topic test

    4.producer
        /usr/local/kafka/bin/kakfa-cosole-producer.sh --broker-list localhost:9092 --topic test

    5. consumer
        /usr/local/kafka_2.12-2.1.0/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092  --topic test.topic --from-beginning


    kafka-consumer-groups.sh --bootstrap-server localhost:9092  --list
    kafka-consumer-groups.sh --bootstrap-server localhost:9092  --delete --group consumerGroupName