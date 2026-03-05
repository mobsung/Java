package org.spring.catalogo_rd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CatalogoRdApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogoRdApplication.class, args);
    }

}
