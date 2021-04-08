package ro.msg.learning.shop.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.repository.ProductRepository;
import ro.msg.learning.shop.repository.SupplierRepository;


@Component
public class ProductConverter extends AbstractConverter<Product, ProductDto> {

   @Autowired
   private SupplierRepository supplierRepository;

    @Override
    public Product dtoToModel(ProductDto productDto) {
        var supplier = supplierRepository.findById(productDto.getSupplierId());
        return Product.builder()
                .productId(productDto.getProductId())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .weight(productDto.getWeight())
                .supplierId(supplier.get())
              //  .productCategoryId(productDto.getProductCategory())
                .imageUrl(productDto.getImageUrl())
                .build();
    }

    @Override
    public ProductDto modelToDto(Product product) {
      //  System.out.println(product.getSupplierId());
        return ProductDto.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .weight(product.getWeight())
               // .supplier(product.getSupplierId())
              //  .productCategory(product.getProductCategoryId())
                .imageUrl(product.getImageUrl())
                .build();
    }
}
