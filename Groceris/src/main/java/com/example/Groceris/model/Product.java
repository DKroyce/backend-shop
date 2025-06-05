package com.example.Groceris.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Product {
    @Override
    public String toString() {
        return "Product{" +
                "prodid=" + prodid +
                ", prodname='" + prodname + '\'' +
                ", prodDesc='" + prodDesc + '\'' +
                ", quantity=" + quantity +
                ", category='" + category + '\'' +
                ", prodUnit='" + prodUnit + '\'' +
                ", prodamount=" + prodamount +
                '}';
    }
    @Id
    int prodid;
    String prodname;

    String prodDesc;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public Product() {

    }

    String imageName;
    String imageType;
    @Lob
    byte[] imageData;



    int quantity;
    String category;

    public int getProdid() {
        return prodid;
    }

    public void setProdid(int prodid) {
        this.prodid = prodid;
    }

    public String getProdname() {
        return prodname;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProdUnit() {
        return prodUnit;
    }

    public void setProdUnit(String prodUnit) {
        this.prodUnit = prodUnit;
    }

    public int getProdamount() {
        return prodamount;
    }

    public void setProdamount(int prodamount) {
        this.prodamount = prodamount;
    }

    public Product(int prodid, String prodname, String prodDesc, int quantity, String category, String prodUnit, int prodamount,String imageName, String imageType, byte[] imageData) {
        this.prodid = prodid;
        this.prodname = prodname;
        this.prodDesc = prodDesc;
        this.quantity = quantity;
        this.category = category;
        this.prodUnit = prodUnit;
        this.prodamount = prodamount;
        this.imageName = imageName;
        this.imageType = imageType;
        this.imageData = imageData;
    }

    String prodUnit;
    int prodamount;

}
