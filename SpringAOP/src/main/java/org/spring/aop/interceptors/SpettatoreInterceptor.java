package org.spring.aop.interceptors;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SpettatoreInterceptor {

    @Around("execution(* org.spring.aop.entity.Artista.perform(..))")
    public void filtro(ProceedingJoinPoint jp){
        System.out.println("gli spettatori prendono il posto");
        System.out.println("gli spettatori spengono il cellulare");
        long start = System.currentTimeMillis();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            jp.proceed();
            System.out.println("Applausi!!!!!!!!!!!!");
            long end = System.currentTimeMillis();
            System.out.println("lo show è durato " + (end - start) + " ms");
        } catch (Throwable e) {
            System.out.println("c'e stato un problema, show interrotto");
        }
    }
}
