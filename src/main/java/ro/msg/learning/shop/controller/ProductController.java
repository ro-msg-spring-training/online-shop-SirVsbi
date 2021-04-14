package ro.msg.learning.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.converter.ProductConverter;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.response.ListResponse;
import ro.msg.learning.shop.response.MessageResponse;
import ro.msg.learning.shop.service.interfaces.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private ProductService productService;

    @Autowired
    private ProductConverter productConverter;


    @GetMapping(value = "")
    public ListResponse<ProductDto> getAllProducts(){
        return new ListResponse<>(
                productConverter.convertModelToDto(productService.getAllProducts())
        );
    }

    @PostMapping(value = "")
    public MessageResponse addProduct(@RequestBody ProductDto productDto){
        try{
            productService.addProduct(productConverter.dtoToModel(productDto));
            return new MessageResponse("Adding data successful");
        }catch (Exception e) {
            return new MessageResponse("Adding data failed");
        }
    }
}
