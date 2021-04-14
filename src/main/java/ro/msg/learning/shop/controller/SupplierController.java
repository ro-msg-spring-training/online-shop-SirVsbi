package ro.msg.learning.shop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ro.msg.learning.shop.dto.SupplierDto;
import ro.msg.learning.shop.exceptions.NotFoundException;
import ro.msg.learning.shop.response.ListResponse;
import ro.msg.learning.shop.response.MessageResponse;
import ro.msg.learning.shop.service.interfaces.SupplierService;


@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;


    @GetMapping(value = "")
    public ListResponse<SupplierDto> getAllSuppliers() {
        return new ListResponse<>(supplierService.getAllSuppliers()
        );
    }


    //This exception handling could be done with a ControllerAdvice
    //which is a global solution for this, so less code repetition
    @GetMapping(value = "/{id}")
    public SupplierDto getSupplierById(@PathVariable Long id) {
        try {
            return supplierService.getSupplierById(id);
        } catch (Exception notFound) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, notFound.getMessage()
            );
        }

    }

    @PostMapping(value = "")
    public MessageResponse addSupplier(@RequestBody SupplierDto supplierDto) {
        try {
            supplierService.addSupplier(supplierDto);
            return new MessageResponse("Adding data successful");
        } catch (Exception e) {
            return new MessageResponse("Adding data failed");
        }
    }

    @PutMapping("/{id}")
    public SupplierDto updateSupplier(@PathVariable Long id, @RequestBody SupplierDto supplierDto) {
        return this.supplierService.updateSupplier(id, supplierDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Long id) {
        try {
            this.supplierService.deleteSupplier(id);
            return new ResponseEntity<>("Supplier deleted", HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>("No supplier found with given id", HttpStatus.NOT_FOUND);
        }
    }

}

