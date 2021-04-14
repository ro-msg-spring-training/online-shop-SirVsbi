package ro.msg.learning.shop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.converter.ProductCategoryConverter;
import ro.msg.learning.shop.dto.ProductCategoryDto;
import ro.msg.learning.shop.response.MessageResponse;
import ro.msg.learning.shop.response.ProductCategoryResponse;
import ro.msg.learning.shop.service.interfaces.ProductCategoryService;

import java.util.ArrayList;

@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController {


    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductCategoryConverter productCategoryConverter;

    @GetMapping(value = "")
    public ProductCategoryResponse getAllProductCategories(){
        return new ProductCategoryResponse(
                (ArrayList<ProductCategoryDto>) productCategoryConverter.convertModelToDto(productCategoryService.getAllProductCategories())
        );
    }

    @PostMapping(value = "")
    public MessageResponse addSupplier(@RequestBody ProductCategoryDto productCategoryDto){
        try{
            productCategoryService.addProductCategory(productCategoryConverter.dtoToModel(productCategoryDto));
            return new MessageResponse("Adding data successful");
        } catch (Exception e) {
            return new MessageResponse("Adding data failed");
        }
    }
}
