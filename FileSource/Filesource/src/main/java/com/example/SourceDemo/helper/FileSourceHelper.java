package com.example.SourceDemo.helper;

import com.example.beans.models.FileSourceModel;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.io.*;

@Configuration
public class FileSourceHelper {
    public final String json = "{\n" +
            "        \"productName\":\"Product1\",\n" +
            "        \"version\":\"1.0\"\n" +
            "\n" +
            "        }";

    @Bean
    @InboundChannelAdapter(
            value = Source.OUTPUT,
            poller = @Poller(fixedDelay = "10000", maxMessagesPerPoll = "1")
    )
    public MessageSource<String> timeMessageSource() {
        System.out.println("DEBUG::############################################################:" + json);
        return () -> MessageBuilder.withPayload(json).build();
    }
}