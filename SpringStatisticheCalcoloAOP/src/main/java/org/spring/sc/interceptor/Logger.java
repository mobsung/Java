package org.spring.sc.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {

    @Pointcut("execution(* org.spring.sc.service.CalcolatriceService.*(..))")
    public void operazione(){}

    @Around("operazione()")
    public Object logging(ProceedingJoinPoint jp){

        System.out.println("Viene eseguita la " + jp.getSignature().getName());

        try {
            Object obj = jp.proceed();
            System.out.println("L'operazione è andata a buon fine");

            return obj;
        } catch (Throwable e) {
            System.out.println("L'operazione è andata in errore con: " + e.getMessage());
            return null;
        }
    }

}
