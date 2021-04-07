package ro.msg.learning.shop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.converter.SupplierConverter;
import ro.msg.learning.shop.dto.SupplierDto;
import ro.msg.learning.shop.response.MessageResponse;
import ro.msg.learning.shop.response.SupplierResponse;
import ro.msg.learning.shop.service.interfaces.SupplierService;

import java.util.ArrayList;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private SupplierConverter supplierConverter;


    @GetMapping(value = "")
    public SupplierResponse getAllSuppliers(){
        return new SupplierResponse(
                (ArrayList<SupplierDto>) supplierConverter.convertModelToDto(supplierService.getAllSuppliers())
        );
    }

    @PostMapping(value = "")
    public MessageResponse addSupplier(@RequestBody SupplierDto supplierDto){
        try{
            supplierService.addSupplier(supplierConverter.dtoToModel(supplierDto));
            return new MessageResponse("Adding data successful");
        } catch (Exception e) {
            return new MessageResponse("Adding data failed");
        }
    }

}
