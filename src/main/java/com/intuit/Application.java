package com.intuit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableConfigurationProperties
@EnableEurekaServer
@SpringBootApplication
public class Application {

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        Application.launchApp(args);
    }

    private static void launchApp(String[] args) {
        try {
            logger.info("Starting Application");
            new SpringApplicationBuilder(Application.class)
                    .run(args)
                    .registerShutdownHook();
        }
        catch (Exception ex) {
            logger.error("Exception while starting the Eureka Server {}" , ex);
            System.exit(0);
        }
    }
}