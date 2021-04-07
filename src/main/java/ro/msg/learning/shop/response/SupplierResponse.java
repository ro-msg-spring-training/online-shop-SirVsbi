package ro.msg.learning.shop.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.dto.SupplierDto;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierResponse {
    private ArrayList<SupplierDto> suppliers;
}
