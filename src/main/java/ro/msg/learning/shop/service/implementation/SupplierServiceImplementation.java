package ro.msg.learning.shop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.msg.learning.shop.converter.SupplierConverter;
import ro.msg.learning.shop.dto.SupplierDto;
import ro.msg.learning.shop.exceptions.NotFoundException;
import ro.msg.learning.shop.repository.SupplierRepository;
import ro.msg.learning.shop.service.interfaces.SupplierService;

import java.util.List;

@Service
public class SupplierServiceImplementation implements SupplierService {

    @Autowired
    private SupplierConverter supplierConverter;

    @Autowired
    private SupplierRepository repository;

    @Override
    public List<SupplierDto> getAllSuppliers() {
        return supplierConverter.convertModelToDto(this.repository.findAll());
    }

    @Override
    public void addSupplier(SupplierDto supplierDto) {
        this.repository.save(this.supplierConverter.dtoToModel(supplierDto));
    }


    @Override
    public SupplierDto getSupplierById(Long id) {
        return this.repository.findById(id).map(supplier -> this.supplierConverter.modelToDto(supplier)
        ).orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public SupplierDto updateSupplier(Long id, SupplierDto supplierDto) {
        return this.supplierConverter.modelToDto(
                repository.findById(id)
                        .map(
                                supplier -> {
                                    supplier.setName(supplierDto.getName());
                                    return repository.save(supplier);
                                })
                        .orElseGet(() -> this.repository.save(this.supplierConverter.dtoToModel(supplierDto))
                        ));
    }

    @Override
    public void deleteSupplier(Long id) {
        if (!this.repository.existsById(id))
            throw new NotFoundException(id);
        this.repository.deleteById(id);
    }
}
