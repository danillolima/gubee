/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danillolima.dao;

import com.danillolima.models.Product;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Danillo Lima <danillo@alunos.utfpr.edu.br>
 */
public class ProductDAO {
    private List<Product> database;
    public ProductDAO(){
        database = new ArrayList<Product>();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(
            new FileInputStream(System.getProperty("user.dir") + "\\database.json"), "UTF-8"));
            String st, content ="";
            while ((st = br.readLine()) != null){ 
              content += st;
            }
            Gson gson = new Gson();
            try{
                Product products[] = gson.fromJson(content, Product[].class);
                for(Product temp: products){
                    database.add(temp);
                }
            }catch(JsonSyntaxException e){
                System.out.println(e);
            }
           
        } catch(Exception e){
            System.out.println("Erro lendo arquivo");
        }
    } 
    public List<Product> allProducts(){
       return database;
    }
    
    public boolean addProduct(Product newProduct){
        database.add(newProduct);
        return true;
    }
    
    public List<Product> searchWithFilters(String stack, String market){
        List<Product> products;
        products = new ArrayList<Product>();
        Stream<Product> streamDatabase = database.stream();
        products = streamDatabase.filter(!stack.contentEquals("Todos") ?
                p -> p.getStack().contains(stack) : p -> true)
                .filter(!market.contentEquals("Todos") ?
                p -> p.getTargetMarket().contains(market) : p->true)
                .collect(Collectors.toList());
        return products;
    }   
}