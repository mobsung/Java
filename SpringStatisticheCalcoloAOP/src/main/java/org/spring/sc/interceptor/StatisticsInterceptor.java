package org.spring.sc.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.spring.sc.dao.DAOcalcoli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StatisticsInterceptor {

    @Autowired
    DAOcalcoli dao;

    @Pointcut("execution(* org.spring.sc.service.CalcolatriceService.*(..))")
    public void operazione(){}

    @Before("operazione()")
    public void osserva(JoinPoint jp){
        dao.aumenta(jp.getSignature().getName());
    }
}
