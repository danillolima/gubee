/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danillolima.dao;

import com.danillolima.models.Product;
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
        ProductDAO instance = new ProductDAO();
        List<Product> expResult = null;
        List<Product> result = instance.allProducts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addProduct method, of class ProductDAO.
     */
    @Test
    public void testAddProduct() {
        System.out.println("addProduct");
        Product newProduct = null;
        ProductDAO instance = new ProductDAO();
        boolean expResult = false;
        boolean result = instance.addProduct(newProduct);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    
}
