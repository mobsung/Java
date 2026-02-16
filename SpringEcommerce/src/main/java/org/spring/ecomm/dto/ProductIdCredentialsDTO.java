package org.spring.ecomm.dto;

public class ProductIdCredentialsDTO {

    private String username, password;
    private int productID;

    public ProductIdCredentialsDTO(String username, String password, int productID) {
        this.username = username;
        this.password = password;
        this.productID = productID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
}
