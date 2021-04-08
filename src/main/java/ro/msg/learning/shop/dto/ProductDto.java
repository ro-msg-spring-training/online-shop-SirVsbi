package ro.msg.learning.shop.dto;

import lombok.*;
import ro.msg.learning.shop.model.Supplier;

import java.math.BigDecimal;
import java.util.Set;


@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
    private long productId;
    private String name;
    private String description;
    private BigDecimal price;
    private float weight;
    private long supplierId;
    private long productCategoryId;
    private String imageUrl;
    private Supplier supplier;

}
