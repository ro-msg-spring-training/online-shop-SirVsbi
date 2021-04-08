package ro.msg.learning.shop.response;

import lombok.*;
import ro.msg.learning.shop.dto.ProductCategoryDto;

import java.util.ArrayList;

@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ListResponse<T> {
    private ArrayList<T> response;
}
