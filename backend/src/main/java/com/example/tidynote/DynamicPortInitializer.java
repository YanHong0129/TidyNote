package com.example.tidynote;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.ServerSocket;

public class DynamicPortInitializer implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment environment = event.getEnvironment();
        int baseport = environment.getProperty("server.port", Integer.class, 8081);
        int port = baseport;

        while (true) {
            try (ServerSocket socket = new ServerSocket(port)) {
                environment.getSystemProperties().put("server.port", String.valueOf(port));
                System.out.println("Port " + port + " is available. Setting it...");
                break;
            } catch (Exception e) {
                System.out.println("Port " + port + " in use, trying next...");
                port++;
            }
        }
    }
    
}
