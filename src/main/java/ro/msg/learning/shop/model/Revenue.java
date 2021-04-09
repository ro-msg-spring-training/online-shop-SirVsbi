package ro.msg.learning.shop.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "revenue")
@EqualsAndHashCode
@ToString
public class Revenue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long revenueId;

    @ManyToOne(targetEntity = Location.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "LocationId")
    private Location location;

    private LocalDateTime date;

    private BigDecimal sum;
}
