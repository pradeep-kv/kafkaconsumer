package com.ogma.kafkaconsumer.configuration;

import com.ogma.kafkaconsumer.model.FixMsgModel;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> consumerFactoryConfigs = new HashMap<>();
        consumerFactoryConfigs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        consumerFactoryConfigs.put(ConsumerConfig.GROUP_ID_CONFIG, "foo");
        consumerFactoryConfigs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        consumerFactoryConfigs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(consumerFactoryConfigs);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, FixMsgModel> fixMsgConsumerFactory() {
        Map<String, Object> fixMsgConsumerFactoryConfigs = new HashMap<>();
        fixMsgConsumerFactoryConfigs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        fixMsgConsumerFactoryConfigs.put(ConsumerConfig.GROUP_ID_CONFIG, "foo");
//        fixMsgConsumerFactoryConfigs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        fixMsgConsumerFactoryConfigs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer<>(FixMsgModel.class));
        fixMsgConsumerFactoryConfigs.put(JsonDeserializer.TRUSTED_PACKAGES,"*");
        return new DefaultKafkaConsumerFactory<>(fixMsgConsumerFactoryConfigs, new StringDeserializer(), new JsonDeserializer<>(FixMsgModel.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, FixMsgModel> fixMsgKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, FixMsgModel> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(fixMsgConsumerFactory());
        return factory;
    }
}
