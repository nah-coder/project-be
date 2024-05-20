package com.example.projectbe.maytinhService;

import com.example.projectbe.entity.CartItem;

import java.util.Collection;

public interface Shopping_cartService {
    void add(CartItem item);

    void remove(int id);

    CartItem update(int proid, int qty);

    void clear();

    Collection<CartItem> getAllItem();

    int getCount();

    double getTotal();
}
