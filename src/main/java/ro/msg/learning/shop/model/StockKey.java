package ro.msg.learning.shop.model;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;


@Data
public class StockKey implements Serializable {
    @Column(name = "ProductId")
    private Long productId;

    @Column(name = "LocationId")
    private Long locationId;
}
