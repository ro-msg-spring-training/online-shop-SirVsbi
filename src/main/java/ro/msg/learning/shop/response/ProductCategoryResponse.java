package ro.msg.learning.shop.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.dto.ProductCategoryDto;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryResponse {
    private ArrayList<ProductCategoryDto> productCategories;
}
