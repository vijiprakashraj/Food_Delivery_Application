package com.foodApplication.pack;

import com.dao.foodApplication.model.CartItem;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer, CartItem> cart;

    public Cart() {
        this.cart = new HashMap<>();
    }

    // Add Item
    public void addItem(int itemId, int restaurantId, String name, int quantity, double price) {
        if (cart.containsKey(itemId)) {
            CartItem existingItem = cart.get(itemId);
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
        } else {
            CartItem newItem = new CartItem(itemId, restaurantId, name, quantity, price);
            cart.put(itemId, newItem);
        }
    }

    // Update Item
    public void updateItem(int itemId, int quantity) {
        if (cart.containsKey(itemId)) {
            CartItem item = cart.get(itemId);
            item.setQuantity(quantity);
            if (quantity <= 0) {
                cart.remove(itemId); // Remove if quantity is zero or less
            }
        } else {
            System.out.println("Item with ID " + itemId + " not found in the cart.");
        }
    }

    // Remove Item
    public void removeItem(int itemId) {
        if (cart.containsKey(itemId)) {
            cart.remove(itemId);
        } else {
            System.out.println("Item with ID " + itemId + " not found in the cart.");
        }
    }

    // Get Item
    public CartItem getItem(int itemId) {
        return cart.get(itemId); // Returns null if item doesn't exist
    }

    // Clear Cart
    public void clearCart() {
        cart.clear();
        System.out.println("Cart has been cleared.");
    }

    // View Cart
    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Cart Contents:");
            for (CartItem item : cart.values()) {
                System.out.println(item);
            }
        }
    }
}
