package com.neckcode;

import com.neckcode.service.ClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GrpcClientApplication {

    public static void main(String[] args) throws InterruptedException {

        ApplicationContext applicationContext = SpringApplication.run(GrpcClientApplication.class, args);
        ClientService greeterClientService = applicationContext.getBean(ClientService.class);
        for (int i = 0; i < 100; i++) {
            greeterClientService.sayHello("I am your client", "Hello new server !!!");
            Thread.sleep(5000);
        }
    }
}
