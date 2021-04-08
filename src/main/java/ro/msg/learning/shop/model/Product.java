package ro.msg.learning.shop.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "product")
@EqualsAndHashCode
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private Long productId;

    private String name;

    private String description;

    private BigDecimal price;

    private Float weight;

    @ManyToOne(targetEntity = Supplier.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "SupplierId", foreignKey = @ForeignKey(name = "FK_PRODUCT_SUPPLIER"))
    private Supplier supplierId;

    @ManyToOne(targetEntity = ProductCategory.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductCategoryId")

    private ProductCategory productCategoryId;

    private String imageUrl;

}
