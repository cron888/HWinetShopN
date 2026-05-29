package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products = new Product[5];
    private int size = 0;

    public void addProduct(Product product) {
        if (size >= products.length) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        products[size++] = product;
    }

    public int getTotalCost() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    public void printBasket() {
        if (size == 0) {
            System.out.println("в корзине пусто");
            return;
        }
        int specialCount = 0;
        for (int i = 0; i < size; i++) {
            Product product = products[i];
            System.out.println(product.toString());
            if (product.isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean containsProduct(String name) {
        for (int i = 0; i < size; i++) {
            if (products[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            products[i] = null;
        }
        size = 0;
    }
}