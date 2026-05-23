package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product product1 = new Product("Товар1", 100);
        Product product2 = new Product("Товар2", 200);
        Product product3 = new Product("Товар3", 150);

        ProductBasket basket = new ProductBasket();

        // Добавление продукта в корзину
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);

        // Добавление продукта в заполненную корзину
        for (int i = 0; i < 5; i++) {
            basket.addProduct(new Product("ДопТовар" + i, 50));
        }

        // Печать содержимого корзины с несколькими товарами
        basket.printBasket();

        // Получение стоимости корзины с несколькими товарами
        System.out.println("Стоимость корзины: " + basket.getTotalCost());

        // Поиск товара, который есть в корзине
        System.out.println("Корзина содержит Товар1: " + basket.containsProduct("Товар1"));

        // Поиск товара, которого нет в корзине
        System.out.println("Корзина содержит ОтсутствующийТовар: " + basket.containsProduct("ОтсутствующийТовар"));

        // Очистка корзины
        basket.clear();

        // Печать содержимого пустой корзины
        basket.printBasket();

        // Получение стоимости пустой корзины
        System.out.println("Стоимость пустой корзины: " + basket.getTotalCost());

        // Поиск товара по имени в пустой корзине
        System.out.println("Корзина содержит Товар1 в пустой корзине: " + basket.containsProduct("Товар1"));
    }
}