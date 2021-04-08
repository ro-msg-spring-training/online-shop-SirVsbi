package ro.msg.learning.shop.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "productcategory")
@EqualsAndHashCode
@ToString
public class ProductCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductCategoryId")
    private Long productCategoryId;

    private String name;

    private String description;

    @OneToMany(mappedBy = "productCategoryId", cascade = CascadeType.ALL, targetEntity = Product.class)
    private List<Product> products;
}
