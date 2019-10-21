package com.kkachniarz.springproject.controller;


import com.kkachniarz.springproject.components.ShoppingCard;
import com.kkachniarz.springproject.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "product")
public class ProductController {

    @Autowired
    private ShoppingCard shoppingCard;

    @PostMapping(value = "/add")
    public HttpStatus addProductToShoppingCard(@RequestBody Product product) {

        try {
            shoppingCard.addProductToShoppingCard(product);
            return HttpStatus.ACCEPTED;
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @GetMapping(value = "/product-list")
    public List<Product> getProductList() {
        List<Product> productList = shoppingCard.showAllProductsInShoppingCard();
        return productList;
    }


}
