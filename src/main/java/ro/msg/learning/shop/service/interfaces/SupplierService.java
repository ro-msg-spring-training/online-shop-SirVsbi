package ro.msg.learning.shop.service.interfaces;

import ro.msg.learning.shop.model.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> getAllSuppliers();

    void addSupplier(Supplier supplier);


}
