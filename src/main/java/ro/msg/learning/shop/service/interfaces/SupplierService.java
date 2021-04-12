package ro.msg.learning.shop.service.interfaces;

import ro.msg.learning.shop.dto.SupplierDto;

import java.util.List;

public interface SupplierService {
    List<SupplierDto> getAllSuppliers();

    void addSupplier(SupplierDto supplier);

    SupplierDto getSupplierById(Long id);

    SupplierDto updateSupplier(Long id, SupplierDto supplierDto);

    void deleteSupplier(Long id);

}
