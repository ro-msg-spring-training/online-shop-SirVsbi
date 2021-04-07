package ro.msg.learning.shop.converter;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.SupplierDto;
import ro.msg.learning.shop.model.Supplier;

@Component
public class SupplierConverter extends AbstractConverter<Supplier, SupplierDto> {

    public Supplier dtoToModel(SupplierDto supplierDto) {
        return Supplier.builder()
                .supplierId(supplierDto.getSupplierId())
                .name(supplierDto.getName())
                .build();
    }

    public SupplierDto modelToDto(Supplier supplier) {
        return SupplierDto.builder()
                .supplierId(supplier.getSupplierId())
                .name(supplier.getName())
                .build();
    }
}
