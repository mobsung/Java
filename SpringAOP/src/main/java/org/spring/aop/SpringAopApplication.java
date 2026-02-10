package org.spring.aop;

import org.spring.aop.entity.Artista;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringAopApplication {

    public static void main(String[] args) {
       ApplicationContext context = SpringApplication.run(SpringAopApplication.class, args);

       Artista artista = context.getBean(Artista.class);
       artista.setNome("Ligabue");
       artista.perform();
    }

}
