/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danillolima.dao;

import com.danillolima.models.Product;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Danillo Lima <danillo@alunos.utfpr.edu.br>
 */
public class ProductDAOTest {
    
    public ProductDAOTest() {
    
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of allProducts method, of class ProductDAO.
     */
    @Test
    public void testAllProducts() {
        System.out.println("allProducts");
        ProductDAO instance = new ProductDAO("Teste");
        List<Product> result = instance.allProducts();
        assertEquals(0, result.size());
    }

    /**
     * Test of addProduct method, of class ProductDAO.
     */
    @Test
    public void testAddProduct() {
        System.out.println("addProduct");
        Product newProduct = new Product();
        ProductDAO instance = new ProductDAO("Teste");
        boolean result = instance.addProduct(newProduct);
        assertEquals(true, result);
        assertEquals(1, instance.allProducts().size());
    }
    
        /**
     * Test of searchWithFilters method, of class ProductDAO.
     */
    @Test
    public void testSearchWithFilters() {
        System.out.println("searchWithFilters");
        ProductDAO instance = new ProductDAO("Teste");
        for(int i = 0; i < 5; i++){
            Product newProduct = new Product();
            newProduct.setStack(new ArrayList());
            newProduct.setTargetMarket(new ArrayList());
            newProduct.getStack().add("Teste "+i);
            newProduct.getTargetMarket().add("Teste "+i+1);
            instance.addProduct(newProduct);
        }
        List<Product> result = instance.searchWithFilters("Java", "Teste");
        assertEquals(0, result.size());
        result = instance.searchWithFilters("Teste 1", "Todos");
        assertEquals(1, result.size());
        result = instance.searchWithFilters("Todos", "Todos");
        assertEquals(5, result.size());
        result = instance.searchWithFilters("Teste 100", "Todos");
        assertEquals(0, result.size());
    }  
}
