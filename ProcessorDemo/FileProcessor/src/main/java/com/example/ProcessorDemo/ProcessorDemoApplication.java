package com.example.ProcessorDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableAutoConfiguration(exclude ={DataSourceAutoConfiguration.class})
@EnableBinding(Processor.class)
public class ProcessorDemoApplication {

    final static Logger logger = LoggerFactory.getLogger(ProcessorDemoApplication.class);

    public static void main(String[] args) {

        logger.info("ProcessorDemoApplication.main()");

        SpringApplication.run(ProcessorDemoApplication.class, args);

        logger.info("main() After run method");
        for (int i=0; i<=100000; i++) {
            logger.info("main() Msg #1 1234567890 1234567890*** ");
            logger.warn("Msg #2");
            logger.error("Msg #3");
            logger.debug("Msg #4");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Transformer(inputChannel = Processor.INPUT,
            outputChannel = Processor.OUTPUT)
    public String transform(String fileSourceModel) {
        //System.out.println("fileSourceModel Object Stream length:::" + fileSourceModel.length());
        //logger.info("transform(): fileSourceModel Stream string:::" + fileSourceModel);

        for (int i=0; i<=10000; i++) {
            logger.info("t: Msg #1 123 ###");
        }

        return fileSourceModel;
    }
}
