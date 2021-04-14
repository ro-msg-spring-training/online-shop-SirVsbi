package ro.msg.learning.shop.model;



import lombok.*;

import javax.persistence.*;
import java.io.Serializable;



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

}
