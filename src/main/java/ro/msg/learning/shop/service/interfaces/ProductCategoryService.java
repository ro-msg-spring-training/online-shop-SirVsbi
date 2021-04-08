package ro.msg.learning.shop.service.interfaces;

import ro.msg.learning.shop.model.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> getAllProductCategories();

    void addProductCategory(ProductCategory productCategory);

}
