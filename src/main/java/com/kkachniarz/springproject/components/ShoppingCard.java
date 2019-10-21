package com.kkachniarz.springproject.components;

import com.kkachniarz.springproject.models.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Component
public class ShoppingCard {
    private List<Product> productList;

    public ShoppingCard() {
        this.productList = new ArrayList<Product>();
    }

    public void addProductToShoppingCard(Product product) {
        product.id = UUID.randomUUID();
        productList.add(product);
    }

    public List<Product> showAllProductsInShoppingCard() {
        return productList;
    }

    public int getCountOfProductsInShoppingCard() {
        return productList.size();
    }

}
