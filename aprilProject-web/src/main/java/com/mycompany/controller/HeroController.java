/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.DTO.Hero;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ramen
 */
@Path("/heroes")
public class HeroController {

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hero> getHeros(){
         ArrayList<Hero> heroList = new ArrayList<>();

        heroList.add(new Hero(11, "Mr. Nice"));
        heroList.add(new Hero(12, "Narco"));
        heroList.add(new Hero(13, "Bombasto"));
        heroList.add(new Hero(14, "Celeritas"));
        heroList.add(new Hero(15, "Magneta"));
        heroList.add(new Hero(16, "RubberMan"));
        heroList.add(new Hero(17, "Tornado"));
//        GenericEntity<List<Hero>> entity = new GenericEntity<List<Hero>>(heroList){};
//        System.out.println("Returning Heroes list" + entity);
        System.out.println("Returning list of heroes");
        return heroList;

    }
}
