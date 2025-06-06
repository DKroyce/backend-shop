package com.example.Groceris.Controllers;

import com.example.Groceris.model.Product;
import com.example.Groceris.service.GroceryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class GroceryController {
    @Autowired
    GroceryService service;

    @GetMapping("/")
    public String greet(){
        return "welcome";
    }
    @GetMapping("/groceries")
    public List<Product> getProduct(){
        return service.getProducts();

    }
    @GetMapping("/groceries/{id}")
    public Product getProductById(@PathVariable int id){
        return service.getProductById(id);
        }
    @PostMapping("/groceries")
    public ResponseEntity<?> addProducts( @RequestPart("product") String productJson, @RequestPart("imageFile") MultipartFile imageFile){



        try{
            ObjectMapper objectMapper = new ObjectMapper();
            Product product = objectMapper.readValue(productJson, Product.class);

            Product product1= service.addProducts(product,imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);

        }
        catch (Exception e){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/groceries/{id}/image")
    public ResponseEntity <byte[]> getImageFile(@PathVariable int id){
        Product product= service.getProductById(id);
        byte[] imageFile=product.getImageData();
        return  ResponseEntity.ok()
                .contentType(MediaType.valueOf(product.getImageType()))
                .body(imageFile);

    }
    @PutMapping("/groceries")
    public void updateproduct(@RequestBody Product product){
        service.updateProduct(product);
    }
@PutMapping("groceries/{id}/image")
    public ResponseEntity<?> updateImage(@PathVariable int id, @RequestPart("imageFile") MultipartFile imageFile){
       try{
        Product product1= service.updateimage(id,imageFile);
        return new ResponseEntity<>(product1, HttpStatus.CREATED);}
           catch (Exception e){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/groceries/{id}")
    public void deleteproduct(@PathVariable int id){
        service.deleteProduct(id);
    }





}
