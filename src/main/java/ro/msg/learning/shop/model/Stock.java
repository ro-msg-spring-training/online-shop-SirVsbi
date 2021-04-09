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
@Table(name = "Stock")
@EqualsAndHashCode
@ToString
@IdClass(StockKey.class)
public class Stock implements Serializable {

    @Id
    @ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductId", foreignKey = @ForeignKey(name = "FK_STOCK_PRODUCT"))
    private Product productId;

    @Id
    @ManyToOne(targetEntity = Location.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "LocationId", foreignKey = @ForeignKey(name = "FK_STOCK_LOCATION"))
    private Location locationId;

    private int quantity;

}
