package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // Демонстрация проверок
        try {
            new SimpleProduct("", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании товара: " + e.getMessage());
        }

        try {
            new SimpleProduct("Товар1", -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании товара: " + e.getMessage());
        }

        try {
            new DiscountedProduct("Товар2", 200, 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании товара со скидкой: " + e.getMessage());
        }

        SimpleProduct product1 = new SimpleProduct("Товар1", 100);
        DiscountedProduct product2 = new DiscountedProduct("Товар2", 200, 10);
        FixPriceProduct product3 = new FixPriceProduct("Товар3");

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

        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);

        Article article1 = new Article("Статья про Товар1", "Подробное описание и обзор Товар1");
        Article article2 = new Article("Скидки на Товар2", "Акция на Товар2 до конца месяца");
        Article article3 = new Article("Новинка", "Представляем новинку — Товар3 по фиксированной цене");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);

        // Тестирование поиска
        System.out.println("\n--- Поиск по запросу 'Товар1' ---");
        System.out.println(Arrays.toString(searchEngine.search("Товар1")));

        System.out.println("\n--- Поиск по запросу 'скидка' ---");
        System.out.println(Arrays.toString(searchEngine.search("скидка")));

        System.out.println("\n--- Поиск по запросу 'новинка' ---");
        System.out.println(Arrays.toString(searchEngine.search("новинка")));

        System.out.println("\n--- Поиск по запросу 'xyz' (не найдено) ---");
        System.out.println(Arrays.toString(searchEngine.search("xyz")));

        // Демонстрация поиска лучшего совпадения
        System.out.println("\n--- Поиск лучшего совпадения для 'Товар1' ---");
        try {
            System.out.println(searchEngine.findBestMatch("Товар1"));
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n--- Поиск лучшего совпадения для 'xyz' (не найдено) ---");
        try {
            System.out.println(searchEngine.findBestMatch("xyz"));
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}