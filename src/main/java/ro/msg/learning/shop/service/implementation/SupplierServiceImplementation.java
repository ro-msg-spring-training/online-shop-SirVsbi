package ro.msg.learning.shop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.model.Supplier;
import ro.msg.learning.shop.repository.SupplierRepository;
import ro.msg.learning.shop.service.interfaces.SupplierService;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImplementation implements SupplierService {

    @Autowired
    private SupplierRepository repository;

    @Override
    public List<Supplier> getAllSuppliers() {
        return this.repository.findAll();
    }

    @Override
    public void addSupplier(Supplier supplier) {
        this.repository.save(supplier);
    }

    @Override
    public Optional<Supplier> getSupplierById(Long id) {
        return this.repository.findById(id);
    }
}
