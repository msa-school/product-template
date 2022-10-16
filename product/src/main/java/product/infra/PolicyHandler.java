package product.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import product.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import product.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired ProductRepository productRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='ProductChanged'")
    public void wheneverProductChanged_ItIsNotCommon(@Payload ProductChanged productChanged){

        ProductChanged event = productChanged;
        System.out.println("\n\n##### listener ItIsNotCommon : " + productChanged + "\n\n");


        

        // Sample Logic //
        Product.itIsNotCommon(event);
        

        

    }

}


