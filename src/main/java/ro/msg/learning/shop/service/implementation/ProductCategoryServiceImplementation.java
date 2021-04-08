package ro.msg.learning.shop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.model.ProductCategory;
import ro.msg.learning.shop.repository.ProductCategoryRepository;
import ro.msg.learning.shop.service.interfaces.ProductCategoryService;

import java.util.List;

@Service
public class ProductCategoryServiceImplementation implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public List<ProductCategory> getAllProductCategories() {
        return this.repository.findAll();
    }

    @Override
    public void addProductCategory(ProductCategory productCategory) {
        this.repository.save(productCategory);
    }
}
