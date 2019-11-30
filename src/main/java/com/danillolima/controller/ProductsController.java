/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danillolima.controller;

import com.danillolima.dao.ProductDAO;
import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Danillo Lima <danillo@alunos.utfpr.edu.br>
 */
@Path("products/")
public class ProductsController {
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public ProductsController() {
    }

    /**
     * Retrieves representation of an instance of com.danillolima.controller.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        ProductDAO productDao = new ProductDAO();
        Gson gson;
        gson = new Gson();
        String content = gson.toJson(productDao.allProducts()); 
        return content;
    }
    
    @Path("search")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchByStack(final @QueryParam("market") @DefaultValue("-1") String market,
        final @QueryParam("stack") @DefaultValue("-1") String stack) {
              
        ProductDAO productDao = new ProductDAO();
        Gson gson;
        gson = new Gson();
        String content;  
        if(stack.contentEquals("-1") && stack.contentEquals("-1")) {
            content = gson.toJson(productDao.allProducts()); 
        } else {
           content = gson.toJson(productDao.searchWithFilters(stack, market));
        }
            
        return Response.status(200).entity(content).build();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(String content) {
 
    }
}
