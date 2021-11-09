package org.mgm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.mgm.factory.CustomerFactory;
import org.mgm.model.Order;

import java.util.Properties;

public class ProducerOrders {

    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // create producer
        KafkaProducer<String, String>producer = new KafkaProducer<String, String>(prop);
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("orders", "");
        producer.send(record);
        producer.close();

        ObjectMapper objectMapper = new ObjectMapper();
        Order order = new Order();
        order.setCustomer(CustomerFactory.generateCustomer());
        try {
            String OrderAsString = objectMapper.writeValueAsString(order);
            System.out.println(OrderAsString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
