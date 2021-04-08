package ro.msg.learning.shop.service.interfaces;

import ro.msg.learning.shop.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    void addProduct(Product product);


}
