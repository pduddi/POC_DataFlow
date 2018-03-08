package com.example.SincDemo;

import com.example.SincDemo.entities.Product;
import com.example.SincDemo.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import java.io.IOException;
import java.util.logging.Logger;

@SpringBootApplication
@EnableBinding(Sink.class)
public class SincDemoApplication {
    Logger logger = Logger.getLogger(SincDemoApplication.class.getName());
    public static void main(String[] args) {
        SpringApplication.run(SincDemoApplication.class, args);
    }
    public final String filePath = "D:\\projects\\POC_DataFlow\\product.xml";
    @Autowired
    private ProductRepository productRepository;

    @StreamListener(Sink.INPUT)
    public void loggerSink(String  fileSourceModel) throws IOException {

        Product product =  new ObjectMapper().readValue(fileSourceModel, Product.class);
        System.out.println("JSON_OBJECT:::"+product);
        productRepository.save(product);
        logger.info("Product saved successfully. ");
        System.out.println("Product saved successfully. ");
    }
}
