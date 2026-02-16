package org.spring.ecomm.interceptors;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.spring.ecomm.dao.AdminDAO;
import org.spring.ecomm.dto.ProductCredentialsDTO;
import org.spring.ecomm.dto.ProductIdCredentialsDTO;
import org.spring.ecomm.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Aspect
public class AccessInterceptor {

    @Autowired
    AdminDAO daoAdmin;

    @Around("execution(* org.spring.ecomm.service.ProductServiceImpl.addProduct(..))")
    public Object autorizzaAdd(ProceedingJoinPoint jp) throws Throwable {

        ProductCredentialsDTO dto = (ProductCredentialsDTO) jp.getArgs()[0];

        Map<String, String> admins = daoAdmin.listCredentials();

        String storedPassword = admins.get(dto.getUsername());

        if (storedPassword == null || !storedPassword.equals(dto.getPassword())) {
            throw new UserNotFoundException("Invalid credentials");
        }

        return jp.proceed();
    }

    @Around("execution(* org.spring.ecomm.service.ProductServiceImpl.deleteProduct(..))")
    public Object autorizzaDelete(ProceedingJoinPoint jp) throws Throwable {

        ProductIdCredentialsDTO dto = (ProductIdCredentialsDTO) jp.getArgs()[0];

        Map<String, String> admins = daoAdmin.listCredentials();

        String storedPassword = admins.get(dto.getUsername());

        if (storedPassword == null || !storedPassword.equals(dto.getPassword())) {
            throw new UserNotFoundException("Invalid credentials");
        }

        return jp.proceed();
    }

}
