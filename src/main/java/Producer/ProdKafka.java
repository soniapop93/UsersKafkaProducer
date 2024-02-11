package Producer;

import Users.generated.User;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;

public class ProdKafka {
    String bootstrapServers = "127.0.0.1:9092";
    public void send() {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", bootstrapServers);
        properties.setProperty("schema.registry.url", "http://localhost:8081");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", KafkaProtobufSerializer.class.getName());

        KafkaProducer<String, User> kafkaProd = new KafkaProducer<>(properties);
    }
}
