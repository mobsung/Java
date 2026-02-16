package org.spring.ecomm.dao;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AdminDAOImpl implements AdminDAO{

    private Map<String, String> admins = new HashMap<>();

    public AdminDAOImpl(){
        admins.put("stefano", "reali");
    }

    public Map<String, String> listCredentials(){
        return admins;
    }

}
