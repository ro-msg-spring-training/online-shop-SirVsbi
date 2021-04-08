package ro.msg.learning.shop.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "supplier")
@EqualsAndHashCode
@ToString
public class Supplier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;
    private String name;

    @OneToMany(mappedBy = "supplierId", cascade = CascadeType.ALL, targetEntity = Product.class)
    private List<Product> products;
}
