package ro.msg.learning.shop.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.dto.SupplierDto;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.service.interfaces.SupplierService;


import java.util.Collections;


@Component
public class ProductConverter extends AbstractConverter<Product, ProductDto> {


   @Autowired
   private SupplierService supplierService;

   @Autowired
   private SupplierConverter supplierConverter;

    @Override
    public Product dtoToModel(ProductDto productDto) {
        var supplier = supplierService.getSupplierById(productDto.getSupplierId());
        return Product.builder()
                .productId(productDto.getProductId())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .weight(productDto.getWeight())
                .supplierId(supplier.orElse(null))
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
                .supplier(
                        supplierConverter.convertModelToDto(
                                Collections.singletonList(product.getSupplierId())
                        ).stream().findFirst().orElse(new SupplierDto(-1, "no thing"))
                )
                .imageUrl(product.getImageUrl())
                .build();
    }
}
