package ru.netology.inheritance.Product.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.inheritance.Product.Book;
import ru.netology.inheritance.Product.Product;
import ru.netology.inheritance.Product.Smartphone;
import ru.netology.inheritance.Product.repository.Repository;

public class ProductManagerTest {
    Product product1 = new Product(1, "product1", 250);
    Product product2 = new Product(2, "product2", 300);
    Product product3 = new Product(3, "product3", 350);
    Book product4 = new Book(4,"book1", 100, "author1");
    Book product5 = new Book(5,"book2", 150, "author2");
    Book product6 = new Book(6,"book3", 200, "author3");
    Smartphone product7 = new Smartphone(7,"smartphone1", 1000,"manufacturer1");
    Smartphone product8 = new Smartphone(8,"smartphone2", 1100,"manufacturer2");
    Smartphone product9 = new Smartphone(9,"smartphone3", 1200,"manufacturer3");

    Repository repo = new Repository();
    ProductManager manager = new ProductManager(repo);


    @Test
    public void shouldAddProduct(){
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
        manager.add(product7);
        manager.add(product8);
        manager.add(product9);


        Product[] expexted = {product1, product2, product3, product4, product5, product6, product7, product8, product9};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expexted, actual);

    }
    @Test
    public void searchByName(){

        Product[] expected = {product5};
        Product[] actual = manager.searchBy("product5");
        Assertions.assertArrayEquals(expected, actual);
    }

}
