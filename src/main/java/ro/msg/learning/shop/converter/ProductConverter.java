package ro.msg.learning.shop.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductDto;

import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.service.interfaces.SupplierService;



@Component
public class ProductConverter extends AbstractConverter<Product, ProductDto> {


    @Override
    public Product dtoToModel(ProductDto productDto) {
        return Product.builder()
                .productId(productDto.getProductId())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .weight(productDto.getWeight())
                .imageUrl(productDto.getImageUrl())
                .build();
    }

    @Override
    public ProductDto modelToDto(Product product) {

        return ProductDto.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .weight(product.getWeight())
                .imageUrl(product.getImageUrl())
                .build();
    }
}
