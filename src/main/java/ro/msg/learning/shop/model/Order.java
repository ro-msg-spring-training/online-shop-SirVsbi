package ro.msg.learning.shop.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "order")
@EqualsAndHashCode
@ToString
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderId")
    private Long orderId;

    private LocalDateTime createdAt;

    @ManyToOne(targetEntity = Location.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "LocationId", foreignKey = @ForeignKey(name = "FK_ORDER_LOCATION"))
    private Location shippedFrom;


    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerId", foreignKey = @ForeignKey(name = "FK_ORDER_CUSTOMER"))
    private Customer customer;

    @ManyToOne(targetEntity = Address.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "AddressId", foreignKey = @ForeignKey(name = "FK_ORDER_ADDRESS"))
    private Address shippingAddress;
}
