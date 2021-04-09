package ro.msg.learning.shop.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;



@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductDto implements Serializable {
    private long productId;
    private String name;
    private String description;
    private BigDecimal price;
    private float weight;
    private long supplierId;
    private long productCategoryId;
    private String imageUrl;
    private SupplierDto supplier;

}
