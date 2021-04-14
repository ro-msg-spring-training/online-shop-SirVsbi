package ro.msg.learning.shop.converter;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductCategoryDto;
import ro.msg.learning.shop.model.ProductCategory;

@Component
public class ProductCategoryConverter extends AbstractConverter<ProductCategory, ProductCategoryDto> {

    public ProductCategory dtoToModel(ProductCategoryDto productCategoryDto) {
        return ProductCategory.builder()
                .productCategoryId(productCategoryDto.getProductCategoryId())
                .name(productCategoryDto.getName())
                .description(productCategoryDto.getDescription())
                .build();
    }

    public ProductCategoryDto modelToDto(ProductCategory productCategory) {
        return ProductCategoryDto.builder()
                .productCategoryId(productCategory.getProductCategoryId())
                .name(productCategory.getName())
                .description(productCategory.getDescription())
                .build();
    }
}
