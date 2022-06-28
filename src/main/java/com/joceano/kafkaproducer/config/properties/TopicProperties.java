package com.joceano.kafkaproducer.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicProperties {

    @Value("${topic.name.producer}")
    private String topicName;

    public String getTopicName() {
        return topicName;
    }
}
