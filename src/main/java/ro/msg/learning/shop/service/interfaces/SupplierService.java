package ro.msg.learning.shop.service.interfaces;

import ro.msg.learning.shop.model.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    List<Supplier> getAllSuppliers();

    void addSupplier(Supplier supplier);

    Optional<Supplier> getSupplierById(Long id);

}
