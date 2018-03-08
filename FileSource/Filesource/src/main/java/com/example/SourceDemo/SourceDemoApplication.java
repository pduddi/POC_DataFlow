package com.example.SourceDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.MessageBuilder;

import java.io.File;
import java.util.Date;

@SpringBootApplication
@EnableBinding(Source.class)
public class SourceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SourceDemoApplication.class, args);
    }

}
