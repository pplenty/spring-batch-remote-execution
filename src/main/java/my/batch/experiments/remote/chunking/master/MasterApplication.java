package my.batch.experiments.remote.chunking.master;

import org.apache.activemq.broker.BrokerService;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@EnableBatchProcessing
@SpringBootApplication
public class MasterApplication {

    @Value("${broker.url}")
    private String brokerUrl;

    public static void main(String[] args) {
        SpringApplication.run(MasterApplication.class, args);
    }


    @PostConstruct
    public void init() throws Exception {
        BrokerService broker = new BrokerService();
        broker.addConnector(brokerUrl);
        broker.start();
    }
}