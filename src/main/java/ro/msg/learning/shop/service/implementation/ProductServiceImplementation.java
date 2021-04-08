package ro.msg.learning.shop.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.repository.ProductRepository;
import ro.msg.learning.shop.service.interfaces.ProductService;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getAllProducts() {
        return this.repository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        this.repository.save(product);
    }
}
