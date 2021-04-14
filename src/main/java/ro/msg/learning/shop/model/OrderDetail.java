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
@Table(name = "OrderDetail")
@EqualsAndHashCode
@ToString
@Embeddable
@IdClass(OrderDetailKey.class)
public class OrderDetail implements Serializable {

    @Id
    @ManyToOne(targetEntity = Order.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderId", foreignKey = @ForeignKey(name = "FK_ORDERDETAIL_ORDER"))
    private Order orderId;

    @Id
    @ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductId", foreignKey = @ForeignKey(name = "FK_ORDERDETAIL_PRODUCT"))
    private Product productId;

    private int quantity;

}
