package com.kkachniarz.springproject.services;

import com.kkachniarz.springproject.components.ShoppingCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Messages {

    @Autowired
    ShoppingCard shoppingCard;

    public String getCountOfProductsInShoppingCard() {
        return "Products in shopping card: " + shoppingCard.getCountOfProductsInShoppingCard();
    }
}
