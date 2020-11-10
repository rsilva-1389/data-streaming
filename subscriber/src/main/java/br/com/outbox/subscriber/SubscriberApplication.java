package br.com.outbox.subscriber;

import javax.xml.stream.util.StreamReaderDelegate;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SubscriberApplication {

    public static Logger logger = LoggerFactory.getLogger(SubscriberApplication.class);

    @Autowired
    private KafkaTemplate<String, String> template;

    @KafkaListener(topics = "db.cdc.public.outbox")
    public synchronized void consume(ConsumerRecord<String, String> record) {
        logger.info("key: {}, value: {}", record.key(), record.value());
    }

    public static void main(String[] args) {
        SpringApplication.run(SubscriberApplication.class, args);
    }

}
