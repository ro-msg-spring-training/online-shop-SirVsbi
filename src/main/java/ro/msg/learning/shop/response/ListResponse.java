package ro.msg.learning.shop.response;

import lombok.*;
import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ListResponse<T> {
    private List<T> response;
}
