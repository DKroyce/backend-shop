package com.example.Groceris.service;

import com.example.Groceris.model.Product;
import com.example.Groceris.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class GroceryService {
    @Autowired
    ProductRepo repo;
  //  List<Product> products= new ArrayList<>( Arrays.asList(new Product(1,"tomato","A needed vegies",500,"vegies","kg",400),new Product(2,"potato","A needed vegies",300,"vegies","kg",100)));
    public List<Product> getProducts(){
        return repo.findAll();
    }
    public  Product getProductById(int id){
        return repo.findById(id).orElse(new Product());
    }
    public Product addProducts(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }
    public void updateProduct(Product product){
        repo.save(product);

    }
    public Product updateimage(int id, MultipartFile imageFile)throws IOException{

        getProductById(id).setImageName(imageFile.getOriginalFilename());
        getProductById(id).setImageType(imageFile.getContentType());
        getProductById(id).setImageData(imageFile.getBytes());
        return repo.save(getProductById(id));

    }


    public void deleteProduct(int id) {
        repo.deleteById(id);
    }
}
