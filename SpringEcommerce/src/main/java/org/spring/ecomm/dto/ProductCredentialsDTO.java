package org.spring.ecomm.dto;

public class ProductCredentialsDTO {

    private String username, password;
    private ProductDTO productDTO;

    public ProductCredentialsDTO(String username, String password, ProductDTO productDTO) {
        this.username = username;
        this.password = password;
        this.productDTO = productDTO;
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

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }
}
