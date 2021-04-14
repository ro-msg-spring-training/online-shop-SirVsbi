package ro.msg.learning.shop.model;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;


@Data
public class OrderDetailKey implements Serializable {

    @Column(name = "OrderId")
    private Long orderId;


    @Column(name = "ProductId")
    private Long productId;


}
